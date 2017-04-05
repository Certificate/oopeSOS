package oopeSOS;

import apulaiset.Ooperoiva;
import fi.uta.csjola.oope.lista.*;

/**
 *   LinkitetystäListasta johdettu OmaLista luokka
 */

public class OmaLista extends LinkitettyLista implements Ooperoiva{

    public Object hae(Object get) {
        if(get != null) {
            int i = 0;
            while (i < koko()) {
                if (get.equals(alkio(i))) {
                    System.out.println("Sisältä");
                    return alkio(i);
                }
                i++;
            }
            return null;
        }
        else
            return null;
    }

    public boolean lisaa(Object uusi) {
        if (uusi != null) {
            String help = uusi.toString();
            int i = 0;
            if (koko() > 0) {
                while (i < koko()) {
                    String temp2 = alkio(i).toString();
                    int z = help.compareTo(temp2);
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
        int i = 0;
        while(i < koko()) {
            if(poistettava.equals(alkio(i))) { poista(i);}
            i++;
        }
        return null;
    }



}
