package oopeSOS;

import apulaiset.In;
import tiedot.Hakemisto;

/**
 *  Tämän työmaan teki Valtteri Vuori
 *  Vuori.Valtteri.J@student.uta.fi
 */


public class Kayttoliittyma {

    // dir = directory :)
    private Hakemisto nykyHakemisto;
    private Komentotulkki tulkki = new Komentotulkki();
    private Tarkistaja tarkistaja = new Tarkistaja();

    public void run(){
        tulkki.luoRoot();
        int run = 1;
        while(run == 1) {
            tulkki.luePolku();
            System.out.print("/>");
            String vastaus = In.readString();
            if (tarkistaja.tarkistus(vastaus)) {
                if (tulkki.tulkkaa(vastaus) == 0){
                    run = 0;
                }
            }
            else if (!tarkistaja.tarkistus(vastaus)){
                System.out.println("Error!");
            }
        }
        System.out.print("Shell terminated.");
    }
}
