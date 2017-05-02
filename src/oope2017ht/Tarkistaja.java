package oope2017ht;

/**
 * <p>
 * Tämä luokka toimii syötteen tarkistuksen parissa. Ei muuta. Aika itsestäänselvää eikös?
 * <p>
 * @author Valtteri Vuori (vuori.valtteri.j@student.uta.fi),
 * Tietojenkäsittelytiede, Tampereen yliopisto.
 */


public class Tarkistaja {

    /** Tarkistaa onko annettu syöte harjoitustyön sallittujen merkkien rajoissa.
     *
     * @param str annettu String muotoinen parametri.
     * @return true jos parametri läpäisee tarkistuksen. false mikäli ei.
     */
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

    /** Tarkistaa onko annettu syöte desimaalinumero, vai ei. Esimerkiksi 3A ei ole desimaalinumero, vaan heksa-.
     *
     * @param str annettu String muotoinen parametri.
     * @return true jos parametri läpäisee tarkistuksen. false mikäli ei.
     */
    boolean numeroTarkistus(String str){
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

    /** Tarkistaa annetun String-arvon pisteiden lukumäärän.
     *
     * @param str annettu String muotoinen parametri.
     * @return true jos parametri läpäisee tarkistuksen. false mikäli ei.
     */
    boolean pisteTarkistus(String str){
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
