package notas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Notas {
    public Notas(){

        FileReader fr;
        BufferedReader br;
        File notas;
        notas = new File("src\\notas\\notas.txt");

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
        }

    }
}
