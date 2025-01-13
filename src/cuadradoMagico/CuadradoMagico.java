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
        int numMatrices;
        int tamMatriz;
        int matriz[][];
        f= new File("cuadradoMagico.txt");

        try{
            fr= new FileReader(f);
            br= new BufferedReader(fr);
            numMatrices = Integer.parseInt(br.readLine());
            for(int x=0; x<numMatrices; x++){
                tamMatriz = Integer.parseInt(br.readLine());
                matriz= new int [tamMatriz][];
                for(int y=0; y<tamMatriz; y++){
                    matriz[y]= filaMatriz(br.readLine().split(","));
                }
                escuadradomagico(matriz);
            }
                                    
        }catch (IOException e){
            e.printStackTrace();
        }
    }
                                    
    private void escuadradomagico(int[][] matriz) {
        
    }
                
    private int[] filaMatriz(String[] filaString) {
        int filaInt[]= new int [filaString.length];
        for(int x=0; x<filaString.length; x++){
            filaInt[x]= Integer.parseInt(filaString[x]);
        }
            
        return filaInt;
    }
}
