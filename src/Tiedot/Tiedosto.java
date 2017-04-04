package Tiedot;

import oopeSOS.Komentotulkki;
/**
 *  Tiedostoa mallintava aliluokka Tiedosta.
 */
public class Tiedosto extends Tieto {

    // Tarkituksessa auttava komenotulkki-olio
    Komentotulkki tulkkaus = new Komentotulkki();

    // Koko tavuina
    private int koko;

    public Tiedosto( String str, int i) throws IllegalArgumentException{
        if(tulkkaus.tarkistus(str) && i > 0 ) {
            super.asetaString(str);
            this.koko = i;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public void asetaKoko(int i) throws IllegalArgumentException{
        if (i > 0) {
            this.koko = i;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int lueKoko(){
        return this.koko;
    }
}
