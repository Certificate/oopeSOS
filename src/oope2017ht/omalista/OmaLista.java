package oope2017ht.omalista;

import apulaiset.Ooperoiva;
import fi.uta.csjola.oope.lista.*;
/**
 * <p>
 * LinkitetystäListasta johdettu OmaLista luokka johon on implementoitu Ooperoiva-rajapinnassa ohjeistetut metodit.
 * <p>
 * @author Valtteri Vuori (vuori.valtteri.j@student.uta.fi),
 * Tietojenkäsittelytiede, Tampereen yliopisto.
 */


public class OmaLista extends LinkitettyLista implements Ooperoiva{

    /** Haetaan objektia listasta.
     *
     * @param get on Object muotoinen parametri. Haetaan OmastaListasta tätä vastaavaa toista objektia.
     * @return alkio kohdassa i, mikäli löytyy vastaava. null jos ei.
     */
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

    /** Lisätään Olio listaan.
     *
     * @param uusi on Object muotoinen parametri. Lisätään OmaanListaan oikealle kohdalle aakkosjärjestykseen.
     * @return true jos lisäys onnistuu. false jos ei.
     */
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

    /** Haetaan objektia listasta.
     *
     * @param poistettava on Object muotoinen parametri, joka poistetaan liastasta.
     * @return poista(i) , jossa i on alkio listassa. Tämä alkio poistetaan. null mikäli poisto ei onnistunut tai vastaavaa objektia ei ole säilötty Omaan Listaan.
     */
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
