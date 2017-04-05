package Tiedot;

import apulaiset.Komennettava;
import fi.uta.csjola.oope.lista.LinkitettyLista;
import oopeSOS.*;

/**
 *  Hakemisto-alaluokka
 */
public class Hakemisto extends Tieto implements Komennettava<Tieto>{

    private Hakemisto ylihakemisto;
    private OmaLista lista;



    public Hakemisto(StringBuilder str, Hakemisto yli){
        super(str);
        asetaYli(yli);
        lista = new OmaLista();
    }

    public void asetaYli(Hakemisto yli) throws IllegalArgumentException{
        this.ylihakemisto = yli;
    }

    public LinkitettyLista sisalto(){
        return lista;
    }

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

    public boolean lisaa(Tieto lisattava){
        if (lista.hae(lisattava) == null )
            return lista.lisaa(lisattava);
        else
            return false;
    }

    public Tieto poista(String nimi){
        Tiedosto apuTiedosto = new Tiedosto(new StringBuilder(nimi), 0);
        Hakemisto apuHakemisto = new Hakemisto(new StringBuilder(nimi), null);

        if (lista.hae(apuTiedosto) != null){
            return (Tieto)lista.poista(apuTiedosto);
        }
        else if (lista.hae(apuHakemisto) != null){
            return (Tieto)lista.poista(apuHakemisto);
        }
        else{
            return null;
        }
    }

    public String toString() {
        return lueString() + " / " +lista.koko();
    }




}
