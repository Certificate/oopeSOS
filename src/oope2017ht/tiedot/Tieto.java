package oope2017ht.tiedot;

import oope2017ht.Tarkistaja;

/**
 *  TIEDOT- YLILUOKKA
 *  Tästä johdetaan sekä Hakemisto että Tiedosto-luokat.
 *
 */

public abstract class Tieto implements Comparable<Tieto>{

    // Attribuutit + tarkistajaluokan alustus
    Tarkistaja tarkistaja = new Tarkistaja();
    private StringBuilder nimi = new StringBuilder();

    // Rakentajat
    public Tieto(StringBuilder str) {
        asetaString(str);
    }
    public Tieto() {
        asetaString(new StringBuilder("null"));
    }
    // Kopiorakentaja-rakentaja ;)
    public Tieto(Tieto alkuperainen) {
        if(alkuperainen instanceof Tieto){
            asetaString(alkuperainen.lueStringBuilder());
        }
    }
    //
    // Setterit
    //
    public void asetaString(StringBuilder str) throws IllegalArgumentException {
        if (tarkistaja.tarkistus(str.toString()) == true) {
            this.nimi = (str);
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void muutaNimi(String str){
        if (tarkistaja.tarkistus(str.toString()) == true) {
            this.nimi.delete(0, this.nimi.length());
            this.nimi.append(str);
        } else {
            throw new IllegalArgumentException();
        }
    }
    // Getterit
    public String lueString() {
        return this.nimi.toString();
    }

    public StringBuilder lueStringBuilder() {
        return this.nimi;
    }

    // Kaikki muu
    public String toString() {
        return lueString();
    }

    public boolean equals(Object asia){
        if (asia != null && asia  instanceof Tieto) {
            Tieto apu = (Tieto)asia;
            if (this.lueString().equals(apu.lueString())) {
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    public int compareTo(Tieto asia){
        int vertailu = this.nimi.toString().compareTo(asia.nimi.toString());
        System.out.println("tämänimitoString: "+this.nimi.toString() + "ja vertailtava: "+asia.nimi.toString());
        return vertailu;

    }
}

