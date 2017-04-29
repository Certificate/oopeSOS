package oopeSOS;
import tiedot.*;
import fi.uta.csjola.oope.lista.*;
/**
 *  Komentoja tulkkaava tulkki :) .
 */
public class Komentotulkki {
    // Alla kaikki harjoitustyössä käytettävät komennot
    // katso dokumentaatio
    private static final String MAKEDIR = "md";
    private static final String MAKEFIL = "mf";
    private static final String CHANGEDIR = "cd";
    private static final String LIST = "ls";
    private static final String FIND = "find";
    private static final String REMOVE = "rm";
    private static final String COPY = "cp";
    private static final String RENAME = "mv";
    private static final String EXIT = "exit";
    // Vakioitu virhe.
    private static final String VIRHE = "Error!";
    private Hakemisto nykyHakemisto;
    private Hakemisto juuriHakemisto;
    // Käyttöliittymässä näkyvä polku.
    private StringBuilder polku = new StringBuilder("");
    // Luodaan root (= juurihakemisto). Tämä metodi ajetaan kerran.
    public void luoRoot(){
        nykyHakemisto = new Hakemisto(new StringBuilder("root"), null);
        juuriHakemisto = nykyHakemisto;
    }

    // Varsinainen työläinen luokassa. Input tulee käyttöliittymästä ja tämä
    // poika tulkkaa sen. Riippuen annetusta syötteestä metodi tekee eri
    // asioita, kuten tiedoston luontia tai kansion vaihtoa.
    public int tulkkaa(String input){

        int laskuri = 0;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == ' ')
                laskuri++;
        }

        if (input.length() == 3 && laskuri > 0){
            //System.out.println(VIRHE);
        }
        else {
            String[] para = input.split(" ");
            String komento = para[0];

            if (komento.equals(EXIT)) {
                return 0;
            } else if (komento.equals(MAKEDIR)) {
                if (para.length >= 2)
                    nykyHakemisto.lisaa(new Hakemisto(new StringBuilder(para[1]), nykyHakemisto));
                return 1;
            } else if (komento.equals(LIST)) {
                tulostaSisalto(nykyHakemisto.sisalto());
                return 1;
            } else if (komento.equals(FIND)) {
                if (para.length > 1){
                    System.out.println("FindMe Vittu");
                    System.out.println(nykyHakemisto.hae(para[1]));
                }
                return 1;
            } else if (komento.equals(REMOVE)) {
                if (para.length > 1){
                    nykyHakemisto.poista(para[1]);
                }
                return 1;
            } else if (komento.equals(COPY)) {
                return 1;
            } else if (komento.equals(RENAME)) {
                if (para.length >= 3)
                nykyHakemisto.hae(para[1]).muutaNimi(para[2]);
                return 1;
            }

            else if (komento.equals(MAKEFIL)) {
                if (para.length >= 3 && para[2] != null && !para[2].isEmpty()) {
                    int koko = 0;
                    if (laskuri >= 2)
                        koko = Integer.parseInt(para[2]);
                    nykyHakemisto.lisaa(new Tiedosto(new StringBuilder(para[1]), koko));
                    return 1;
                }
                else
                    System.out.println(VIRHE);
                return 1;
            }

            else if (komento.equals(CHANGEDIR)) {
                if (para.length == 1) {
                    nykyHakemisto = juuriHakemisto;
                    polku.delete(0, polku.length());
                } else {
                    if (nykyHakemisto.toSimpleName().equals("root") && para[1].equals("..")) {
                        System.out.println(VIRHE);
                    } else {
                        if (para[1].equals("..")) {
                            polku.delete(polku.length() - nykyHakemisto.toSimpleName().length() - 1, polku.length());
                            nykyHakemisto = nykyHakemisto.haeYli();
                        } else if (nykyHakemisto.hae(para[1]) != null) {
                            nykyHakemisto = (Hakemisto) nykyHakemisto.hae(para[1]);
                            polku.append("/" + para[1]);
                        } else
                            System.out.println(VIRHE);
                    }
                }
            }
            else{
                System.out.println("Ei tuettu komento");
            }
            return 1;
        }
        System.out.println(VIRHE);
        return 1;
    }
    public void luePolku(){
        System.out.print(polku);
    }
    
    private static void tulostaSisalto(LinkitettyLista lista) {
        if (lista != null) {
            for (int i = 0; i < lista.koko(); i++) {
                System.out.println(lista.alkio(i));
            }
        }
    }

}

