package oope2017ht.tiedot;

/**
 *  Tiedostoa mallintava aliluokka Tiedosta.
 */

public class Tiedosto extends Tieto {

    // Attribuutti
    private int koko;

    // Rakentajat
    public Tiedosto( StringBuilder str, int i){
        super(str);
        asetaKoko(i);
    }

    public Tiedosto(Tiedosto alkuperainen){
        super(alkuperainen);
        asetaKoko(alkuperainen.lueKoko());
    }

    // Setterit
    public void asetaKoko(int i) throws IllegalArgumentException{
        if (i > 0) {
            this.koko = i;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    // Getterit

    public int lueKoko(){
        return this.koko;
    }

    // Kaikki muu
    public String toString() {
        return super.toString() + " " + koko;
    }

    public String toSimpleName() {
        return super.lueString();
    }


}
