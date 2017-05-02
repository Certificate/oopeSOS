package oope2017ht.tiedot;

/**
 *   Tämänkin työmaan teki Valtteri Vuori
 *   Vuori.Valtteri.J@student.uta.fi
 *
 *   Tiedostoa mallintava aliluokka joka on johdettu Tiedosta.
 *   Tätä voidaan säilöä vaikka Hakemistoon!
 */

public class Tiedosto extends Tieto {

    // Attribuutti
    private int koko;

    // Rakentajat
    public Tiedosto( StringBuilder str, int i) throws IllegalArgumentException {
        super(str);
        asetaKoko(i);
    }

    public Tiedosto(Tiedosto alkuperainen){
        super(alkuperainen);
        asetaKoko(alkuperainen.lueKoko());
    }

    // Setterit
    private void asetaKoko(int i) throws IllegalArgumentException{
        if (i > 0) {
            this.koko = i;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    // Getterit
    private int lueKoko(){
        return this.koko;
    }

    // Kaikki muu
    public String toString() {
        return super.toString() + " " + koko;
    }

}
