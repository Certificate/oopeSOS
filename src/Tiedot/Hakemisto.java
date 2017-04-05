package Tiedot;

import oopeSOS.OmaLista;

/**
 *  Hakemisto-alaluokka
 */
public class Hakemisto extends Tieto{

    private Hakemisto ylihakemisto;
    private OmaLista viiteLista;


    public Hakemisto(){
        super();
    }

    public Hakemisto(StringBuilder str, Hakemisto yli){
        super(nimi);
        asetaYli(yli);
        viiteLista = new Omalista;
    }

    public void asetaYli(Hakemisto yli) throws IllegalArgumentException{
        this.ylihakemisto = yli;
    }




}
