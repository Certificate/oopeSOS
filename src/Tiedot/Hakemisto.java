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
    return null;
    }

    public Tieto hae(String nimi){
    return null;
    }

    public boolean lisaa(Tieto lisattava){
    return false;
    }

    public Tieto poista(String nimi){
    return null;
    }




}
