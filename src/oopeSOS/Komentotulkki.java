package oopeSOS;

import omalista.OmaLista;
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
    private static final String MOVE = "mv";
    private static final String EXIT = "exit";

    private Hakemisto nykyHakemisto;

    private StringBuilder polku = new StringBuilder("/>");

    public void luoRoot(){
        nykyHakemisto = new Hakemisto(new StringBuilder("root"), null);
    }

    public int tulkkaa(String input){

        int laskuri = 0;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == ' ')
                laskuri++;
        }

        String[] parts = input.split(" ");
        String komento = parts[0];
        String para1 = "";
        if (laskuri >= 1){
            para1 = parts[1];
            //System.out.println("Part 1: "+para1);
        }
        String para2 = "";
        if (laskuri >= 2){
            para2 = parts[2];
            //System.out.println("Part 2: "+para2);
        }

        if (komento.equals(EXIT)){
            return 0;
        }
        else if (komento.equals(MAKEDIR)){
            makeDir(para1);
            return 1;
        }
        else if (komento.equals(LIST)){
            tulostaSisalto(nykyHakemisto.sisalto());
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
            int koko = 0;
            if(laskuri >= 2)
                koko = Integer.parseInt(para2);
            makeFil(para1, koko);
            return 1;
        }
        else if (komento.equals(CHANGEDIR)){
            changeDir(para1);
            return 1;
        }
        else{
            System.out.print("mitävittua");
        }
        return 1;
    }


    public void luePolku(){
        System.out.print(polku);
    }

    public void makeDir(String nimi) {
        nykyHakemisto.lisaa(new Hakemisto(new StringBuilder(nimi), nykyHakemisto));

    }
    public void makeFil (String nimi, int koko) {
        nykyHakemisto.lisaa(new Tiedosto(new StringBuilder(nimi), koko));
    }
    public void changeDir (String uusiHakemisto) {
        if (uusiHakemisto.equals("..")) {
            nykyHakemisto = nykyHakemisto.haeYli();

        }
        else if (nykyHakemisto.hae(uusiHakemisto) != null) {
            nykyHakemisto = (Hakemisto) nykyHakemisto.hae(uusiHakemisto);
            polku.insert(0, uusiHakemisto);
            polku.insert(0, '/');
        }
        else
            System.out.println("Error!");


    }

    private static void tulostaSisalto(LinkitettyLista lista) {
        if (lista != null) {
            for (int i = 0; i < lista.koko(); i++) {
                System.out.println(lista.alkio(i));
            }
        }
    }

}

