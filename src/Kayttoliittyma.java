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
            System.out.println(dir.lueString());
            boolean onkoOikein = tulkki.tarkistus(vastaus);
                    // TODO Do-while silmukka syötteen oikein saamiseksi
            if (onkoOikein) {
                System.out.println("Oikein meni!");
                run = 0;
            }
            else if (!onkoOikein){
                System.out.println("asdfg");
                run = 1;
            }
        }
    }
}
