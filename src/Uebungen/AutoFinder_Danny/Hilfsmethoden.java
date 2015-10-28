package Uebungen.AutoFinder_Danny;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hilfsmethoden {
    public void einlesen(String datei) {
        String patternStr = "(^[a-zA-ZüöäÜÖÄß0-9≈].*$)";
        Pattern pattern = Pattern.compile(patternStr);


        try (BufferedReader br = new BufferedReader(new FileReader(datei))) {
            String zeile = null;
            String puffer = null;
            String temp = "Start";
            ArrayList<Auto> autoListe = new ArrayList<>();
            Auto a = new Auto();

            while ((zeile = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(zeile);

                while (matcher.find()) {

                    if (zeile.matches(a.getpTyp())) {
                        a.setTyp(zeile);
                        break;
                    }
                    if (zeile.matches(a.getpPlz())) {
                        a.setTitel(temp);
                        a.setPlz(zeile);
                        break;
                    }
                    if (zeile.matches(a.getpGetriebe())) {
                        a.setGetriebe(zeile);
                        break;
                    }
                    if (zeile.matches(a.getpHU())) {
                        a.setHu(zeile);
                        break;
                    }
                    if (zeile.matches(a.getpLeistung())) {
                        if (zeile.contains(",")) {
                            a.setLeistung(zeile.substring(0, zeile.indexOf(",")));
                            a.setKraftstoff(zeile.substring(zeile.indexOf(",") + 2, zeile.length()));
                        } else
                            a.setLeistung(zeile);
                        break;
                    }
              /*      if (zeile.matches(a.getpKraftstoff())) {
                        a.setKraftstoff(zeile);
                        break;
                    }*/

                    if (zeile.matches(a.getpKosten())) {
                        a.setKosten(zeile);
                        break;
                    }
                    if (zeile.matches(a.getpKm())) {
                        a.setKm(zeile);
                        break;
                    }
                    if (zeile.matches(a.getpEz())) {
                        a.setEz(zeile);
                        break;
                    }
                    if (matcher.group().contains("Finanz")) {
                        autoListe.add(a);
                        System.out.println("\n------------------------------\n" + a.toString());
                        break;
                    }

                }
                temp = zeile;
            }
        } catch (IOException e) {
            System.out.println("Fehler beim lesen");
        }
    }
}
