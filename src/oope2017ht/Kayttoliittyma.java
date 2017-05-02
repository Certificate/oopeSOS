package oope2017ht;

import apulaiset.In;


/**
 * <p>
 * Käyttöliittymää mallintava luokka. Käyttäjän ja ohjelman keskusteluohjelma (Ei siis mikään Late Night With Oope'O'Brien)
 * <p>
 * @author Valtteri Vuori (vuori.valtteri.j@student.uta.fi),
 * Tietojenkäsittelytiede, Tampereen yliopisto.
 */


public class Kayttoliittyma {

    private Komentotulkki tulkki = new Komentotulkki();
    private Tarkistaja tarkistaja = new Tarkistaja();

    /**Käyttöliittymän ajoluokka. Luo juurihakemiston ja pitää yllä ohjelman ajoa vaativaa silmukkaa.
     * Yrittää catchata yleisimpiä virheitä.*/
    void run() {
        try {
            tulkki.luoRoot();
            int run = 1;
            while (run == 1) {
                tulkki.luePolku();
                System.out.print("/>");
                String vastaus = In.readString();
                if (tarkistaja.tarkistus(vastaus)) {
                    if (tulkki.tulkkaa(vastaus) == 0) {
                        run = 0;
                    }
                } else if (!tarkistaja.tarkistus(vastaus)) {
                    System.out.println("Error!");
                }
            }
            System.out.println("Shell terminated.");
        } catch (IllegalArgumentException e){
            System.out.println("You triggered "+ e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You triggered "+e.getMessage());
        }

    }
}
