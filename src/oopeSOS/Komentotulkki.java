package oopeSOS;

import omalista.OmaLista;
import tiedot.*;

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
    private static final String MOVE = "mv";
    private static final String EXIT = "exit";

    private Hakemisto nykyHakemisto;

    private String polku = "/>";

    public void luoRoot(){
        Hakemisto root = new Hakemisto(new StringBuilder("root"), null);
        nykyHakemisto = root;
    }

    public int tulkkaa(String komento){
        if (komento.equals(EXIT)){
            return 0;
        }
        else if (komento.equals(MAKEDIR)){
            makeDir(komento);
            return 1;
        }
        else if (komento.equals(LIST)){
            System.out.println(nykyHakemisto.sisalto());
            return 1;
        }
        else if (komento.equals(FIND)){
            return 1;
        }
        else if (komento.equals(REMOVE)){
            return 1;
        }
        else if (komento.equals(COPY)){
            return 1;
        }
        else if (komento.equals(MOVE)){
            return 1;
        }
        else if (komento.equals(MAKEFIL)){
            return 1;
        }
        else if (komento.equals(CHANGEDIR)){
            return 1;
        }
        else{
            System.out.print("mitävittua");
        }
        return 1;
    }

    public void asetaPolku(String str){
        this.polku = str;
    }

    public void luePolku(){
        System.out.print(polku);
    }

    public void makeDir(String nimi) {
        System.out.println("MAKEDIR ACTIVATED");
        nykyHakemisto.lisaa(new Hakemisto(new StringBuilder(nimi), null));

    }
    public void makeFil () {
        System.out.println("makeFil ACTIVATED");
    }
    public void changeDir () {
        System.out.println("changeDir ACTIVATED");
    }

}

