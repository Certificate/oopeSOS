package Tiedot;

/**
 *  Hakemisto-alaluokka
 */
public class Hakemisto extends Tieto{

    // Omat jutut ja komennot polun määrittämiseksi.
    // UI kutsuu luePolkua aina komennon jälkeen.
    private String polku = "/>";

    public void asetaPolku(String str){
        this.polku = str;
    }

    public void luePolku(){

        System.out.print(polku);
    }

    //
    //
    //

// TODO Ali- ja yläluokan koodaus



}
