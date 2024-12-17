package estudioFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ficheros {
    
    public Ficheros(){
        File fichero;
        fichero=new File("C:\\Users\\Usuario\\Desktop\\fichero.txt");
        System.out.println("Nombre del fichero: "+fichero.getName());
        System.out.println("Ruta del fichero: "+fichero.getPath());
        System.out.println("Ruta absoulta del fichero: "+fichero.getAbsolutePath());
        System.out.println("Tamaño del fichero: "+fichero.length());

        if(fichero.exists())
            System.out.println("El fichero existe");

        File f;
        f=new File("prueba.txt");
        try{
            if(!f.exists()){
                f.createNewFile();
                System.out.println("Fichero creado");
            }
            else{
                System.out.println("Fichero no creado");
            }
        }catch(Exception e){
            System.out.println("Error: "+e);
        }


        FileReader fr;
        BufferedReader br;
        String nombre="";
        try{
            fr=new FileReader(f);
            br=new BufferedReader(fr);
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            System.out.println(br.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
