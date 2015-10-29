package AutoSuche;

import java.io.*;

/**
 * Created by Delta.exe on 23.10.2015.
 */
public class main {

    public static void main(String[] args) {

        File datei = new File("D:\\Dropbox\\FSBwIT\\workspace\\SOP_OOP\\src\\AutoSuche");

        String[] autos = datei.list();


        try {
            BufferedReader br = new BufferedReader(new FileReader("bla")) {




            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}

