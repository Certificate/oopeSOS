import Tiedot.Hakemisto;
import apulaiset.In;

/**
 *  Tämän työmaan teki Valtteri Vuori
 *  Vuori.Valtteri.J@student.uta.fi
 */


public class Kayttoliittyma {

    private static final String POLKU = "/>";

    private static final String MAKEDIR = "md";
    // luo parametrina annetulla nimellä alihakemiston nykyiseen
    // hakemistoon, jos samannimistä alihakemisto ei jo ole.

    private static final String MAKEFIL = "mf";
    // luo annetun nimisen ja kokoisen tiedoston nykyiseen
    // hakemistoon, jos samannimistä tiedostoa ei jo ole.

    private static final String CHANGEDIR = "cd";
    // asettaa yöhakemistoksi joko yli- tai alihakemiston, jos voidaan siirtyä.
    // Ylihakemistoon viitataan kahdella pisteellä.
    // Ilman parametria palataan juureen.

    private static final String LIST = "ls";
    // listaa näytölle annetun nimisen tiedoston tai hakemiston
    // tiedot, jos listauksen kohde löytyy nykyisestä hakemistosta.
    // Listaa nykyisen hakemiston sisällön, jos parametria ei anneta.

    private static final String FIND = "find";
    // listaa hakemiston rekursiivisesti esijärjestyksessä.

    private static final String REMOVE = "rm";
    // poistaa varmistamatta tiedoston tai hakemiston, jos sellainen on
    // nykyhakemistossa

    private static final String COPY = "cp";
    // kopioi tiedoston annetun nimiseksi uudeksi
    // tiedostoksi, jos nimellä löydetään tiedosto nykyhakemistosta
    // ja hakemistossa ei ole vielä uuden nimistä tiedostoa.

    private static final String MOVE = "mv";
    // nimeää tiedoston annetun nimiseksi uudeksi
    // tiedostoksi, jos nimellä löydetään tiedosto nykyhakemistosta
    // ja hakemistossa ei ole vielä uuden nimistä tiedostoa.

    private static final String EXIT = "exit";
    // lopetaa ohjelman.

    private Hakemisto dir = new Hakemisto();
    private Komentotulkki tulkki = new Komentotulkki();

    public void run(){
        int run = 1;
        while(run == 1) {
            dir.luePolku();
            String vastaus = In.readString();
            System.out.println(dir.lueString());
            boolean onkoOikein = tulkki.tarkistus(vastaus);
                    // TODO Do-while silmukka syötteen oikein saamiseksi
            if (onkoOikein) {
                System.out.println("Oikein meni!");
                run = 0;
            }
            else if (!onkoOikein){
                System.out.println("Väärin meni!");
                run = 1;
            }
        }
    }
}
