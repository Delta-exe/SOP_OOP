package Unterricht;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDoering on 25.09.2015.
 */
public class CopyTool {

    public static void main(String[] args) {

        List<byte[]> bytes = new ArrayList();

        File f = new File("test1.bmp");
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f))) {

            byte [] puffer = new byte [1024];

            int anzahl;
            while ((anzahl = bis.read(puffer)) !=-1){
                byte[] toStore = new byte [anzahl];
                for(int i =0;i<anzahl; i++)
                    toStore[i] = puffer[i];
                bytes.add(toStore);
            }


            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test_neu.bmp"))){
                for(byte[]bs : bytes)
                    bos.write(bs);
            }
        }catch (IOException e){
            System.out.println("Fehler beim Lesen...!");
        }
    }
}
