package Uebungen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BDoering on 29.09.2015.
 */

public class BibelRa {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("bibel.txt"))) {
            Pattern p = Pattern.compile("\\b([äüöÄÜÖ][a-zäöüß]+)|([a-zA-Z][a-z]*[äüöß][a-zäüöß]*)");         // Pattern wird genutzt um die Regulaeren Ausdruecke zu laden, suche nach "String"
            String zeile;
            int zaehler = 0;
            while ((zeile = br.readLine()) != null) {
                Matcher m = p.matcher(zeile);           // Erzeugt einen neuen "Sucher" der im String Zeile, mittels des Matchers der Pattern nach dem Regulären Ausdruck sucht

                // Alternative mit IF - Bedingung

                /*if (m.find())                         // wenn der Matcher etwas mit m.find() findet, dann ...
                    System.out.println(m.group());      // wird mit m.group() die Ausgabe in die Konsole geschrieben.
            }*/

                // Alternative mit While - Schleife

                while (m.find())
                    zaehler++;
            }
            System.out.println("an " + zaehler);


        } catch (IOException e) {
            System.out.println("Fehler beim Aufschlagen der Bibel...");
        }
    }
}

