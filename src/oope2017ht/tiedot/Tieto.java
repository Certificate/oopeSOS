package oope2017ht.tiedot;

import oope2017ht.Tarkistaja;

/**
 * <p>
 * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2017.
 * <p>
 * @author Valtteri Vuori (vuori.valtteri.j@student.uta.fi),
 * Tietojenkäsittelytiede, Tampereen yliopisto.
 *
 *   Nyt ollaan Tiedon äärellä. He he!
 *   Luokka on pohjana sekä Tiedostolle että
 *   Hakemistolle.
 */

public abstract class Tieto implements Comparable<Tieto>{

    /** Attribuutit + tarkistajaluokan alustus */
    private Tarkistaja tarkistaja = new Tarkistaja();
    private StringBuilder nimi = new StringBuilder();

    /** Rakentajat
     * @param str Annettava nimi*/
    Tieto(StringBuilder str) {
        asetaString(str);
    }

    /** Kopiorakentaja-rakentaja ;)
     * @param alkuperainen Kopioitava Tieto*/
    Tieto(Tieto alkuperainen) {
        if(alkuperainen != null){
            asetaString(alkuperainen.lueStringBuilder());
        }
    }

    /** Setterit
     * @param str Annettava nimi
     * @throws IllegalArgumentException jos annettu syöte ei ole oikeellinen*/
    public void asetaString(StringBuilder str) throws IllegalArgumentException {
        if (tarkistaja.tarkistus(str.toString())) {
            this.nimi = (str);
        } else {
            throw new IllegalArgumentException();
        }
    }
    /** Nimen muuttaminen. Käytetään RENAME-metodissa. Poistaa nimen kokonaan StringBuilder oliosta, ja asettaa sen uudelleen annetun parametrin mukaiseksi.
     * @param str Annettava nimi
     * @throws IllegalArgumentException mikäli syöte ei ole oikeellinen*/
    public void muutaNimi(String str){
        if (!tarkistaja.tarkistus(str)) {
            throw new IllegalArgumentException();
        } else {
            this.nimi.delete(0, this.nimi.length());
            this.nimi.append(str);
        }
    }
    /** Getterit
     * @return nimi toString muodossa*/
    String lueString() {
        return this.nimi.toString();
    }

    /** Luetaan StringBuilder tyyyppinen tieto
     *
     * @return nimi StringBuilder
     */
    private StringBuilder lueStringBuilder() {
        return this.nimi;
    }

    /** Itsekirjoitettu toString-metodi
     * @return lueString Itsensäselittävä*/
    public String toString() {
        return lueString();
    }

    /** Itse ylikirjoitettu equals-metodi. Vertailee kahden Tiedon nimeä.
     *
     * @param asia Vertailtava asia
     * @return equals-arvo  jos annetut parametrit ovat ok. muutoin false.
     */
    public boolean equals(Object asia){
        if (asia != null && asia  instanceof Tieto) {
            Tieto apu = (Tieto)asia;
            return this.lueString().equals(apu.lueString());
        }
        else{
            return false;
        }
    }

    /** Itse uudelleenkirjoitettu compareTo metodi. Vertailee kahden eri Tiedon nimeä.
     *
     * @param asia vertailtava asia
     * @return vertailu int arvoinen tulos siitä, kumpi on isompi.
     */
    public int compareTo(Tieto asia){
        int vertailu = this.nimi.toString().compareTo(asia.nimi.toString());
        System.out.println("tämänimitoString: "+this.nimi.toString() + "ja vertailtava: "+asia.nimi.toString());
        return vertailu;

    }
}

