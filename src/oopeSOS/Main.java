package oopeSOS;


import Tiedot.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to SOS.");
        //Kayttoliittyma UI = new Kayttoliittyma();
        //UI.run();

        Tiedosto know = new Tiedosto(new StringBuilder("apina"), 1337);
        System.out.println(know.toString());
    }
}

