package oope2017ht;
import oope2017ht.tiedot.*;
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

    // Käytetyt Hakemistot. Käytetään liikkumiseen ja kutsumiseen.
    private Hakemisto nykyHakemisto;
    private Hakemisto juuriHakemisto;

    // Käyttöliittymässä näkyvä polku. StringBuilder tekee elämästä helppoa!
    private StringBuilder polku = new StringBuilder("");

    // Luodaan root (= juuri)hakemisto. Tämä metodi ajetaan vain kerran.
    public void luoRoot(){
        nykyHakemisto = new Hakemisto(new StringBuilder("root"), null);
        juuriHakemisto = nykyHakemisto;
    }

    // Luetaan polku. Käyttöliittymä kutsuu tätä.
    public void luePolku(){
        System.out.print(polku);
    }

    // Varsinainen työläinen luokassa. Input tulee käyttöliittymästä ja tämä
    // poika tulkkaa sen. Riippuen annetusta syötteestä metodi tekee eri
    // asioita, kuten tiedoston luontia tai kansion vaihtoa.
    public int tulkkaa(String input){

        String[] para = input.split(" ");
        String komento = para[0];

        if (komento.equals(EXIT)) {
            return 0;
        }

        else if (komento.equals(MAKEDIR)) {
            if (para.length >= 2 && nykyHakemisto.hae(para[1]) == null)
                nykyHakemisto.lisaa(new Hakemisto(new StringBuilder(para[1]), nykyHakemisto));
            else
                System.out.println(VIRHE);
        }

        else if (komento.equals(LIST)) {
            if (para.length == 1 && nykyHakemisto != null)
                tulostaSisalto(nykyHakemisto.sisalto());
            else if (para.length >= 2 && para[1] != null && nykyHakemisto != null){
                for (int i = 0; i < nykyHakemisto.sisalto().koko(); i++) {
                    if (nykyHakemisto.sisalto().alkio(i).equals(nykyHakemisto.hae(para[1]))){
                        System.out.println(nykyHakemisto.sisalto().alkio(i));
                    }
                }
            }
        }

        else if (komento.equals(FIND)) {
            if (nykyHakemisto.sisalto().koko() > 0)
                puunTulostus(nykyHakemisto);
            else
                System.out.println("Tyhjää täynnä kun koitat FIND:iä käyttää!");
        }

        else if (komento.equals(REMOVE)) {
            if (para.length > 1){
                nykyHakemisto.poista(para[1]);
            }
        }

        else if (komento.equals(COPY)) {
            if (para.length >= 3) {
                Tiedosto apuTiedosto = new Tiedosto((Tiedosto)nykyHakemisto.hae(para[1]));
                apuTiedosto.asetaString(new StringBuilder(para[2]));
                nykyHakemisto.lisaa(new Tiedosto(apuTiedosto));
            }
            else
                System.out.println(VIRHE);
        }

        else if (komento.equals(RENAME)) {
            if (para.length >= 3)
            nykyHakemisto.hae(para[1]).muutaNimi(para[2]);
        }

        else if (komento.equals(MAKEFIL)) {
            if (para.length >= 3 && nykyHakemisto.hae(para[1]) == null ) {
                //  && para[2] != null && !para[2].isEmpty()
                int koko = Integer.parseInt(para[2]);
                nykyHakemisto.lisaa(new Tiedosto(new StringBuilder(para[1]), koko));
            }
            else
                System.out.println(VIRHE);
        }

        else if (komento.equals(CHANGEDIR)) {
            // Jos splitattu syöte on vain määritellyn kokoinen (1), siirrytään takaisin
            // juurihakemistoon.
            if (para.length == 1) {
                nykyHakemisto = juuriHakemisto;
                polku.delete(0, polku.length());
            // Muuten seurataan näitä ohjeita.
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
        // Jos oikeanlaista syötettä ei anneta, kertoo ohjelma siitä käyttäjlle varmasti.
        else{
            System.out.println(VIRHE);
        }
        return 1;
    }

    // Metodi listan tulostamiseen.
    private static void tulostaSisalto(LinkitettyLista lista) {
        if (lista != null) {
            for (int i = 0; i < lista.koko(); i++) {
                System.out.println(lista.alkio(i));
            }
        }
    }

    // Tulostaa tiedostopuun siitä hakemistosta
    // lähtien missä käyttäjä sillä hetkellä on.
    public void puunTulostus(Hakemisto hakemisto){
        int i = 0;
        while (i < hakemisto.sisalto().koko()) {
            // Tulostetaan alkio kerrallaan hakemiston sisältö
            System.out.println(hakemisto.sisalto().alkio(i));
            // Jos alkio kohdassa i on Hakemisto-tyyppinen, tulostetaan rekursiivisesti
            // tämän sisältö, jonka jälkeen palataan jatkamaan edellinen tulostus
            // loppuun.
            if (hakemisto.sisalto().alkio(i) instanceof Hakemisto)
                puunTulostus((Hakemisto)hakemisto.sisalto().alkio(i));
            i++;
        }
    }
}

// Hautausmaa. Yritän muistaa poistaa tämän lopullista palautusta tehdessä.
/*int laskuri = 0;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == ' ')
                laskuri++;
        }
        if (input.length() == 3 && laskuri > 0){
            //System.out.println(VIRHE);
        }*/

