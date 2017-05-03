package oope2017ht.tiedot;

/**
 * <p>
 * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2017.
 * <p>
 * @author Valtteri Vuori (vuori.valtteri.j@student.uta.fi),
 * Tietojenkäsittelytiede, Tampereen yliopisto.
 *
 *   Tiedostoa mallintava aliluokka joka on johdettu Tiedosta.
 *   Tätä voidaan säilöä vaikka Hakemistoon!
 */

public class Tiedosto extends Tieto {

    /** Attribuutti
     */
    private int koko;

    /** Rakentajat
     * @param str Annettava nimi
     * @param i Annettava koko
     * @throws IllegalArgumentException*/
    public Tiedosto( StringBuilder str, int i) throws IllegalArgumentException {
        super(str);
        asetaKoko(i);
    }
    /** Kopiorakentaja.
     * @param alkuperainen Kopioitava Tiedosto*/
    public Tiedosto(Tiedosto alkuperainen){
        super(alkuperainen);
        asetaKoko(alkuperainen.lueKoko());
    }

    /** Setterit
     * @param i annettava koko
     * @throws IllegalArgumentException*/
    private void asetaKoko(int i) throws IllegalArgumentException{
        if (i > 0) {
            this.koko = i;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /** Getterit
     * @return koko*/
    private int lueKoko(){
        return this.koko;
    }

    /** Itsekirjoitettu toString-metodi, joka kutsuu yliluokan toString metodia.
     * @return super() sekä Tiedoston koko */
    public String toString() {
        return super.toString() + " " + koko;
    }

}
