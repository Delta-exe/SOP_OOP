package Hausaufgaben;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class HA20151009 {
    HashMap<String, Integer> hMap = new HashMap<>();
    int woerter = 0;
    public void bibelLesen(String text){
        try (BufferedReader br = new BufferedReader(new FileReader(text))) {
            String zeile;

            while ((zeile = br.readLine()) != null) {
                zeile = zeile.toLowerCase();
                String[] temp = zeile.split("[0-9,!?:;)»«(. ]"); //
                for (int i = 0; i < temp.length; i++) {
                    if(!temp[i].equals("")){
                        if(hMap.containsKey(temp[i])) {
                            hMap.replace(temp[i], hMap.get(temp[i]) + 1);
                            woerter++;
                        }else {
                            hMap.put(temp[i], 1);
                            woerter++;
                        }
                    }
                }
            }
        }
        catch(IOException e){
            System.out.println("Fehler beim lesen/schreiben...");
        }
    }

    public void copy (){
        TreeMap<Integer, String> tMap = new TreeMap<>();

        String temp;
        for(String key: hMap.keySet()){
            if(tMap.containsKey(hMap.get(key))) {
                tMap.replace(hMap.get(key), key + ", " + tMap.get(hMap.get(key)));
            }else
                tMap.put(hMap.get(key),key);

        }
        long gesamt = 0;
        for(int key2 : tMap.keySet())
        {

            gesamt = gesamt+  key2;
            System.out.println("Anzahl: " + key2);
            System.out.print("Wort/e: " + tMap.get(key2) + "\n");
            System.out.println();
        }
        System.out.println("Gesamt: " + woerter);
    }
}