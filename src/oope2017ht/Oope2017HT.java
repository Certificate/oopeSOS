package oope2017ht;

/**
 *
 *  Tämänkin työmaan teki Valtteri Vuori
 *  Vuori.Valtteri.J@student.uta.fi
 *
 *  Tästä se kaikki alkaa. Tämä luokka vain ja ainoastaan tervehtii
 *  käyttäjää ja alustaa sekä käynnistää käyttöliittymän.
 *
 */



public class Oope2017HT {
    public static void main(String[] args){
        System.out.println("Welcome to SOS.");
        Kayttoliittyma UI = new Kayttoliittyma();
        UI.run();
    }
}