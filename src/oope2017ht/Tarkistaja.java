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
}
