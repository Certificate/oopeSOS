package Tiedot;

import oopeSOS.OmaLista;

/**
 *  Hakemisto-alaluokka
 */
public class Hakemisto extends Tieto{

    private Hakemisto ylihakemisto = new Hakemisto();
    Hakemisto alihakemisto = new Hakemisto();
    OmaLista lista = new OmaLista();


    public Hakemisto(){
        super();
    }

    public Hakemisto(String str, Hakemisto yli){
        super(str);
        asetaYli(yli);
    }

    public void asetaYli(Hakemisto yli) throws IllegalArgumentException{
        this.ylihakemisto = yli;
    }




}
