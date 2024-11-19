import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

public class Punto6 {

    public BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));

    public Punto6() throws IOException {


        ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();

        System.out.println("Ingrese la cantidad de filas de la matriz: ");
        int filas = Integer.parseInt(cp.readLine());
        System.out.println("Ingrese la cantidad de columnas de la matriz");
        int columnas = Integer.parseInt(cp.readLine());

        for (int i = 0; i < filas; i++) {

            ArrayList<Integer> paso = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {

                System.out.println("Ingrese el valor que va en la posicion: "+"("+i+","+j+")");
                paso.add(Integer.parseInt(cp.readLine()));

            }
            matriz.add(paso);
        }
        String lineas = "---------------------------------------------------";
        for (ArrayList<Integer> fila : matriz){
            System.out.println(fila);
        }

        System.out.println(lineas);
        System.out.println(promedioFilas(matriz));

        System.out.println(lineas);
        System.out.println(raizColumnas(matriz));

        System.out.println(lineas);
        System.out.println(multiplicacionMatriz(matriz));
    }

    public Stack<Double>  promedioFilas(ArrayList<ArrayList<Integer>> matriz){

        Stack<Double> pila = new Stack<>();

        int suma;
        for (int i = 0; i < matriz.size(); i++) {

            suma = 0;

            for (int j = 0; j < matriz.getFirst().size(); j++) {

                suma+=matriz.get(i).get(j);

            }

            pila.push((double) suma/matriz.getFirst().size());
        }

        return pila;
    }

    public Stack<Double>  raizColumnas(ArrayList<ArrayList<Integer>> matriz){

        Stack<Double> pila = new Stack<>();

        int suma;
        for (int i = 0; i < matriz.getFirst().size(); i++) {

            suma = 0;

            for (int j = 0; j < matriz.size(); j++) {

                suma+=matriz.get(j).get(i);

            }

            pila.push(Math.sqrt(suma));
        }

        return pila;
    }

    public Stack<Integer> multiplicacionMatriz(ArrayList<ArrayList<Integer>> matriz) throws IOException{

        Stack<Integer> pila = new Stack<>();
        ArrayList<ArrayList<Integer>> matrizb = new ArrayList<>();

        System.out.println("Ingrese la cantidad de filas de la matriz b: ");
        int filas = Integer.parseInt(cp.readLine());
        if (!(filas==matriz.getFirst().size())){
            System.out.println("no se puede hacer la multiplicacion de matrices: ");
            return null;
        }

        System.out.println("Ingrese la cantidad de columnas de la matriz b: ");
        int columnas = Integer.parseInt(cp.readLine());

        for (int i = 0; i < filas; i++) {

            ArrayList<Integer> paso = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {

                System.out.println("Ingrese el valor que va en la posicion: "+"("+i+","+j+")");
                paso.add(Integer.parseInt(cp.readLine()));

            }
            matrizb.add(paso);
        }

        // multiplicacion de matrices de forma de algebra lineal

        for (int i = 0; i < matriz.size(); i++) {

            for (int j = 0; j < matrizb.getFirst().size(); j++) {

                pila.push(multiplicacion(matriz.get(i),columa(matrizb,j)));

            }

        }

        if (!(filas==matriz.getFirst().size())){
            System.out.println("no se puede hacer la multiplicacion de matrices");
            return null;
        }
        Stack<Integer> pila2 = new Stack<>();

        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz.getFirst().size(); j++) {

                pila2.push(matriz.get(i).get(j)*matrizb.get(i).get(j));

            }
        }

        return pila;
    }
    
    public ArrayList<Integer> columa(ArrayList<ArrayList<Integer>> matriz, int numeroColumna){

        ArrayList<Integer> columna = new ArrayList<>();

        for (int i = 0; i < matriz.getFirst().size(); i++) {

            if (i != numeroColumna){
                continue;
            }

            for (int j = 0; j < matriz.size(); j++) {
                columna.add(matriz.get(j).get(i));
            }


        }

        return columna;
        
    }

    public int multiplicacion(ArrayList<Integer> fila , ArrayList<Integer> columna){

        int suma=0;

        for (int i = 0; i < fila.size(); i++) {
            suma+= fila.get(i) * columna.get(i);
        }

        return suma;

    }

}
