package Hausaufgaben;
import javax.xml.bind.SchemaOutputResolver;
import java.sql.Time;
import java.util.HashMap;

/**
 * Created by BDoering on 02.10.2015.
 */
public class main {

    public static void main(String[] args) {

        Long x = System.currentTimeMillis();
        HA20151009 ha = new HA20151009();

        ha.bibelLesen("Bibel.txt");
        ha.copy();

        System.out.print("Zeit: "+(System.currentTimeMillis() - x) +" ms");




    }
}
