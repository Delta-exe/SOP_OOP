package Uebungen;

import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class umdrehen {

    public static void main(String[] args) {

        String text = "Hallo das ist ein Test!";

        umdrehen um = new umdrehen();


        /**/System.out.println(um.drehen (text));
        System.out.println(um.sortiere(text));
        System.out.println(um.sort2(text));


    }



    public String drehen (String text) {

        String erg = "";

        if (text == null) {
            return null;
        } else {
            for (int i = 0 ; i<text.length(); i++){
                erg = text.charAt(i) +erg;
            }
        }


        return erg;
    }

    public String sortiere (String text){

        char[] ret = text.toCharArray();
        Arrays.sort(ret);

        return new String (ret);

    }

    public String sort2 (String s){
        List<String> tmp = new ArrayList<>();
        for (char c: s.toCharArray())
            tmp.add(""+c);
        Collections.sort(tmp, String.CASE_INSENSITIVE_ORDER);
        String ret = "";
        for(String c: tmp) ret+=c;
        return ret;
    }


}
