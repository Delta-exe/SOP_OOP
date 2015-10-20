package Uebungen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BDoering on 08.10.2015.
 */
public class RegAusIP {
    public static void main(String[] args) {


        try (BufferedReader br = new BufferedReader(new FileReader("neu.log"))) {
            String zeile = "";
            String [] hex;
            Pattern p = Pattern.compile("(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\."+
                    "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\." +
                    "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\."+
                    "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)");

            while ((zeile = br.readLine()) != null) {

                Matcher m = p.matcher(zeile);
                while (m.find()) {

                    System.out.printf("Krebs: %02X.%02X.%02X.%02X\n",
                            Integer.parseInt(m.group(1)),
                            Integer.parseInt(m.group(2)),
                            Integer.parseInt(m.group(3)),
                            Integer.parseInt(m.group(4)));


                    for (int i = 1; i <5 ; i++) {

                        System.out.print((Integer.toHexString(Integer.parseInt(m.group(i)))).toUpperCase() + ".");
                    }
                    System.out.println();

                }
            }


        }catch(IOException e){
            System.out.println("Fehler beim lesen...");
        }
    }
}

