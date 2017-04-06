package tiedot;

import oopeSOS.Komentotulkki;

/**
 *  TIEDOT- YLILUOKKA
 */

public abstract class Tieto  implements Comparable<Tieto>{

    Komentotulkki tulkkaus = new Komentotulkki();
    private StringBuilder nimi = new StringBuilder();

    public Tieto(StringBuilder str) {
        asetaString(str);
    }

    public Tieto() {
        asetaString(new StringBuilder("null"));
    }

    public void asetaString(StringBuilder str) throws IllegalArgumentException {
        if (tulkkaus.tarkistus(str.toString()) == true) {
            this.nimi = (str);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String lueString() {
        return this.nimi.toString();
    }

    public StringBuilder lueStringBuilder() {
        return this.nimi;
    }

    public String toString() {
        return lueString();
    }

    public Tieto(Tieto alkuperainen) {
        asetaString(alkuperainen.lueStringBuilder());
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
        return vertailu;

    }
}

