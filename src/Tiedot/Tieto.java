package Tiedot;

/**
 *  TIEDOT- YLILUOKKA
 */

public abstract class Tieto {

    private StringBuilder nimi = new StringBuilder();

    public Tieto() {
        asetaString("");
    }
    public Tieto(String str){
        asetaString(str);
    }

    public void asetaString(String str){
        this.nimi.append(str);
    }

    public String lueString(){
        return this.nimi.toString();
    }

}
