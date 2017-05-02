package oope2017ht.tiedot;

import oope2017ht.Tarkistaja;

/**
 *   Tämänkin työmaan teki Valtteri Vuori
 *   Vuori.Valtteri.J@student.uta.fi
 *
 *   Nyt ollaan Tiedon äärellä. He he!
 *   Luokka on pohjana sekä Tiedostolle että
 *   Hakemistolle.
 */

public abstract class Tieto implements Comparable<Tieto>{

    // Attribuutit + tarkistajaluokan alustus
    private Tarkistaja tarkistaja = new Tarkistaja();
    private StringBuilder nimi = new StringBuilder();

    // Rakentajat
    Tieto(StringBuilder str) {
        asetaString(str);
    }

    // Kopiorakentaja-rakentaja ;)
    Tieto(Tieto alkuperainen) {
        if(alkuperainen != null){
            asetaString(alkuperainen.lueStringBuilder());
        }
    }
    //
    // Setterit
    //
    public void asetaString(StringBuilder str) throws IllegalArgumentException {
        if (tarkistaja.tarkistus(str.toString())) {
            this.nimi = (str);
        } else {
            throw new IllegalArgumentException();
        }
    }
    // Nimen muuttaminen. Käytetään RENAME-metodissa. Poistaa nimen kokonaan StringBuilder oliosta,
    // ja asettaa sen uudelleen annetun parametrin mukaiseksi.
    public void muutaNimi(String str){
        if (!tarkistaja.tarkistus(str)) {
            throw new IllegalArgumentException();
        } else {
            this.nimi.delete(0, this.nimi.length());
            this.nimi.append(str);
        }
    }
    // Getterit
    String lueString() {
        return this.nimi.toString();
    }

    private StringBuilder lueStringBuilder() {
        return this.nimi;
    }

    // Kaikki muu
    public String toString() {
        return lueString();
    }

    public boolean equals(Object asia){
        if (asia != null && asia  instanceof Tieto) {
            Tieto apu = (Tieto)asia;
            return this.lueString().equals(apu.lueString());
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

