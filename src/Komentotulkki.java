/**
 *  Komentoja tulkkaava tulkki :) .
 */
public class Komentotulkki {

    //Alla lähes kaikki harjoitustyössä käytettävät komennot


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

    //
    // Tarkistetaan ovatko annetun syötteen merkit ok
    //
    public boolean tarkistus (String str){
        boolean ok = false;
        for (int i = 0; i < str.length(); i++){
            char help = str.charAt(i);
            if ((help >= 'a' && help <= 'z')
                    || (help >= '0' && help <= '9')
                    || (help >= 'A' && help <= 'Z')
                    || (help == '.')
                    || (help == ' ')
                    || (help == '_')){
                ok = true;
            }
            else{
                ok = false;
            }
        }
        System.out.println("Totuusarvo palautuksessa: "+ok);
        return ok;


    }

    public int tulkkaa(String komento){
        if (komento == "exit"){
            System.out.println("Toimiiko tää vittu");
            return 0;
        }
        else{
            System.out.println("Väärä komento! Kokeile uudestaan.");
            return 1;
        }
    }

}

