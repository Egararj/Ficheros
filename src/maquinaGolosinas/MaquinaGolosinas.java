package maquinaGolosinas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MaquinaGolosinas {
    public MaquinaGolosinas(){
        System.out.println("Maquina golosinas");
        File f;
        FileReader fr;
        BufferedReader br;
        int tamañoMatriz;
        String [][] productos;
        double [][] precio;
        int [][] cantidad;
        int[][] productosVendido;
        f = new File("maquinagolosinas.txt");
        try{
        fr = new FileReader(f);
        br = new BufferedReader(fr);
        tamañoMatriz = Integer.parseInt(br.readLine());
        productos = new String [tamañoMatriz][tamañoMatriz];
        precio = new double [tamañoMatriz][tamañoMatriz];
        cantidad = new int [tamañoMatriz][tamañoMatriz];
        productosVendido = new int [tamañoMatriz][tamañoMatriz];
        for(int x=0; x<tamañoMatriz; x++){
            productos[x] = br.readLine().split(",");
        }
        for(int x=0; x<tamañoMatriz; x++){
            precio[x] = rellenaArrayDouble(br.readLine().split(","));
        }
        for(int x=0; x<tamañoMatriz; x++){
            cantidad[x] = rellenaArrayInt(br.readLine().split(","));
        }

        boolean apagar = true;
        boolean opcionIncorrecta = true;
        int opcion=0;
        Scanner sc = new Scanner(System.in);
        sc=null;
        do{
            System.out.println("===================");
            System.out.println("Menú");
            System.out.println("===================");
            System.out.println("1.Pedir golosina");
            System.out.println("2.Mostrar golosina");
            System.out.println("3.Rellenar golosina");
            System.out.println("4.Apagar maquina");
            System.out.println("===================");
            System.out.println("Introduzca una opción");
            do{
                try{
                    sc = new Scanner(System.in);
                    opcion = sc.nextInt();
                    if (opcion>=1 && opcion<=4){
                        opcionIncorrecta = false;
                }
                else{
                    opcionIncorrecta = true;
                    System.out.println("Intruduzca un valor correcto");
                }
                }catch(InputMismatchException e){
                    opcionIncorrecta = true;
                    System.out.println("Intruduzca un valor correcto");
                }
                sc = null;
            }while(opcionIncorrecta);

            switch (opcion) {
                case 1:
                    pedirGolosina(productos,productosVendido,cantidad, tamañoMatriz);
                break;
                
                case 2:
                    mostrarGolosinas(productos,precio,tamañoMatriz);
                break;
                    
                case 3:
                                        
                break;
                    
                case 4:
                    //Mostrar que productos se han vendido, la cantidad y el número de dinero gastado  
                break;
                                    
                default:
                    break;
                }
        }while(apagar);
                                             
        }catch (IOException e){
            e.printStackTrace();
        }
        
                                                }
        private void pedirGolosina(String[][] productos, int[][] productosVendido, int[][] cantidad, int tamañoMatriz) {
            Scanner sc = new Scanner(System.in);
            sc=null;
            String opcion;
            boolean incorrecto = false;
            
            do{
                System.out.println("Elija el código de un producto");
                sc = new Scanner(System.in);
                opcion = sc.nextLine();
                sc=null;
                if(opcion.length()<1 || opcion.length()>2){

                }
            }while(incorrecto);

            
            opcion = sc.nextLine();
            sc=null;
            
        }
                                            
                            private void mostrarGolosinas(String[][] productos, double[][] precio, int tamañoMatriz) {
                    for(int x=0; x<tamañoMatriz; x++){
                        for(int y=0; y<tamañoMatriz; y++){
                            System.out.println(productos[x][y]+". Código "+x+y+". Precio "+precio[x][y]);
                        }
                    }
                }
                    
                            private int[] rellenaArrayInt(String[] arrayString) {
                    int[] arrayInt= new int[arrayString.length];
                    for(int x=0; x<arrayString.length; x++){
                        arrayInt[x]= Integer.parseInt(arrayString[x]);
                    }
                    return arrayInt;
                }
            
                            private double[] rellenaArrayDouble(String[] arrayString) {
                    double[] arrayDouble= new double[arrayString.length];
                    for(int x=0; x<arrayString.length; x++){
                        arrayDouble[x]= Double.parseDouble(arrayString[x]);
                    }
                    return arrayDouble;
                }
}
