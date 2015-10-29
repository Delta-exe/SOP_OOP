package Uebungen.AutoFinder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class sim {
    public static void main(String[] args) {
        Hilfsmethoden hm = new Hilfsmethoden();
        int zahl=0;

        List<Auto> al = new ArrayList<>();

        for (int i = 1; i < 254; i++) {
            File f = new File ("D:\\Dropbox\\FSBwIT\\workspace\\SOP_OOP\\TestFiles\\Autos\\Autos_"+i+".txt");

            //File f = new File("Y:\\3_XI\\XI_6\\302_SOP_OOP\\Autos\\Autos_" + i +".txt");
            if(f.exists()) {
                //hm.einlesen("Y:\\3_XI\\XI_6\\302_SOP_OOP\\Autos\\Autos_" + i + ".txt");
                al.addAll(hm.einlesen("D:\\Dropbox\\FSBwIT\\workspace\\SOP_OOP\\TestFiles\\Autos\\Autos_" + i + ".txt"));
                zahl++;
            }
        }


        System.out.println(zahl + " Dateien eingelesen");
        System.out.println("Größe der Liste: " + al.size());


        zahl = 0;
        for (Auto a: al){
            zahl++;
            System.out.println("\n-----------------------------\n\n" +"Nr. " + zahl + "\n" + a.toString());
        }









    }
}