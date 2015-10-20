package Unterricht;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Standard Quellcode zum Einlesen einer Textdatei!
public class FileReader {
    public static void main(String[] args) {

        List<String> al = new ArrayList();


        //STANDARD FILE READER

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader("Nationalhymne.txt"))){
            String zeile = null;

            while ((zeile = reader.readLine()) != null)
                al.add(0,zeile);
        }
        catch (IOException e){
            System.out.println("Fehler beim Lesen...!");
        }

        for(int i = 0; i<al.size();i++){
            System.out.println(al.get(i));
        }

        // STANDARD FILE Writer
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("NationalNeu.txt"))) {


            for(String zeile : al) {
                writer.write(zeile);
                writer.newLine();

            }
        }
        catch (IOException e){
            System.out.println("Fehler beim Schreiben...!");
        }


        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream("laeuft_540.jpg"))) {

            byte [] b = new byte[16];

            int c = 0;
            while ((c = input.read(b))!=-1){
                System.out.println();
                for(int i = 0; i<c;i++){
                    int h = b[i];
                    if(h<0)
                        h = 256 + h;
                    String hex = Integer.toHexString(h).toUpperCase();
                    if (hex.length() == 1) hex = "0" + hex;
                    System.out.print(hex + " ");

                }
            }

        }


        catch (IOException e){
            System.out.println("Fehler beim Lesen...!");
        }
//DAS IST EIN TEST!!






    }

}




