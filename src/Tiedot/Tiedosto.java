package Tiedot;

import oopeSOS.Komentotulkki;
/**
 *  Tiedostoa mallintava aliluokka Tiedosta.
 */
public class Tiedosto extends Tieto {

    // Koko tavuina
    private int koko;

    public Tiedosto( StringBuilder str, int i){
        super(str);
        asetaKoko(i);
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

    public String toString() {
        return super.toString() + " " + koko;
    }

    public Tiedosto(Tiedosto alkuperainen){
        super(alkuperainen);
        asetaKoko(alkuperainen.lueKoko());
    }
}
