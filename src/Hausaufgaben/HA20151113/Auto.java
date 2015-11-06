package Hausaufgaben.HA20151113;

import java.util.ArrayList;
import java.util.List;

public class Auto implements Comparable<Auto> { //
    private String pTyp="^(Klein.*|Komb.*|Lim.*|Van( )?\\/( )?Mini.*|Sport.*( )?\\/( )? Cou.*|Cab.*( )?\\/( )?Road.*)$";
    private String pGetriebe="^(Automatik.*|Schalt.*)$";
    private String pHU="HU( )?(0[0-9]|1[0-2])( )?\\/( )?[0-9]{4}|HU( )?.*";
    private String pLeistung= "[0-9]{2,}( )?[kKwW]{2}( )?\\([0-9]{2,}( )?[PpSs]{2}\\).*";
    private String pPlz="DE\\s?-\\s?\\d{5}\\s?[A-Z]?[-a-zA-Z äöüßÄÖÜ.()]*";
    private String pKm="^[0-9]{0,3}\\.?[0-9]{1,3}( )?[KkMm]{2}\\s*";
    private String pEz="EZ\\s?[01]\\d\\/[12]\\d{3}";
    private String pKosten="^\\d{0,3}\\.?\\d{1,3}\\s?€$";

    private String titel = "Keine Angabe";
    private String ort="Keine Angabe";
    private String typ = "Keine Angabe";
    private String getriebe = "Keine Angabe";
    private String hu = "Keine Angabe";
    private String kraftstoff = "Keine Angabe";
    private int ezMo;
    private int ezJa;

    private int kilom = 0;
    private int plzNeu = 0;
    private String land = "Keine Angabe";
    private int kw;
    private int ps;
    private String [] puffer;
    private List<String> extras = new ArrayList<>();
    int preis = -1;


    public String getpTyp() {
        return pTyp;
    }

    public String getpGetriebe() {
        return pGetriebe;
    }

    public String getpHU() {
        return pHU;
    }

    public String getpLeistung() {
        return pLeistung;
    }

    public String getpPlz() {
        return pPlz;
    }

    public String getpKm() {
        return pKm;
    }

    public String getpEz() {
        return pEz;
    }

    public String getpKosten() {
        return pKosten;
    }

    public int getPlzNeu(){return plzNeu;}

    public String getTitel() {return titel;}

    public String getOrt() {return ort;}

    public int getKosten() {return preis;}

    public int getPlz(){return plzNeu;}


    /// ###################### START SETTER ##############################

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setPlz(String plz) {
        puffer = plz.split(" ");
        land = puffer[0];
        plzNeu = Integer.parseInt(puffer[2]);
        ort=puffer[3];


    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setGetriebe(String getriebe) {
        this.getriebe = getriebe;
    }

    public void setHu(String hu) {
        this.hu = hu;
    }

    public void setLeistung(String leistung) {

        leistung = leistung.replace("(","");
        leistung = leistung.replace(")","");
        puffer = leistung.split(" ");

        ps = Integer.parseInt(puffer[0]);
        kw = Integer.parseInt(puffer[2]);

    }

    public void setKraftstoff(String kraftstoff) {
        this.kraftstoff = kraftstoff;
    }

    public void setKm(String km) {
        //17.000 km
        /*this.km = km;*/
        km = km.replace("\t", "");
        km = km.substring(0, km.length() - 3);  //17.000


        if(km.contains(".")){
            km = km.replace(".","");
            this.kilom = Integer.parseInt(km);
        } else
            this.kilom = Integer.parseInt(km);

    }

    public void setEz(String ez) {
        //EZ /1992
        ez = ez.replace("/", " ");
        puffer = ez.split(" ");
        ezMo = Integer.parseInt(puffer[1]);
        ezJa = Integer.parseInt(puffer[2]);



    }

    public void setKosten(String kosten) {

        kosten = kosten.replace("\t", "");
        kosten = kosten.substring(0, kosten.length() - 2);


        if(kosten.contains(".")){
            kosten = kosten.replace(".","");
            this.preis = Integer.parseInt(kosten);
        } else
            this.preis = Integer.parseInt(kosten);


    }

    public void setExtras(String s) {
        extras.add(s);
    }

    @Override
    public String toString() {
        return  "Bezeichnung : " + titel + '\'' + "\n"+
                "Land = " + land + "\n" +
                "Plz = " + plzNeu + "\n" +
                "Ort = " + ort + "\n" +
                "Typ = " + typ + "\n" +
                "Getriebe = " + getriebe + "\n" +
                "HU = " + hu + "\n" +
                "Leistung = " + kw + " kW / " + ps + " PS " + "\n" +
                "Kraftstoff = " + kraftstoff + "\n" +
                "Km-Stand = " + kilom + " km" + "\n" +
                "EZ = " + ezMo + " / " + ezJa + "\n" +
                "Preis = " + preis + " € " + "\n"+
                "Extras = " + extras.toString();

    }


    public int compareTo(Auto o) {
        int ret = this.titel.compareTo(o.titel);
        if (ret == 0) {
            ret = this.kilom- o.kilom;
            if (ret == 0) {
                ret = this.ezJa - o.ezJa;
                if(ret== 0)
                    ret = this.ezMo - o.ezMo;
                if (ret == 0)
                    ret = this.preis - o.preis;
            }
        }


        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;

        Auto auto = (Auto) o;

        if (ezMo != auto.ezMo) return false;
        if (ezJa != auto.ezJa) return false;
        if (kilom != auto.kilom) return false;
        if (getPlzNeu() != auto.getPlzNeu()) return false;
        if (kw != auto.kw) return false;
        if (ps != auto.ps) return false;
        if (preis != auto.preis) return false;
        if (titel != null ? !titel.equals(auto.titel) : auto.titel != null) return false;
        if (ort != null ? !ort.equals(auto.ort) : auto.ort != null) return false;
        if (typ != null ? !typ.equals(auto.typ) : auto.typ != null) return false;
        if (getriebe != null ? !getriebe.equals(auto.getriebe) : auto.getriebe != null) return false;
        if (hu != null ? !hu.equals(auto.hu) : auto.hu != null) return false;
        if (kraftstoff != null ? !kraftstoff.equals(auto.kraftstoff) : auto.kraftstoff != null) return false;
        if (land != null ? !land.equals(auto.land) : auto.land != null) return false;
        return !(extras != null ? !extras.equals(auto.extras) : auto.extras != null);

    }

    @Override
    public int hashCode() {
        int result = titel != null ? titel.hashCode() : 0;
        result = 31 * result + (ort != null ? ort.hashCode() : 0);
        result = 31 * result + (typ != null ? typ.hashCode() : 0);
        result = 31 * result + (getriebe != null ? getriebe.hashCode() : 0);
        result = 31 * result + (hu != null ? hu.hashCode() : 0);
        result = 31 * result + (kraftstoff != null ? kraftstoff.hashCode() : 0);
        result = 31 * result + ezMo;
        result = 31 * result + ezJa;
        result = 31 * result + kilom;
        result = 31 * result + getPlzNeu();
        result = 31 * result + (land != null ? land.hashCode() : 0);
        result = 31 * result + kw;
        result = 31 * result + ps;
        result = 31 * result + (extras != null ? extras.hashCode() : 0);
        result = 31 * result + preis;
        return result;
    }
}
