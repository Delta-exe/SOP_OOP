package Hausaufgaben.HA20151113;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hilfsmethoden {
    public List<Auto> einlesen(String datei) {
        String patternStr = "(^[a-zA-ZüöäÜÖÄß0-9≈].*$)";
        Pattern pattern = Pattern.compile(patternStr);
        List<Auto> autoListe = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(datei))) {
            String zeile = null;
            String temp = "Start";
            Auto a = new Auto();

            while ((zeile = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(zeile);

                while (matcher.find()) {

                    if (zeile.matches(a.getpTyp())) {
                        a.setTyp(zeile);
                        break;
                    } else if (zeile.matches(a.getpPlz())) {
                        a.setTitel(temp);
                        a.setPlz(zeile);
                        break;
                    } else if (zeile.matches(a.getpGetriebe())) {
                        a.setGetriebe(zeile);
                        break;
                    } else if (zeile.matches(a.getpHU())) {
                        a.setHu(zeile);
                        break;
                    } else if (zeile.matches(a.getpLeistung())) {
                        if (zeile.contains(",")) {
                            a.setLeistung(zeile.substring(0, zeile.indexOf(",")));
                            a.setKraftstoff(zeile.substring(zeile.indexOf(",") + 2, zeile.length()));
                        } else
                            a.setLeistung(zeile);
                        break;
                    } else if (zeile.matches(a.getpKosten())) {
                        a.setKosten(zeile);
                        break;
                    } else if (zeile.matches(a.getpKm())) {
                        a.setKm(zeile);
                        break;
                    } else if (zeile.matches(a.getpEz())) {
                        a.setEz(zeile);
                        break;
                    } else if (matcher.group().contains("Finanz")) {
                        autoListe.add(a);
                        //System.out.println("\n-----------------------------\n\n" + a.toString());
                        a = new Auto();
                        break;
                    } else {
                        a.setExtras(zeile);
                    }


                }
                temp = zeile;
            }
        } catch (IOException e) {
            System.out.println("Fehler beim lesen");
        }
        return autoListe;
    }


    public void ausgabe(List<Auto> al) {
        JFrame frm = new JFrame("Autofinder");
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JList list = new JList(al.toArray());
        list.setOpaque(true);

        JScrollPane jsp = new JScrollPane(list);
        jsp.setOpaque(true);

        frm.add(jsp);

        frm.setSize(1200, 500);
        frm.setVisible(true);

    }



}
