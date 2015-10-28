package Uebungen.AutoFinder_Danny;
import java.io.File;

/**
 * Created by dbernhardt on 20.10.2015.
 */
public class sim {
    public static void main(String[] args) {
        Hilfsmethoden hm = new Hilfsmethoden();
        int zahl=0;
        //  hm.einlesen("Autos_4.txt");
        for (int i = 1; i < 254; i++) {
            File f = new File("Y:\\3_XI\\XI_6\\302_SOP_OOP\\Autos\\Autos_" + i +".txt");
            if(f.exists()) {
                hm.einlesen("Y:\\3_XI\\XI_6\\302_SOP_OOP\\Autos\\Autos_" + i + ".txt");
                zahl++;
            }
        }
        System.out.println(zahl);


    }
}