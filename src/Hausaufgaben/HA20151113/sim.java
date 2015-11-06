package Hausaufgaben.HA20151113;

import java.io.File;
import java.util.*;

public class sim {
    public static void main(String[] args) {

        Comparator<Auto> compPlz = new PlzComparator();
        Comparator<Auto> compName = new NameComparator();
        Comparator<Auto> compKost = new KostComparator();
        Hilfsmethoden hm = new Hilfsmethoden();
        int zahl = 0;

        List<Auto> al = new ArrayList<>();

        for (int i = 1; i < 254; i++) {
            File f = new File("D:\\Dropbox\\FSBwIT\\workspace\\SOP_OOP\\TestFiles\\Autos\\Autos_" + i + ".txt");

            //File f = new File("Y:\\3_XI\\XI_6\\302_SOP_OOP\\Autos\\Autos_" + i +".txt");
            if (f.exists()) {
                //hm.einlesen("Y:\\3_XI\\XI_6\\302_SOP_OOP\\Autos\\Autos_" + i + ".txt");
                al.addAll(hm.einlesen("D:\\Dropbox\\FSBwIT\\workspace\\SOP_OOP\\TestFiles\\Autos\\Autos_" + i + ".txt"));
                zahl++;
            }
        }


        System.out.println(zahl + " Dateien eingelesen");
        System.out.println("Ursprüngliche Größe der Liste: " + al.size());


        Set<Auto> s = new TreeSet<>();
        s.addAll(al);
        al.clear();
        al.addAll(s);

        System.out.println("Größe der Liste: " + al.size());


        Scanner scan = new Scanner(System.in);
        for (; true; ) {

            System.out.println("Bitte wählen Sie:");
            System.out.println("1.Sortiert nach Name");
            System.out.println("2.Sortiert nach Ort");
            System.out.println("3.Sortiert nach Preis");
            System.out.println("4.Beendet das Programm");
            String wert = scan.next();
            switch (wert) {
                case "1":
                    al.sort(compName);
                    hm.ausgabe(al);
                    break;
                case "2":
                    al.sort(compPlz);
                    hm.ausgabe(al);
                    break;
                case "3":
                    al.sort(compKost);
                    hm.ausgabe(al);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Falsche Eingabe! Bitte nur Zahlen von 1-3");
            }
        }

    }
    private static class PlzComparator implements Comparator<Auto> {
        public int compare(Auto a1, Auto a2) {return a1.getOrt().compareTo(a2.getOrt());}
    }

    private static class KostComparator implements Comparator<Auto> {
        public int compare(Auto a1, Auto a2) {return a1.getKosten() - a2.getKosten();}
    }

    private static class NameComparator implements Comparator<Auto>{
        public int compare (Auto a1, Auto a2){return (a1.getTitel().compareTo(a2.getTitel()));}
    }
}


