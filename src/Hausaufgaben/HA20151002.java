package Hausaufgaben;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HA20151002 {


    public static void main(String[] args) {

        Long start =  System.currentTimeMillis(); // Zeit-Messung start

        List<String> hexSpeicher = new ArrayList<>(); // Speicher für die einzelnen Hex-Strings
        List<byte[]> bytes = new ArrayList<>();

        File f = new File ("test2.txt");

        try(BufferedReader bis = new BufferedReader(new FileReader(f))){


            String temp = null;                     //temporärer String speicher für Hex-Code
            int stelle = 0;                         //Markierer (zaehler) um SubString anzusetzen
            boolean known = false;

            while((temp = bis.readLine())!=null){   //String einlesen, solange etwas kommt.

                if(!known)                              //":" als Markierung wann HEX-Code beginnt
                    while (temp.charAt(stelle) != ':') {
                        stelle++;
                        known = true;
                    }
                String neu = temp.substring(stelle + 2, stelle + 50).replaceAll(" ","");    //Hex-Code aus dem String extrahieren und die Leerzeichen entfernen

                hexSpeicher.add(neu);                                                       //Verbleibender Hex-String in die Liste speichern
            }

            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("testbild.bmp"))){
                for(int i =0;i<hexSpeicher.size();i++){
                    byte[] ausg  = DatatypeConverter.parseHexBinary(hexSpeicher.get(i));  //Hole den HexString aus der Liste und wandle Ihn zu einem Binären Code, speiche das Ergebnis in das Byte Array Ausg
                    for(byte a: ausg) {                                                   //Eiere durch das Byte Array Ausg und übergebe an bos
                        bos.write(a);
                    }
                }


                System.out.println("ENDE");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei!");
        }
        long ende = System.currentTimeMillis();
        System.out.println();
        System.out.println("Benoetigte Zeit: " + (ende-start));

    }



}