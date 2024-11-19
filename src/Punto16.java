import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Punto16 {

    public Punto16() throws IOException {

        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese la cantidad de valores de la pila: ");
        int dimension = Integer.parseInt(cp.readLine());

        Stack<Integer> pila = llenarPila(dimension);
        Queue<Integer> cola = llenarCola(pila);

        System.out.println(cola);

        boolean flagMenu = true;

        while (flagMenu) {
            System.out.println("Ingrese el numero del metodo o 0 para salir");
            int opcion = Integer.parseInt(cp.readLine());
            switch (opcion) {
                case 0:
                    flagMenu = false;
                    break;
                case 1:
                    System.out.println("Los factoriales son: "+factoriales(cola));
                    break;
                case 2:
                    System.out.println("La cola organizada es: "+organizar(cola));
                    break;
                case 3:
                    fibonacciElementos(cola);
                    break;
                case 4:
                    System.out.println(raizCuadrada(cola));
                    break;
                case 5:
                    System.out.println(elementoNegativo(cola));
                    break;
                default:
                    System.out.println("Dato no valido");
            }
        }

    }

    public Stack<Integer> llenarPila(int dimension){
        Random random = new Random();

        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < dimension; i++) {
            pila.push( random.nextInt(20)-5);
        }
        return pila;
    }

    public Queue<Integer> llenarCola(Stack<Integer> pila){

        pila = (Stack<Integer>) pila.clone();
        Queue<Integer> cola = new LinkedList<>();

        int dimension = pila.size();

        for (int i = 0; i < dimension; i++) {
            cola.offer(pila.pop());
        }

        return cola;

    }

    public Queue<Long> factoriales(Queue<Integer> cola){

        Queue<Integer> newFirstCola = new LinkedList<>();
        newFirstCola.addAll(cola);

        Queue<Long> newCola = new LinkedList<>();

        int dimension = cola.size();

        for (int i = 0; i < dimension; i++) {

            newCola.offer(factorial(newFirstCola.poll()));

        }

        return newCola;
    }

    public long factorial(int numero){

        long factorial=1;
        for (int i = numero; i > 0; i--) {
            factorial*=i;
        }
        return factorial;
    }

    public Queue<Integer> organizar(Queue<Integer> cola){

        ArrayList<Integer> numeros = new ArrayList<>();

        int dimension = cola.size();

        for (int i = 0; i < dimension; i++) {

            numeros.add(cola.poll());

        }
        numeros.sort(null);

        Stack<Integer> pila = new Stack<>();



        for (int i = 0; i < numeros.size(); i++) {

            pila.push(numeros.get(i));

        }

        int dim = cola.size();

        for (int i = 0; i < dimension; i++) {

            cola.offer(pila.pop());

        }

        return cola;
    }

    public void fibonacciElementos(Queue<Integer> cola){

        Queue<Integer> newCola = new LinkedList<>(cola);
        int dimension = newCola.size();


        for (int i = 0; i < dimension; i++) {
            int numero = newCola.poll();
            if (numero<0){
                continue;
            }
            System.out.println("Fibonacci para el numero "+numero);
            fibonacci(numero);

        }

    }

    public void fibonacci(int tope){

        int a;
        int b = 1;
        int c = 0;
        System.out.print(c+" ");
        for (int i = 0; i < tope; i++) {

            a = b;
            b = c;
            c = a + b;
            System.out.print(" "+c+" ");
        }
        System.out.println();


    }

    public Queue<Double> raizCuadrada(Queue<Integer> cola){

        Queue<Integer> newCola = new LinkedList<>(cola);
        Queue<Double> colaRaiz = new LinkedList<>();

        int dimension = newCola.size();

        for (int i = 0; i < dimension; i++) {
            int numero =  newCola.poll();
            if (numero<0){
                continue;
            }
            colaRaiz.offer(Math.sqrt(numero));

        }

        return colaRaiz;

    }

    public Queue<Integer> elementoNegativo(Queue<Integer> cola){

        Queue<Integer> newCola = new LinkedList<>(cola);
        Queue<Integer> colaMulti = new LinkedList<>();
        int dimension = newCola.size();

        for (int i = 0; i < dimension; i++) {

            int numero = newCola.poll();
            if(numero<0){
                numero*=Math.pow(numero,3);
            }
            colaMulti.offer(numero);
        }

        return colaMulti;
    }
}
