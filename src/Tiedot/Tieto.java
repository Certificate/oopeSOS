package Tiedot;

/**
 *  TIEDOT- YLILUOKKA
 */

public abstract class Tieto {

    private StringBuilder nimi = new StringBuilder();

    public Tieto() {
        asetaString("null");
    }

    public Tieto(String x){
        asetaString(x);
    }

    public void asetaString(String str){
        this.nimi.append(str);
    }

    public String lueString(){
        return this.nimi.toString();
    }

}
