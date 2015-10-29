package Uebungen.AutoFinder_Danny;

import java.util.ArrayList;
import java.util.List;

public class Auto {
    private String pTitel=""; // der erste Eintrag ist immer der Titel
    private String pTyp="^(Klein.*|Komb.*|Lim.*|Van( )?\\/( )?Mini.*|Sport.*( )?\\/( )? Cou.*|Cab.*( )?\\/( )?Road.*)$";
    private String pGetriebe="^(Automatik.*|Schalt.*)$";
    private String pHU="HU( )?(0[0-9]|1[0-2])( )?\\/( )?[0-9]{4}|HU( )?.*";
    private String pLeistung= "[0-9]{2,}( )?[kKwW]{2}( )?\\([0-9]{2,}( )?[PpSs]{2}\\).*";
    private String pKraftstoff=".*([dD]iesel|[Bb]enzin|[Aa]uto.*|[Ee]rd.*|[Hh]ybr.*)";
    private String pPlz="DE\\s?-\\s?\\d{5}\\s?[A-Z]?[-a-zA-Z äöüßÄÖÜ.()]*";
    private String pKm="^[0-9]{0,3}\\.?[0-9]{1,3}( )?[KkMm]{2}\\s*";
    private String pEz="EZ\\s?[01]\\d\\/[12]\\d{3}";
    private String pKosten="^\\d{0,3}\\.?\\d{1,3}\\s?€$";

    private String titel = "Keine Angabe";
    private String ort="Keine Angabe";
    private String typ = "Keine Angabe";
    private String getriebe = "Keine Angabe";
    private String hu = "Keine Angabe";
    private String leistung = "Keine Angabe";
    private String kraftstoff = "Keine Angabe";
    private String ez="Keine Angabe";
    private int ezMo;
    private int ezJa;
    private String kosten="Keine Angabe";
    private int kilom = 0;
    private int plzNeu = 0;
    private String land = "Keine Angabe";
    private int kw;
    private int ps;
    private String [] puffer;
    private List<String> extras = new ArrayList<>();


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

    public String getpKraftstoff() {
        return pKraftstoff;
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

    public List<String> getExtras(){
        return extras;
    }

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
        km = km.substring(0,km.length()-3);  //17.000


        if(km.contains(".")){
            km = km.replace(".","");
            this.kilom = Integer.parseInt(km);
        } else
            this.kilom = Integer.parseInt(km);

    }

    public void setEz(String ez) {
        //EZ /1992
        ez = ez.replace("/"," ");
        puffer = ez.split(" ");
        ezMo = Integer.parseInt(puffer[1]);
        ezJa = Integer.parseInt(puffer[2]);



    }

    public void setKosten(String kosten) {
        this.kosten = kosten;
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
                "Preis = " + kosten + "\n"+
                "Extras = " + extras.toString();

    }
}
