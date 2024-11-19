import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Punto13 {

    public Punto13() throws IOException{

        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();


        System.out.println("Ingrese el numero de filas: ");
        int filas = Integer.parseInt(cp.readLine());
        System.out.println("Ingrese el numero de columnas: ");
        int columnas = Integer.parseInt(cp.readLine());
        ArrayList<ArrayList<Integer>> matriz = crearMatriz(filas,columnas);

        System.out.println("Ingrese la cantidad de valores de la pila: ");
        int dimension = Integer.parseInt(cp.readLine());

        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < dimension; i++) {
            pila.push( random.nextInt(30));
        }


        for (ArrayList<Integer> filasMatriz: matriz){
            System.out.println(filasMatriz);
        }
        System.out.println("----------------------------------");
        System.out.println(pila);
        System.out.println(operacion(matriz,pila));



    }
    public ArrayList<ArrayList<Integer>> crearMatriz(int filas,int columnas) throws IOException {

        Random random = new Random();

        ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();

        for (int i = 0; i < filas; i++) {

            ArrayList<Integer> paso = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {

                paso.add(random.nextInt(30));

            }
            matriz.add(paso);
        }


        return matriz;
    }

    public Queue<Integer> operacion(ArrayList<ArrayList<Integer>> matriz, Stack<Integer> pila){

        Queue<Integer> cola = new LinkedList<>();

        double promedio = 0;
        double promedioDespues = 0;
        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz.getFirst().size(); j++) {

                int registro = multiplicacion(pila,matriz.get(i).get(j));
                promedio+= registro;

                if (registro>1000){
                    registro = 1000;
                }

                if (registro<500 && registro>490){
                    registro = 500;
                }
                promedioDespues+= registro;

                cola.offer(registro);

            }
        }

        System.out.println("El promedio antes del cambio es: "+(promedio/ cola.size()));
        System.out.println("El promedio despues del cambio es: "+(promedioDespues/ cola.size()));
        return cola;
    }

    public int multiplicacion(Stack<Integer> pila, int registro){

        pila = (Stack<Integer>) pila.clone();

        int suma = 0;
        int dimension = pila.size();

        for (int k = 0; k < dimension; k++) {
            suma+=registro*pila.pop();
        }

        return suma;
    }
}
