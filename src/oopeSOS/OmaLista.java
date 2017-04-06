package oopeSOS;

import apulaiset.Ooperoiva;
import fi.uta.csjola.oope.lista.*;

/**
 *   LinkitetystäListasta johdettu OmaLista luokka
 */

public class OmaLista extends LinkitettyLista implements Ooperoiva{

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


    public boolean lisaa(Object uusi) {
        if (uusi != null) {
            int i = 0;
            if (koko() > 0) {
                while (i < koko()) {
                    int z = uusi.toString().compareTo(alkio(i).toString());
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
