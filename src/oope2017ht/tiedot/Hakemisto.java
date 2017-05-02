package oope2017ht.tiedot;

import apulaiset.Komennettava;
import fi.uta.csjola.oope.lista.LinkitettyLista;
import oope2017ht.omalista.OmaLista;

/**
 *  Tämänkin työmaan teki Valtteri Vuori
 *  Vuori.Valtteri.J@student.uta.fi
 *
 *  Hakemisto-alaluokka
 *  Johdettu Tiedosta. Toimii minkä tahansa Tiedon tallennuspaikkana
 *  hyödyntäen OmaListaa.
 */


public class Hakemisto extends Tieto implements Komennettava<Tieto>{

    // Attribuutit
    private Hakemisto ylihakemisto;
    private OmaLista lista;

    // Rakentaja
    public Hakemisto(StringBuilder str, Hakemisto yli){
        super(str);
        asetaYli(yli);
        lista = new OmaLista();
    }

    // Setter
    private void asetaYli(Hakemisto yli){
        this.ylihakemisto = yli;
    }

    // Getter
    public Hakemisto haeYli(){
        return this.ylihakemisto;
    }


    /*
    * Komennettava-rajapinnan
    * määrittelemät metodit.
    * */


    // Hakee listan ssällön.
    public LinkitettyLista sisalto(){
        return lista;
    }

    // Kts. poista-metodi.
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
    // Tiedoston lisäys listaan. Itsensäselittävä oikeastaan.
    public boolean lisaa(Tieto lisattava) {
        return lista.hae(lisattava) == null && lista.lisaa(lisattava);
    }

    // Poistaa annetun parametrin nimisen tiedoston listasta.
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

    // Tulostuksessa käytettävät metodit.

    // Itse uudelleenkirjoitettu toString metodi.
    public String toString() {
        return super.lueString() + "/ " +lista.koko();
    }
    // toStringiin verrattuna simppelimpi tulostus. Ei listaa kauttaviivaa tai annetun hakemiston kokoa.
    public String toSimpleName() {
        return super.lueString();
    }
}
