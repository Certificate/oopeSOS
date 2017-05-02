package oope2017ht;

/**
 *  Tämä luokka toimii syötteen tarkistuksen parissa. Ei muuta.
 *  Aika itsestäänselvää eikös?
 */

public class Tarkistaja {
    public boolean tarkistus (String str){
        boolean ok = false;
        for (int i = 0; i < str.length(); i++){
            char help = str.charAt(i);
            if ((help >= 'a' && help <= 'z')
                    || (help >= '0' && help <= '9')
                    || (help >= 'A' && help <= 'Z')
                    || (help == '.')
                    || (help == ' ')
                    || (help == '_')){
                ok = true;
            }
            else{
                return false;
            }
        }
        return ok;
    }

    public boolean numeroTarkistus (String str){
        boolean ok = false;
        for (int i = 0; i < str.length(); i++){
            char help = str.charAt(i);
            if (help >= '0' && help <= '9'){
                ok = true;
            }
            else{
                return false;
            }
        }
        return ok;
    }

    // Tarkistaa annetun String-arvon pisteiden lukumäärän.
    // Jos niitä on enemmän kuin 1, palauttaa metodi false-arvon.
    public boolean pisteTarkistus (String str){
        boolean ok = false;
        int pisteLaskuri = 0;
        for (int i = 0; i < str.length(); i++){
            char help = str.charAt(i);
            if ((help >= 'a' && help <= 'z')
                    || (help >= '0' && help <= '9')
                    || (help >= 'A' && help <= 'Z')
                    || (help == '.')
                    || (help == ' ')
                    || (help == '_')){
                ok = true;
                if (str.charAt(i) == '.'){
                    pisteLaskuri++;
                    if (pisteLaskuri >= 2){
                        pisteLaskuri = 0;
                        return false;
                    }
                }
            }
            else{
                return false;
            }
        }
        return ok;

    }
}
