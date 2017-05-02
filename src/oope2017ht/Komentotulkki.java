package oope2017ht;
import oope2017ht.tiedot.*;
import fi.uta.csjola.oope.lista.*;

/**
 * <p>
 * Komentoja tulkkaava komentotulkki!
 * <p>
 * @author Valtteri Vuori (vuori.valtteri.j@student.uta.fi),
 * Tietojenkäsittelytiede, Tampereen yliopisto.
 */
class Komentotulkki {

    /** Alla kaikki harjoitustyössä käytettävät komennot katso dokumentaatio */


    private static final String MAKEDIR = "md";
    private static final String MAKEFIL = "mf";
    private static final String CHANGEDIR = "cd";
    private static final String LIST = "ls";
    private static final String FIND = "find";
    private static final String REMOVE = "rm";
    private static final String COPY = "cp";
    private static final String RENAME = "mv";
    private static final String EXIT = "exit";

    /** Vakioitu virhe. */
    private static final String VIRHE = "Error!";

    /** Käytetyt Hakemistot. Käytetään liikkumiseen ja kutsumiseen. */
    private Hakemisto nykyHakemisto;
    private Hakemisto juuriHakemisto;

    /** Käyttöliittymässä näkyvä polku. StringBuilder tekee elämästä helppoa! */
    private StringBuilder polku = new StringBuilder("");

    /** Tarkastaja-olio */
    private Tarkistaja tarkastaja = new Tarkistaja();

    /** Luodaan root (= juuri)hakemisto. Tämä metodi ajetaan vain kerran. */
    void luoRoot(){
        nykyHakemisto = new Hakemisto(new StringBuilder("root"), null);
        juuriHakemisto = nykyHakemisto;
    }

    /** Luetaan polku. Käyttöliittymä kutsuu tätä. */
    void luePolku(){
        System.out.print(polku);
    }

    /** Varsinainen työläinen luokassa. Input tulee käyttöliittymästä ja tämä
    * poika tulkkaa sen. Riippuen annetusta syötteestä metodi tekee eri
    * asioita, kuten tiedoston luontia tai kansion vaihtoa.
     * @param input annettu syöte jonka ohjela tulkkaa ja muuttaa para-nimiseksi taulukoksi .split-komennon avulla.
     *
     * @return 1 jos ohjelma jatkaa, 0 jos ohjelman pitää lopettaa.
     */
    int tulkkaa(String input){

        String[] para = input.split(" ");
        String komento = para[0];

        /* "Svitskeissi" jolla määritellään mikä luokan metodi ajetaan
        annetun komentoparametrin avulla. Oli muuten eka kerta kun tein switch-casen!
        Paljon mukavamman näköinen kuin se hirveä if-else härpäke. */
        switch (komento) {
            case EXIT:
                return 0;
            case MAKEDIR:
                makeDir(para);
                break;
            case LIST:
                listaa(para);
                break;
            case FIND:
                find(para);
                break;
            case REMOVE:
                poista(para);
                break;
            case COPY:
                kopioi(para);
                break;
            case RENAME:
                rename(para);
                break;
            case MAKEFIL:
                makeFile(para);
                break;
            case CHANGEDIR:
                changeDir(para);
                break;
            /* Jos oikeanlaista syötettä ei anneta, kertoo ohjelma siitä käyttäjlle varmasti. */
            default:
                virhe();
                break;
        }
        /* Palauttaa ykkösen jos halutaan jatkaa käyttöliittymässä aloitettua silmukkaa. Vain EXIT-komento palauttaa arvon 0, lopettaen ohjelman toiminnan. */
        return 1;
    }

    /**Listaa joko nykyisen hakemiston tai yksittäisen tiedoston (parametrilla)
     * @param para on taulukko johon on säilötty komentona annettu syöte. Sisältää ainakin komennon. */
    private void listaa(String[] para){
        if (para.length == 1 && nykyHakemisto != null)
            tulostaSisalto(nykyHakemisto.sisalto());
        else if (para.length == 2 && para[1] != null && nykyHakemisto.hae(para[1]) != null){
            for (int i = 0; i < nykyHakemisto.sisalto().koko(); i++) {
                if (nykyHakemisto.sisalto().alkio(i).equals(nykyHakemisto.hae(para[1]))){
                    System.out.println(nykyHakemisto.sisalto().alkio(i));
                }
            }
        }
        else
            System.out.println(VIRHE);
    }

    /** Listaa kaiken nykyisestä hakemistosta eteenpäin tiedostopuuna.
     * @param para on taulukko johon on säilötty komentona annettu syöte. Sisältää ainakin komennon.*/
    private void find(String[] para){
        if (para.length == 1 && nykyHakemisto.sisalto().koko() > 0) {
            puunTulostus(nykyHakemisto);
        }
        else
            System.out.println("Error!");
    }

    /** Tiedoston poisto hakemistosta.
     * @param para on taulukko johon on säilötty komentona annettu syöte. Sisältää ainakin komennon.*/
    private void poista(String[] para){
        if (para.length == 2 && nykyHakemisto.hae(para[1]) != null){
            nykyHakemisto.poista(para[1]);
        }
        else
            virhe();
    }

    /** Tiedoston kopiointi. Syväkopioi, eikä aseta vain viitettä.
     * @param para on taulukko johon on säilötty komentona annettu syöte. Sisältää ainakin komennon.*/
    private void kopioi(String[] para){
        if (para.length == 3 &&
                nykyHakemisto.hae(para[2]) == null &&
                nykyHakemisto.hae(para[1]) != null &&
                nykyHakemisto.hae(para[1]) instanceof Tiedosto) {
            Tiedosto apuTiedosto = new Tiedosto((Tiedosto)nykyHakemisto.hae(para[1]));
            apuTiedosto.asetaString(new StringBuilder(para[2]));
            nykyHakemisto.lisaa(new Tiedosto(apuTiedosto));
        }
        else
            virhe();
    }
    /** Tiedoston uudelleennimeäminen. Jos samanniminen tiedosto on jo olemassa, heittää ohjelma erroria.
     * @param para on taulukko johon on säilötty komentona annettu syöte. Sisältää ainakin komennon.*/
    private void rename(String[] para){
        if (para.length == 3 &&
                nykyHakemisto.hae(para[2]) == null &&
                nykyHakemisto.hae(para[1]) != null &&
                nykyHakemisto.hae(para[1]) instanceof Tiedosto){
            kopioi(para);
            nykyHakemisto.poista(para[1]);
        }
        else if (para.length == 3 &&
                nykyHakemisto.hae(para[2]) == null &&
                nykyHakemisto.hae(para[1]) != null &&
                nykyHakemisto.hae(para[1]) instanceof Hakemisto){
            nykyHakemisto.hae(para[1]).muutaNimi(para[2]);
        }
        else
            virhe();
    }

    /** Tiedoston luonti. Muuttaa toisen parametrin int-arvoiseksi jonka jälkeen kutsuu Hakemiston lisaa-metodia.
     * @param para on taulukko johon on säilötty komentona annettu syöte. Sisältää ainakin komennon.*/
    private void makeFile(String[] para){
        if (para.length == 3 &&
                nykyHakemisto.hae(para[1]) == null &&
                tarkastaja.numeroTarkistus(para[2]) &&
                tarkastaja.pisteTarkistus(para[1])) {
            int koko = Integer.parseInt(para[2]);
            nykyHakemisto.lisaa(new Tiedosto(new StringBuilder(para[1]), koko));
        }
        else
            virhe();
    }

    /** Hakemiston luonti. Tarkistaa ettei samannimistä hakemistoa ole jo.
     * @param para on taulukko johon on säilötty komentona annettu syöte. Sisältää ainakin komennon.*/
    private void makeDir(String[] para){
        if (para.length == 2 &&
                nykyHakemisto.hae(para[1]) == null &&
                para[1].charAt(0) != '.' &&
                tarkastaja.pisteTarkistus(para[1]))
            nykyHakemisto.lisaa(new Hakemisto(new StringBuilder(para[1]), nykyHakemisto));
        else
            virhe();
    }

    /** Hakemistoa vaihtava metodi. Päivittää myös polun oikeaksi samalla.
     *
     * @param para on taulukko johon on säilötty komentona annettu syöte. Sisältää ainakin komennon.
     */
    private void changeDir(String[] para){
        // Jos splitattu syöte on vain määritellyn kokoinen (1), siirrytään takaisin
        // juurihakemistoon.
        if (para.length == 1) {
            nykyHakemisto = juuriHakemisto;
            polku.delete(0, polku.length());
            // Muuten seurataan näitä ohjeita.
        } else {
            if (nykyHakemisto.toSimpleName().equals("root") && para[1].equals("..") || para.length > 2) {
                virhe();
            } else {
                if (para[1].equals("..")) {
                    polku.delete(polku.length() - nykyHakemisto.toSimpleName().length() - 1, polku.length());
                    nykyHakemisto = nykyHakemisto.haeYli();
                } else if (nykyHakemisto.hae(para[1]) != null) {
                    nykyHakemisto = (Hakemisto) nykyHakemisto.hae(para[1]);
                    polku.append("/").append(para[1]);
                } else
                    virhe();
            }
        }
    }

    /** Metodi listan tulostamiseen.
     *
     * @param lista on LinkitettyLista jonka alkiot metodi tulostaa.
     */
    private static void tulostaSisalto(LinkitettyLista lista) {
        if (lista != null) {
            for (int i = 0; i < lista.koko(); i++) {
                System.out.println(lista.alkio(i));
            }
        }
    }

    /** Tulostaa tiedostopuun siitä hakemistosta lähtien missä käyttäjä sillä hetkellä on.
     *
     * @param hakemisto on Hakemisto tyyppinen parametri josta lähtien tehdään tiedostopuun tulostus.
     */
    private void puunTulostus(Hakemisto hakemisto){
        String polku = "";
        int i = 0;
        while(i < hakemisto.sisalto().koko()) {
            if(hakemisto.sisalto().alkio(i) instanceof Hakemisto) {
                polku = annaPolku((Hakemisto)hakemisto.sisalto().alkio(i));
            }
            else if(hakemisto.sisalto().alkio(i) instanceof Tiedosto){
                try{
                    polku = annaPolku(hakemisto) + hakemisto.toSimpleName() + "/";
                } catch(Exception e){
                    polku = "";
                }
            }
            System.out.println("/" + polku + hakemisto.sisalto().alkio(i));
            if(hakemisto.sisalto().alkio(i) instanceof Hakemisto) {
                puunTulostus((Hakemisto)hakemisto.sisalto().alkio(i));
            }
            i++;
        }
    }
    /** Virheen tulostus läpi luokan.
     * Melko itsensä selittävä, eikö?*/
    private void virhe(){
        System.out.println(VIRHE);
    }

    /** Polun tulostus find-silmukassa.
     * @param tama Hakemisto-tyyppinen parametri jonka kautta saadaan tulostettua hakemistopolku tehdessä tiedostopuun tulostusta.
     * @return hakemistopolku*/
    private String annaPolku(Hakemisto tama) {
        String hakemistopolku = "";
        while(tama != null){
            tama = tama.haeYli();
            if(tama.equals(juuriHakemisto)){
                break;
            }
            else {
                hakemistopolku = tama.toSimpleName() + "/" + hakemistopolku;
            }
        }
        return hakemistopolku;
    }
}


