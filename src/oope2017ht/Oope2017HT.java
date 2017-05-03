package oope2017ht;

/**
 * <p>
 * Olio-Ohjelmoinnin Perusteet 2017 Kevät - Harjoitustyö
 * Tästä se kaikki alkaa. Tämä luokka vain ja ainoastaan tervehtii käyttäjää ja alustaa sekä käynnistää käyttöliittymän.
 * <p>
 * @author Valtteri Vuori (vuori.valtteri.j@student.uta.fi),
 * Tietojenkäsittelytiede, Tampereen yliopisto.
 */

public class Oope2017HT {
    public static void main(String[] args){
        System.out.println("Welcome to SOS.");
        Kayttoliittyma UI = new Kayttoliittyma();
        UI.run();
    }
}