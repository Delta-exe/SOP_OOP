package Hausaufgaben;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HA20150925 {
    public static void main(String[] args) {

        Long start =  System.currentTimeMillis(); // Zeit-Messung start
        List<String> complete = new ArrayList<>();
        File f = new File ("Text.txt");


        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(f))) {   //      face-smile.svg.png      laeuft_540.jpg
            byte [] b = new byte[16];
            int c = 0;
            int counter = 0;
            String gesamt = "";

            int laenge = getSize(f);
            System.out.println("F-Laenge= "+laenge);

            while ((c = input.read(b))!=-1){
                System.out.println();
                String text = "";
                String hex = "";
                String adresse = Integer.toHexString(counter).toUpperCase();
                while (adresse.length() < laenge)adresse = "0" + adresse;
                gesamt = adresse +": ";
                System.out.print(adresse + ": ");
                for(int i = 0; i<c;i++) {
                    int h = b[i];
                    if (h < 0) h = 256 + h;
                    hex = Integer.toHexString(h).toUpperCase();
                    if (hex.length() == 1) hex = "0" + hex;
                    text = text + hex;
                    gesamt = gesamt + hex + " ";
                    System.out.print(hex + " ");
                    counter++;



                }
                hex = "";
                while(c<16){

                    hex = "   " + hex;
                    c++;
                }
                text = " "+ toAscii(text);                                               //Start der Umwandlung in ASCII-Code, gespeichert in Text
                gesamt = gesamt + hex + text;
                complete.add(gesamt);
                System.out.print(hex + text);
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("komischertext.txt"))){
                for (String com : complete){
                    bw.write(com);
                    bw.newLine();
                }
            }
        }
        catch (IOException e){
            System.out.println("Fehler beim Lesen...!");
        }

        long ende = System.currentTimeMillis();
        System.out.println();
        System.out.println("Benoetigte Zeit: " + (ende-start));
    }
    public static int getSize(File f){
        int counter =0;
        int laenge=0;
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(f))){
            byte [] b = new byte[16];
            int c = 0;
            while ((c = input.read(b))!=-1){                                        //Befuellt die var c solange mit dem Inhalt aus b, bis -1 geworfen wird.
                String adresse = Integer.toHexString(counter).toUpperCase();        //Schreibt nach Adresse den Hex-Wert von Counter in Gross-Schrift
                laenge = adresse.length();                                          //Ueberschreibt bei jedem Durchlauf die groesse
                counter +=16;                                                       //Zaehlt die Adresse um 16 hoch
            }
        }
        catch (IOException e){
            System.out.println("Fehler beim Lesen...!");
        }
        return laenge;
    }//Beschafft die Groesse der Adresse

    public static String toAscii(String hex){
        String erg = "";
        erg = toAsciiRechner(hex, erg, 0);
        return erg;
    } // Maskierte Klasse für Rekursiven-Aufruf

    public static String toAsciiRechner(String hex,String erg, int zaehler){
        if(zaehler>=hex.length()){

            return erg;
        }
        String temp = hex.substring(zaehler, (zaehler+2));
        int zahl = Integer.parseInt(temp, 16);
        if(zahl < 33 ||zahl > 127)
            erg = erg +".";
        else
            erg = erg +  String.valueOf((char)zahl);
        erg = toAsciiRechner(hex, erg, zaehler+=2);
        return erg;
    }//Wandelt einen Hex-String rekursiv in ASCII-Zeichen um

    public static String toAsciiUnused(String hex){
        String erg ="";

        for( int i=0; i<hex.length(); i+=2 ){               // In Zweier Schritten ueber den Hex-String laufen
            String temp = hex.substring(i, (i+2));          // Zwei Stellen (als Zahl) aus den String herausschneiden
            int zahl = Integer.parseInt(temp, 16);          // Die herausgeschnittene Zahl in eine Dezimalzahl wandeln
            if(zahl < 33 ||zahl > 127)                      // Zahl < 33  und zahl > 127 wegen den Nicht ben?tigten Zeichen / Kommandos
                erg = erg +".";
            else
                erg = erg +  String.valueOf((char)zahl);
        }
        return erg;

    } //Wandelt einen HEX-String inkrementiell in ASCII-Zeichen um*/





}