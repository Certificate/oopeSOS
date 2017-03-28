/**
 *  Komentoja tulkkaava tulkki :) .
 */
public class Komentotulkki {

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
                ok = false;
            }
        }
        System.out.println("Totuusarvo palautuksessa: "+ok);
        return ok;


    }
}
