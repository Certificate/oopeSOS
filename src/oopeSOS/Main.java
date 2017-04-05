package oopeSOS;


import Tiedot.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to SOS.");
        //Kayttoliittyma UI = new Kayttoliittyma();
        //UI.run();

        Hakemisto testi = new Hakemisto(new StringBuilder("ebinsauce"), null);
        Hakemisto alaTesti = new Hakemisto(new StringBuilder("moottori"), testi);
        Tiedosto testiKoira = new Tiedosto(new StringBuilder("kyrpakoira"), 696969);

        testi.lisaa(alaTesti);
        alaTesti.lisaa(testiKoira);

        System.out.println(alaTesti.sisalto().alkio(0));
    }
}

