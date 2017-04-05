package Tiedot;

import oopeSOS.Komentotulkki;

/**
 *  TIEDOT- YLILUOKKA
 */

public abstract class Tieto {

    Komentotulkki tulkkaus = new Komentotulkki();
    private StringBuilder nimi = new StringBuilder();

    public Tieto(String str){
        asetaString(str);
    }
    public Tieto() {
        asetaString("null");
    }

    public void asetaString(String str) throws IllegalArgumentException{
        if(tulkkaus.tarkistus(str) == true){
            this.nimi.append(str);
        }
        else {
            throw new IllegalArgumentException();
        }

    }

    public String lueString(){
        return this.nimi.toString();
    }

}
