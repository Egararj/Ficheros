package cuadradoMagico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;

public class CuadradoMagico {
    public CuadradoMagico(){
        System.out.println("Cuadrado mágico");

        File f;
        FileReader fr;
        BufferedReader br;
        String linea="";
        f= new File("cuadradoMagico.txt");

        try{
            fr= new FileReader(f);
            br= new BufferedReader(fr);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
