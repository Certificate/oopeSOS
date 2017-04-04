package oopeSOS;

import Tiedot.Tiedosto;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to SOS.");
        //
        // UI.run();

        Tiedosto file = new Tiedosto("penisbox", 64);
        System.out.println(file.lueString() +" "+ file.lueKoko());
        file.asetaKoko(696969);
        file.asetaString("eilija");
        System.out.println(file.lueString() +" "+ file.lueKoko());

    }
}

