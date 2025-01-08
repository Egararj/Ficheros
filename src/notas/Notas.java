package notas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Notas {
    public Notas(){
/* 
        FileReader fr;
        BufferedReader br;
        File notas;
        notas = new File("notas.txt"); //si fuese con una ruta más profunda en las carpetas sería del estilo: "src\\notas\\notas.txt" por ejemplo */
/* 
        String[] alumnos;
        String[] asignaturas;
        String[][] notasAlumnos;
        String lineafichero="";
        Character coma=',';
        int cont=0;
        try{
        fr = new FileReader(notas);
        br = new BufferedReader(fr);

        lineafichero=br.readLine();
        alumnos = lineafichero.split(",");
        System.out.println(Arrays.toString(alumnos));

        lineafichero=br.readLine();
        asignaturas = lineafichero.split(",");
        System.out.println(Arrays.toString(asignaturas));

        notasAlumnos=new String[asignaturas.length][alumnos.length];

        while((lineafichero=br.readLine()) !=null){
            notasAlumnos[cont] = lineafichero.split(",");
            cont++;
        }
        for(int x=0; x<notasAlumnos.length; x++){
            System.out.println(Arrays.toString(notasAlumnos[x]));
        }

     

        }catch (IOException e){
            e.printStackTrace();
        } */

        File f;
        FileReader fr;
        BufferedReader br;
        String linea="";
        String [] alumnos;
        String [] asignaturas;
        int [][] notasAlumno;
        f=new File("notas.txt");
        try{
            fr=new FileReader(f);
            br=new BufferedReader(fr);
            /* while((linea=br.readLine()) !=null){
            System.out.println(linea);
            } */
            linea=br.readLine();
            alumnos = linea.split(",");
            asignaturas= br.readLine().split(",");

            notasAlumno = new int [asignaturas.length][];
            for (int x=0; x<asignaturas.length; x++){
                notasAlumno[x]= lineaArrayInt(br.readLine().split(","));
            }
            System.out.println(Arrays.deepToString(notasAlumno));
            }catch(IOException e){
                e.printStackTrace();
        }
                        
                
        }
                
        private int[] lineaArrayInt(String[] arrayCadena) {
        int [] arrayInt=new int [arrayCadena.length];
        for(int x=0; x<arrayCadena.length; x++){
            arrayInt[x]= Integer.parseInt(arrayCadena[x]);
        }       
        return arrayInt;
        }
}
