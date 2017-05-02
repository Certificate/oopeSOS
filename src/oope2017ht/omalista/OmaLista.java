package oope2017ht.omalista;

import apulaiset.Ooperoiva;
import fi.uta.csjola.oope.lista.*;

/**
 *   Tämänkin työmaan teki Valtteri Vuori
 *   Vuori.Valtteri.J@student.uta.fi
 *
 *   LinkitetystäListasta johdettu OmaLista luokka
 *   johon on implementoitu Ooperoiva-rajapinnassa ohjeistetut metodit.
 */

public class OmaLista extends LinkitettyLista implements Ooperoiva{

    // Haetaan objektia listasta.
    public Object hae(Object get) {
        if(get != null) {
            for (int i = 0; i < koko(); i++){
                if (get.equals(alkio(i))) {
                    return alkio(i);
                }
            }
            return null;
        }
        else
            return null;
    }

    // Tiedoston lisäys listaan
    public boolean lisaa(Object uusi) {
        if (uusi != null) {
            int i = 0;
            if (koko() > 0) {
                while (i < koko()) {
                    // Koska pisteet jostain syystä eivät toimineet algoritmini kanssa kunnolla,
                    // muutetaan kaikki pisteet kauttaviivoiksi. Ja taas toimii vertailu!
                    String uusiNimi = uusi.toString().replaceAll("\\.","/");
                    String alkioNimi = alkio(i).toString().replaceAll("\\.","/");
                    int z = uusiNimi.compareTo(alkioNimi);
                    if (z > 0) {
                        i++;
                    } else if (z <= 0) {
                        lisaa(i, uusi);
                        return true;
                    }
                    if (i == koko()) {
                        lisaaLoppuun(uusi);
                        return true;
                    }
                }
            } else {
                lisaaAlkuun(uusi);
                return true;
            }
            return false;
        }
        else {
            return false;
        }
    }

    // Tiedoston poisto listasta
    public Object poista(Object poistettava) {
        if (poistettava != null) {
            for (int i = 0; i < koko(); i++) {
                if (poistettava.equals(alkio(i))) {
                    return poista(i);
                }
            }
        }
        return null;
    }
}
