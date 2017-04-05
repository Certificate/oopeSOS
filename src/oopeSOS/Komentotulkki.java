package oopeSOS;

/**
 *  Komentoja tulkkaava tulkki :) .
 */
public class Komentotulkki {

    // Alla kaikki harjoitustyössä käytettävät komennot
    // katso dokumentaatio

    private static final String MAKEDIR = "md";
    private static final String MAKEFIL = "mf";
    private static final String CHANGEDIR = "cd";
    private static final String LIST = "ls";
    private static final String FIND = "find";
    private static final String REMOVE = "rm";
    private static final String COPY = "cp";
    private static final String MOVE = "mv";
    private static final String EXIT = "exit";

    private String polku = "/>";

    // Tarkistetaan ovatko annetun syötteen merkit ok
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
        return ok;
    }

    public int tulkkaa(String komento){
        if (komento.equals(EXIT)){
            return 0;
        }
        else{
            System.out.println("Väärä komento! Kokeile uudestaan.");
            return 1;
        }
    }

    public void asetaPolku(String str){
        this.polku = str;
    }

    public void luePolku(){
        System.out.print(polku);
    }
}

