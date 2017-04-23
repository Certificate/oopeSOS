package oopeSOS;

import apulaiset.In;

/**
 *  Tämän työmaan teki Valtteri Vuori
 *  Vuori.Valtteri.J@student.uta.fi
 */


public class Kayttoliittyma {

    // dir = directory :)
    private Komentotulkki dir = new Komentotulkki();

    private Komentotulkki tulkki = new Komentotulkki();

    public void run(){
        int run = 1;
        while(run == 1) {
            dir.luePolku();
            String vastaus = In.readString();
            if (tulkki.tarkistus(vastaus)) {
                if (tulkki.tulkkaa(vastaus) == 0){
                    run = 0;
                }
            }
            else if (!tulkki.tarkistus(vastaus)){
                System.out.println("Error!");
            }
        }
        System.out.print("Shell terminated.");
    }
}
