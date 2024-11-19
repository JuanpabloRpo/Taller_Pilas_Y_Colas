import java.io.*;
import java.util.Stack;
import java.util.Random;


public class Punto3 {

    public Punto3()throws IOException {

        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();

        Stack<Integer> pila = new Stack<>();
        System.out.println("Ingrese la cantidad de elementos: ");
        int dimension = Integer.parseInt(cp.readLine());


        for (int i = 0; i < dimension; i++) {
            pila.push( random.nextInt(91) - 10);
        }

        Stack<Integer> newPila = remplazar(pila);
        System.out.println(pila);
        System.out.println(newPila);
        System.out.println(raizCuadrada(newPila));
    }

    public Stack<Integer> remplazar(Stack<Integer> p){

        p = (Stack<Integer>) p.clone();

        Stack<Integer> pilaConRemplazo = new Stack<>();



        int dimension = p.size();

        for (int i = 0; i < dimension; i++) {
            int numero = p.peek();
            if (numero<0){
                pilaConRemplazo.push(0);
            } else if (numero>7 && numero<21) {
                pilaConRemplazo.push(50);
            } else if (numero==61) {
                pilaConRemplazo.push(100);
            }else {
                pilaConRemplazo.push(numero);
            }
            p.pop();
        }

        for (int i = 0; i < dimension; i++) {
            p.push(pilaConRemplazo.pop());
        }

        return p;
    }

    public Stack<Double> raizCuadrada(Stack<Integer> p){
        p = (Stack<Integer>) p.clone();

        Stack<Double> pilaRaiz = new Stack<>();

        int dimension = p.size();

        for (int i = 0; i < dimension; i++) {

            pilaRaiz.push(Double.parseDouble(String.format("%.3f",Math.sqrt(p.pop())).replace(",",".")));

        }

        Stack<Double> newPilaRaiz = new Stack<>();

        for (int i = 0; i < dimension; i++) {
            newPilaRaiz.push(pilaRaiz.pop());
        }
        return newPilaRaiz;
    }

}
