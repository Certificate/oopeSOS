package oope2017ht.tiedot;

import apulaiset.Komennettava;
import fi.uta.csjola.oope.lista.LinkitettyLista;
import oope2017ht.omalista.OmaLista;

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

    public void asetaYli(Hakemisto yli){
        this.ylihakemisto = yli;
    }

    public Hakemisto haeYli(){
        return this.ylihakemisto;
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
        if(nimi != null) {
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

    public String toString() {
        return super.lueString() + "/ " +lista.koko();
    }
    public String toSimpleName() {
        return super.lueString();
    }

//    public void polku(){
//        System.out.print("/");
//        if (!this.nimi.toString().equals("root"))
//            System.out.print(this.nimi.toString());
//        if (this.ylihakemisto != null && this.ylihakemisto.toSimpleName() != "root")
//            ylihakemisto.polku();
//    }

    public String annaPolku(Hakemisto tama) {
        String polku;
        if (!this.nimi.toString().equals("root"))
            polku = "/"+this.nimi.toString();
        else
            polku = "/";
        while (tama != null) {
            tama = tama.haeYli();
        }
        return polku;
    }



}
