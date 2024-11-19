import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Punto1 {

    public Punto1() throws IOException {

        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();

        System.out.println("Ingrese la dimension de la matriz");
        int dimension = Integer.parseInt(cp.readLine());

        for (int i = 0; i < dimension; i++) {

            ArrayList<Integer> paso = new ArrayList<>();
            for (int j = 0; j < dimension; j++) {

                System.out.println("Ingrese el valor que va en la posicion: "+"("+i+","+j+")");
                paso.add(Integer.parseInt(cp.readLine()));

            }
            matriz.add(paso);
        }

        boolean flagMenu = true;
        Queue<Integer> cola = sumaColumnas(matriz);
        while (flagMenu) {
            System.out.println("Ingrese el numero del metodo o 0 para salir");
            int opcion = Integer.parseInt(cp.readLine());
            switch (opcion) {
                case 0:
                    flagMenu = false;
                    break;
                case 1:
                    System.out.println("La suma de las filas es: ");
                    int fila = 1;
                    System.out.println("La matriz es: "+matriz);
                    for (Integer suma : sumaFilas(matriz)){
                        System.out.println("La suma de la fila "+fila+" es: "+suma);
                        fila++;
                    }

                    break;
                case 2:
                    System.out.println("La matriz es: "+matriz);
                    System.out.println("La suma de las columnas es: ");
                    System.out.println(cola);
                    break;
                case 3:
                    System.out.println("El factorial de: "+matriz.size()* matriz.getFirst().size()+" el cual pertenece a la dimencion de la matriz");
                    System.out.println(factorial(matriz));
                    break;
                case 4:
                    Queue<Integer> newCola = colaOrganizada(cola);
                    System.out.println("La cola organizada es: "+newCola);
                    break;
                default:
                    System.out.println("Dato no valido");
            }
        }


    }

    public Stack<Integer> sumaFilas(ArrayList<ArrayList<Integer>> matriz){

        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < matriz.size(); i++) {
            int suma = 0;
            for (int j = 0; j < matriz.getFirst().size(); j++) {
                suma+= matriz.get(i).get(j);
            }
            pila.push(suma);
        }

        return pila;
    }

    public Queue<Integer> sumaColumnas(ArrayList<ArrayList<Integer>> matriz){

        Queue<Integer> cola = new LinkedList<>();
        for (int i = 0; i < matriz.size(); i++) {
            int suma = 0;
            for (int j = 0; j < matriz.getFirst().size(); j++) {
                suma+= matriz.get(j).get(i);
            }
            cola.offer(suma);
        }


        return cola;
    }

    public int factorial(ArrayList<ArrayList<Integer>> matriz){
        int factorial=1;
        for (int i = 2; i <= matriz.size()* matriz.size(); i++) {
            factorial*=i;
        }

        return factorial;
    }

    public Queue<Integer> colaOrganizada(Queue<Integer> cola){
        ArrayList<Integer> lista = new ArrayList<>();
        Queue<Integer> newCola = new LinkedList<>();
        for (Integer numero: cola) {
            lista.add(numero);
        }

        lista.sort(null);
        lista.reversed();
        for (Integer numero : lista){
            newCola.offer(numero);
        }

        System.out.println(lista);

        return newCola;
    }

}
