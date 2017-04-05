package oopeSOS;

import apulaiset.Ooperoiva;
import fi.uta.csjola.oope.lista.*;

/**
 *   LinkitetystäListasta johdettu OmaLista luokka
 */

public class OmaLista extends LinkitettyLista implements Ooperoiva{

    public Object hae(Object haettava) {
        int i = 0;
        while(i < koko()) {
            if(haettava.equals(alkio(i))) {
                return alkio(i);
            }
            i++;
        }
        return null;
    }

    public boolean lisaa(Object uusi) {
        if (uusi != null) {
            String apu = uusi.toString();
            int i = 0;
            if (koko() > 0) {
                while (i < koko()) {
                    String temp2 = alkio(i).toString();
                    int k = apu.compareTo(temp2);
                    if (k > 0) {
                        i++;
                    } else if (k <= 0) {
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
        int i = 0;
        while(i < koko()) {
            if(poistettava.equals(alkio(i))) { poista(i);}
            i++;
        }
        return null;
    }



}
