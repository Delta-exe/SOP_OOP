package Uebungen;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by BDoering on 13.10.2015.
 */
public class PKSuche {


    public static void main(String[] args) throws FileNotFoundException {

        try (BufferedReader br = new BufferedReader(new FileReader("bibel.txt"))) {

            Pattern p = Pattern.compile("[1-2]\\d |0[1-9]|[3][01][0][1-9]|[1][0-2]\\d\\d\\-[A-Z]\\-[0-9]{5} ");
            String zeile;
            while((zeile = br.readLine())!=null  ){
                Matcher m = p.matcher(zeile);

                System.out.println(m.group());

            }




        } catch (IOException e) {
            System.out.println("Lesefehler...!");
        }


    }
}