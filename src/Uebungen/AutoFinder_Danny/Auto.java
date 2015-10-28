package Uebungen.AutoFinder_Danny;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dbernhardt on 23.10.2015.
 */
public class Auto {
    private String pTitel=""; // der erste Eintrag ist immer der Titel
    private String pTyp="^(Klein.*|Komb.*|Lim.*|Van( )?\\/( )?Mini.*|Sport.*( )?\\/( )? Cou.*|Cab.*( )?\\/( )?Road.*)$";
    private String pGetriebe="^(Automatik.*|Schalt.*)$";
    private String pHU="HU( )?(0[0-9]|1[0-2])( )?\\/( )?[0-9]{4}|HU( )?(NEU)";
    private String pLeistung="[0-9]{2,}( )?[kKwW]{2}( )?\\([0-9]{2,}( )?[PpSs]{2}\\)";
    private String pKraftstoff="([dD]iesel|[Bb]enzin|([Aa]uto|[Ee]rd)gas|[Hh]ybrid)";
    private String pPlz="DE\\s?-\\s?\\d{5}\\s?[A-Z]?[-a-zA-Z äöüßÄÖÜ.()]*";
    private String pKm="\\d{3}\\.?\\d{3}( )?[kK][mM]";
    private String pEz="EZ\\s?[01]\\d\\/[12]\\d{3}";
    private String pKosten="^\\d{0,3}\\.?\\d{3}\\s?€$";

    private String titel = "";
    private String plz="";
    private String typ = "";
    private String getriebe = "";
    private String hu = "";
    private String leistung = "";
    private String kraftstoff = "";
    private String km="";
    private String ez="";
    private String kosten="";


    public String getpTitel() {
        return pTitel;
    }

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

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setPlz(String plz) {
        this.plz = plz;
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
        this.leistung = leistung;
    }

    public void setKraftstoff(String kraftstoff) {
        this.kraftstoff = kraftstoff;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public void setEz(String ez) {
        this.ez = ez;
    }

    public void setKosten(String kosten) {
        this.kosten = kosten;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "titel='" + titel + '\'' +
                ", plz='" + plz + '\'' +
                ", typ='" + typ + '\'' +
                ", getriebe='" + getriebe + '\'' +
                ", hu='" + hu + '\'' +
                ", leistung='" + leistung + '\'' +
                ", kraftstoff='" + kraftstoff + '\'' +
                ", km='" + km + '\'' +
                ", ez='" + ez + '\'' +
                ", kosten='" + kosten + '\'' +
                '}';
    }
}
