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
                    rellenarGolosinas(cantidad, productos,tamañoMatriz);     
                break;
                    
                case 4:
                    apagar(precio, productosVendido, productos, tamañoMatriz);
                    apagar = false;
                break;
                                    
                default:
                    break;
                }
        }while(apagar);
                                             
        }catch (IOException e){
            e.printStackTrace();
        }

        
    }

    private void apagar(double[][] precio, int[][] productosVendido, String[][] productos, int tamañoMatriz) {
        double totalVendido = 0;
        for(int f=0; f<productosVendido.length; f++){
            for(int c=0; c<productosVendido[f].length; c++){
                if (productosVendido[f][c]>0){
                    System.out.println(productosVendido[f][c]+" "+productos[f][c]+" "+precio[f][c]);
                    totalVendido += precio[f][c];
                }
            }

        }
        System.out.printf("Total vendido = %.2f",totalVendido);

    }

    private void rellenarGolosinas(int[][] cantidad, String[][] productos, int tamañoMatriz) {
        Scanner sc = new Scanner(System.in);
        sc=null;
        String opcion="";
        String contraseña = "2017";
        String contraseñaIntroducida = "";
        int opcion2 = 0;
        int cantidadDeRelleno = 0;
        int fila = 0, columna = 0;
        boolean rellenar = true;
        boolean incorrecto = false;



        System.out.println("Introduzca la contraseña");
        sc = new Scanner(System.in);
        contraseñaIntroducida = sc.nextLine();
        sc=null;

        if(!contraseña.equals(contraseñaIntroducida)){
            System.out.println("Contraseña incorrecta");
            return;
        }

        do{
            System.out.println("Introduzca la posición a rellenar");
            do
            try{
                incorrecto = false;
                sc = new Scanner(System.in);
                opcion = sc.nextLine();
                sc=null;
                if(opcion.length()<1 || opcion.length()>2) incorrecto = true;
                try{
                if(!Character.isDigit(opcion.charAt(0)) && !Character.isDigit(opcion.charAt(1))) incorrecto = true;
                }catch (IndexOutOfBoundsException e){
                    incorrecto = true;
                }
                fila = Integer.parseInt(opcion.substring(0,1));
                columna = Integer.parseInt(opcion.substring(1, 2));
                try{
                if(fila>=tamañoMatriz || columna>=tamañoMatriz) incorrecto = true;
                }catch(StringIndexOutOfBoundsException e){
                    incorrecto = true;
                }
                if (incorrecto) System.out.println("Código incorrecto");
            }catch(InputMismatchException e){
                System.out.println("Entrada erronea, vuelva a intentarlo");
                incorrecto = true;
            }while(incorrecto);
            sc=null;
            
            System.out.println("Introduzca la cantidad de relleno");
            do
            try{
            sc = new Scanner(System.in);
            cantidadDeRelleno = sc.nextInt();
            incorrecto = false;
            if(cantidadDeRelleno <0){
                System.out.println("No puedes reducir la cantidad");
                incorrecto = true;
            }
            }catch(InputMismatchException e){
                System.out.println("Entrada erronea, vuelva a intentarlo");
                incorrecto = true;
            }while(incorrecto);
            sc=null;

            cantidad[fila][columna] += cantidadDeRelleno;
            System.out.println("Se ha rellenado "+cantidadDeRelleno+" "+productos[fila][columna]);
            System.out.println("¿Seguir rellenando?");
            do{
                incorrecto = false;
                System.out.println("1.Si");
                System.out.println("2.No");
                try{
                sc = new Scanner(System.in);
                opcion2 = sc.nextInt();
                incorrecto = false;
                if (opcion2 == 1) rellenar = true;
                if (opcion2 == 2) rellenar = false;
                if (opcion2 != 1 && opcion2 != 2){
                    System.out.println("Opción incorrecta, vuelva a intentarlo");
                    incorrecto = true;
                }
                }catch(InputMismatchException e){
                    System.out.println("Entrada erronea, vuelva a intentarlo");
                    incorrecto = true;
                }
            }while(incorrecto);

            
        }while(rellenar);


    }
        private void pedirGolosina(String[][] productos, int[][] productosVendido, int[][] cantidad, int tamañoMatriz) {
            Scanner sc = new Scanner(System.in);
            sc=null;
            String opcion;
            boolean incorrecto = false;
            int fila, columna;
            
            do{
                System.out.println("Elija el código de un producto");
                incorrecto = false;
                sc = new Scanner(System.in);
                opcion = sc.nextLine();
                sc=null;
                if(opcion.length()<1 || opcion.length()>2) incorrecto = true;
                try{
                if(!Character.isDigit(opcion.charAt(0)) && !Character.isDigit(opcion.charAt(1))) incorrecto = true;
                }catch (IndexOutOfBoundsException e){
                    incorrecto = true;
                }
                fila = Integer.parseInt(opcion.substring(0,1));
                columna = Integer.parseInt(opcion.substring(1, 2));
                try{
                if(fila>=tamañoMatriz || columna>=tamañoMatriz) incorrecto = true;
                }catch(StringIndexOutOfBoundsException e){
                    incorrecto = true;
                }
                if (incorrecto) System.out.println("Código incorrecto");              
            }while(incorrecto);

            

            if(cantidad[fila][columna] == 0){
                System.out.println("Producto agotado");
                return;
            }
            cantidad[fila][columna]--;
            productosVendido[fila][columna]++;
            System.out.println("Has comprado 1 "+productos[fila][columna]);
            
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
