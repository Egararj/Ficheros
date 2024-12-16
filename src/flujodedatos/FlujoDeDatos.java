package flujodedatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FlujoDeDatos {
    public FlujoDeDatos(){
        /* System.out.println("flujo de datos");
        InputStreamReader isr=new InputStreamReader(System.in); //Lee datos
        BufferedReader br=new BufferedReader(isr); //Almacena datos
        String dato="";

        System.out.println("Introduce tu edad");
        int edad=0;
        try{
        dato=br.readLine();
        edad=Integer.parseInt(dato);
        }catch(IOException | NumberFormatException e){
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println(dato); */
        String dato="";
        System.out.println("Introduzca un dato");
        try {
            dato=Leer.dato();
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println(dato);

    }
}
