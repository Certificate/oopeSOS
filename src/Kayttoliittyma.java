import Tiedot.Hakemisto;
import apulaiset.In;

/**
 *  Tämän työmaan teki Valtteri Vuori
 *  Vuori.Valtteri.J@student.uta.fi
 */


public class Kayttoliittyma {

    // dir = directory :)
    private Hakemisto dir = new Hakemisto();

    private Komentotulkki tulkki = new Komentotulkki();

    public void run(){
        int run = 1;
        while(run == 1) {
            dir.luePolku();
            String vastaus = In.readString();
            if (tulkki.tarkistus(vastaus)) {
                if (tulkki.tulkkaa(vastaus) == 0){
                    run = 0;
                }
                else{
                    System.out.println("Ei ainakaan exit");
                }
            }
            else if (!tulkki.tarkistus(vastaus)){
                System.out.println("Error!");
            }

        }
        System.out.print("Shell terminated.");
    }
}
