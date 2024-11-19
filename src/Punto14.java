import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Punto14 {

    public Punto14() throws IOException {

        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese la cantidad de valores de la pila: ");
        int dimension = Integer.parseInt(cp.readLine());

        Stack<Integer> pila1 = llenarPila(dimension);
        Stack<Integer> pila2 = llenarPila(dimension);
        Stack<Integer> pila3 = llenarPila(dimension);

        System.out.println(pila1);
        System.out.println("-----------------------------------------");
        System.out.println(pila2);
        System.out.println("-----------------------------------------");
        System.out.println(pila3);
        System.out.println("-----------------------------------------");
        System.out.println(llenadoCola(pila1,pila2,pila3));
        System.out.println(pilaMayor(pila1,pila2,pila3));
        System.out.println(pilaMenor(pila1,pila2,pila3));

    }

    public Stack<Integer> llenarPila(int dimension){
        Random random = new Random();

        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < dimension; i++) {
            pila.push( random.nextInt(30));
        }
        return pila;
    }

    public Queue<Integer> llenadoCola(Stack<Integer> pila1,Stack<Integer> pila2,Stack<Integer> pila3){

        Queue<Integer> cola = new LinkedList<>();
        int dimensiones = pila1.size();

        pila1 = (Stack<Integer>) pila1.clone();
        pila2 = (Stack<Integer>) pila2.clone();
        pila3 = (Stack<Integer>) pila3.clone();

        for (int i = 0; i < dimensiones ; i++) {
            int numero = pila1.pop();

            if (!(cola.contains(numero))){
                cola.offer(numero);
            }

            numero = pila2.pop();
            if (!(cola.contains(numero))){
                cola.offer(numero);
            }

            numero = pila3.pop();
            if (!(cola.contains(numero))){
                cola.offer(numero);
            }

        }

        return cola;
    }

    public Queue<Integer> pilaMayor(Stack<Integer> pila1,Stack<Integer> pila2,Stack<Integer> pila3){

        Queue<Integer> cola = new LinkedList<>();

        Stack<Integer> auxPila1 = (Stack<Integer>) pila1.clone();
        Stack<Integer> auxPila2 = (Stack<Integer>) pila2.clone();
        Stack<Integer> auxPila3 = (Stack<Integer>) pila3.clone();

        int sumaPila1= 0;
        int sumaPila2= 0;
        int sumaPila3= 0;

        int dimension = pila1.size();

        for (int i = 0; i < dimension; i++) {
            sumaPila1+= auxPila1.pop();
            sumaPila2+= auxPila2.pop();
            sumaPila3+= auxPila3.pop();

        }
        System.out.println(sumaPila1);
        System.out.println(sumaPila2);
        System.out.println(sumaPila3);

        if (sumaPila1 > sumaPila2 && sumaPila1 > sumaPila3){
            System.out.println("la pila mayor es la pila 1");
            cola = ingresarPila(pila1);
        }else if(sumaPila2 > sumaPila1 && sumaPila2 > sumaPila3){
            System.out.println("la pila mayor es la pila 2");
            cola = ingresarPila(pila2);
        }else if (sumaPila3 > sumaPila2 && sumaPila3 > sumaPila1 ){
            System.out.println("la pila mayor es la pila 3");
            cola = ingresarPila(pila3);
        }else if (sumaPila1 == sumaPila2 && sumaPila2 > sumaPila3){
            System.out.println("las pilas mayores son las pilas 1 y 2");
            cola = ingresarPila(pila1);
            cola = ingresarPilas(pila2,cola);

        } else if (sumaPila2 == sumaPila3 && sumaPila3 > sumaPila1) {
            System.out.println("las pilas mayores son las pilas 2 y 3");
            cola = ingresarPila(pila2);
            cola = ingresarPilas(pila3,cola);
        } else if (sumaPila3 == sumaPila1 && sumaPila1 > sumaPila2) {
            System.out.println("las pilas mayores son las pilas 1 y 3");
            cola = ingresarPila(pila1);
            cola = ingresarPilas(pila3,cola);

        } else if (sumaPila3 == sumaPila1 && sumaPila1 == sumaPila2) {
            System.out.println("las pilas mayores son las pilas 1, 2 y 3");
            cola = ingresarPila(pila1);
            cola = ingresarPilas(pila2,cola);
            cola = ingresarPilas(pila3,cola);
        }else {
            System.out.println("no hay ninguna pila mayor");
        }

        return cola;
    }

    public Queue<Integer> pilaMenor(Stack<Integer> pila1,Stack<Integer> pila2,Stack<Integer> pila3){

        Queue<Integer> cola = new LinkedList<>();

        Stack<Integer> auxPila1 = (Stack<Integer>) pila1.clone();
        Stack<Integer> auxPila2 = (Stack<Integer>) pila2.clone();
        Stack<Integer> auxPila3 = (Stack<Integer>) pila3.clone();

        int sumaPila1= 0;
        int sumaPila2= 0;
        int sumaPila3= 0;

        int dimension = pila1.size();

        for (int i = 0; i < dimension; i++) {
            sumaPila1+= auxPila1.pop();
            sumaPila2+= auxPila2.pop();
            sumaPila3+= auxPila3.pop();

        }
        System.out.println(sumaPila1);
        System.out.println(sumaPila2);
        System.out.println(sumaPila3);

        if (sumaPila1 < sumaPila2 && sumaPila1 < sumaPila3){
            System.out.println("la pila menor es la pila 1");
            cola = ingresarPila(pila1);
        }else if(sumaPila2 < sumaPila1 && sumaPila2 < sumaPila3){
            System.out.println("la pila menore es la pila 2");
            cola = ingresarPila(pila2);
        }else if (sumaPila3 < sumaPila2 && sumaPila3 < sumaPila1 ){
            System.out.println("la pila menor es la pila 3");
            cola = ingresarPila(pila3);
        }else if (sumaPila1 == sumaPila2 && sumaPila2 < sumaPila3){
            System.out.println("las pilas menores son las pilas 1 y 2");
            cola = ingresarPila(pila1);
            cola = ingresarPilas(pila2,cola);

        } else if (sumaPila2 == sumaPila3 && sumaPila3 < sumaPila1) {
            System.out.println("las pilas menores son las pilas 2 y 3");
            cola = ingresarPila(pila2);
            cola = ingresarPilas(pila3,cola);
        } else if (sumaPila3 == sumaPila1 && sumaPila1 < sumaPila2) {
            System.out.println("las pilas menores son las pilas 1 y 3");
            cola = ingresarPila(pila1);
            cola = ingresarPilas(pila3,cola);

        } else if (sumaPila3 == sumaPila1 && sumaPila1 == sumaPila2) {
            System.out.println("las pilas menores son las pilas 1, 2 y 3");
            cola = ingresarPila(pila1);
            cola = ingresarPilas(pila2,cola);
            cola = ingresarPilas(pila3,cola);
        }else {
            System.out.println("no hay ninguna pila menor");
        }

        return cola;
    }

    public Queue<Integer> ingresarPila(Stack<Integer> pila){
        pila = (Stack<Integer>) pila.clone();
        pila = invertir(pila);
        Queue<Integer> cola = new LinkedList<>();
        int dimension = pila.size();
        for (int i = 0; i < dimension; i++) {
            cola.offer(pila.pop());
        }

        return cola;
    }

    public Queue<Integer> ingresarPilas(Stack<Integer> pila, Queue<Integer> cola){
        pila = (Stack<Integer>) pila.clone();
        pila = invertir(pila);
        int dimension = pila.size();
        for (int i = 0; i < dimension; i++) {
            cola.offer(pila.pop());
        }

        return cola;
    }

    public Stack<Integer> invertir(Stack<Integer> pila){

        Stack<Integer> newPila = new Stack<>();
        pila = (Stack<Integer>) pila.clone();
        int dimension = pila.size();
        for (int i = 0; i < dimension; i++) {
            newPila.push(pila.pop());
        }

        return newPila;
    }

}
