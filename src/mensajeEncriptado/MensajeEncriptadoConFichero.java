package mensajeEncriptado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MensajeEncriptadoConFichero {
    public MensajeEncriptadoConFichero(){
        File f;
        FileReader fr;
        BufferedReader br;
        int[] mensajeEncriptado;
        f = new File("mensajeencriptado.txt");
        try{
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            mensajeEncriptado = arrayInt(br.readLine().split(","));
            int numPalabras = mensajeEncriptado[0];
            int siguientePalabra=1;
            int letrasPalabra;
            for(int x=0; x<numPalabras; x++){
                letrasPalabra=mensajeEncriptado[siguientePalabra]*2;
                int [] palabra = new int [letrasPalabra];
                for(int y=0; y<letrasPalabra; y++ ){
                    palabra[y] = mensajeEncriptado[siguientePalabra+y+1];
                }
                System.out.println(Arrays.toString(palabra));
                desencripta(palabra);
                siguientePalabra+=letrasPalabra+1;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
                        }
                    
                        private void desencripta(int[] palabraInt) {
                            String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
                            String[] alfabetoInverso= {"z","y","x","w","v","u","t","s","r","q","p","o","n","m","l","k","j","i","h","g","f","e","d","c","b","a"};
                            String palabra="";
                            int bucle = palabraInt.length;
                            int posicion=0;
                            for(int x=0; x<bucle; x++){
                                if (x%2 == 0){
                                    posicion = palabraInt[x];
                                }
                                else{
                                    if(palabraInt[x]%2 == 0){
                                        palabra+=alfabeto[posicion-1];
                                    }
                                    else{
                                        palabra+=alfabetoInverso[posicion-1];
                                    }
                                }
                            }
                            System.out.println(palabra);
                }
            
                        private int[] arrayInt(String[] arrayString) {
                int[] arrayInt = new int[arrayString.length];
                for(int x=0; x<arrayString.length; x++){
                    arrayInt[x] = Integer.parseInt(arrayString[x]);
                }
                return arrayInt;
            }
}
