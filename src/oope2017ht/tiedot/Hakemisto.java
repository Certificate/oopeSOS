package oope2017ht.tiedot;

import apulaiset.Komennettava;
import fi.uta.csjola.oope.lista.LinkitettyLista;
import oope2017ht.omalista.OmaLista;

/**
 * <p>
 *  Hakemisto-alaluokka. Johdettu Tiedosta. Toimii minkä tahansa Tiedon tallennuspaikkana hyödyntäen OmaListaa.
 * <p>
 * @author Valtteri Vuori (vuori.valtteri.j@student.uta.fi),
 * Tietojenkäsittelytiede, Tampereen yliopisto.
 */


public class Hakemisto extends Tieto implements Komennettava<Tieto>{

    /** Attribuutit */
    private Hakemisto ylihakemisto;
    private OmaLista lista;

    /** Rakentaja
     * @param yli Yliluokka
     * @param str Annetytava nimi*/
    public Hakemisto(StringBuilder str, Hakemisto yli){
        super(str);
        asetaYli(yli);
        lista = new OmaLista();
    }

    /** Setter - Asettaa ylihakemiston
     * @param yli Asetettava ylihakemisto*/
    private void asetaYli(Hakemisto yli){
        this.ylihakemisto = yli;
    }

    /** Getter - Palauttaa ylihakemiston
     * @return ylihakemisto*/
    public Hakemisto haeYli(){
        return this.ylihakemisto;
    }


    /**
    * Komennettava-rajapinnan
    * määrittelemät metodit.
    * */


    /** Hakee listan sisällön. */
    public LinkitettyLista sisalto(){
        return lista;
    }

    /** Haetaan annetun parametrin nimistä Tietoa listasta. Luodaan apuTiedosto sekä apuHakemisto jota vertaillessa saadaan oikea Tieto esiin listasta.
     *
     * @param nimi on String-muotoinen parametri.
     * @return Parametrin niminen tiedosto listasta. Null jos haku ei onnistunut.
     */
    public Tieto hae(String nimi){
        if(nimi != null) {
            Tiedosto apuTiedosto = new Tiedosto(new StringBuilder(nimi), 1);
            Hakemisto apuHakemisto = new Hakemisto(new StringBuilder(nimi), null);

            if (lista.hae(apuTiedosto) != null) {
                return (Tieto)lista.hae(apuTiedosto);
            } else if (lista.hae(apuHakemisto) != null) {
                return (Tieto)lista.hae(apuHakemisto);
            } else {
                return null;
            }
        }
        else
            return null;
    }
    /** Tiedoston lisäys listaan. Itsensäselittävä oikeastaan.
     *
     * @param lisattava on Tieto-muotoinen parametri, jota ollaan lisäämässä listaan.
     * @return true jos lisäys onnistui, false jos ei onnistunut.
     */
    public boolean lisaa(Tieto lisattava) {
        return lista.hae(lisattava) == null && lista.lisaa(lisattava);
    }

    /** Poistaa annetun parametrin nimisen tiedoston listasta.
     *
     * @param nimi on String-muotoinen parametri, jota ollaan poistamassa listasta.
     * @return true jos poisto onnistui, null jos ei onnistunut.
     */
    public Tieto poista(String nimi){
        if(nimi != null) {
            // Luodaan sekä apuTiedosto että -Hakemisto. Täten saadaan etsittyä annetunnimistä
            // tiedostoa/hakemistoa listasta, ja lopulta poistettua se.
            // Saman toimintaperiaate suurimmaksi osaksi kuin hae-metodissa.
            Tiedosto apuTiedosto = new Tiedosto(new StringBuilder(nimi), 10);
            Hakemisto apuHakemisto = new Hakemisto(new StringBuilder(nimi), null);

            if (lista.hae(apuTiedosto) != null) {
                return (Tieto) lista.poista(apuTiedosto);
            } else if (lista.hae(apuHakemisto) != null) {
                return (Tieto) lista.poista(apuHakemisto);
            } else {
                return null;
            }
        }
        else{
            return null;
        }
    }


    /** Tulostuksessa käytettävät metodit.
     */

    /** Itsekirjoitettu toString metodi, joka palauttaa super-kutsun lisäksi myös kauttaviivan sekä listan koon.
     */
    public String toString() {
        return super.lueString() + "/ " +lista.koko();
    }
    /** toStringiin verrattuna simppelimpi tulostus. Ei listaa kauttaviivaa tai annetun hakemiston kokoa.
     */
    public String toSimpleName() {
        return super.lueString();
    }
}
