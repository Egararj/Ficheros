package flujodedatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {
    public static String dato() throws IOException{
        String dato="";

        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);


        dato=br.readLine();


        return dato;
    }

    public static int datoInt () throws NumberFormatException,IOException {
        int num=0;
        String dato="";
        dato=dato();
        num=Integer.parseInt(dato);

        return num;
    }
}
