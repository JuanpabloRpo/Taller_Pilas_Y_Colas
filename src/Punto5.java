import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Punto5 {

    public Punto5() throws IOException {

        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> lista = new ArrayList<>();

        System.out.println("Ingrese la cantidad de numeros que va haber en el vector: ");
        int cantidad = Integer.parseInt(cp.readLine());

        for (int i = 0; i < cantidad; i++) {
            System.out.println((i+1)+"- ingrese el valor: ");
            lista.add(Integer.parseInt(cp.readLine()));

        }


        System.out.println(lista);
        System.out.println(pasarAPila(lista));
    }

    public Stack<Integer> pasarAPila(ArrayList<Integer> lista){

        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < lista.size(); i++) {
            pila.push(factorial(lista.get(i)));
        }

        return pila;
    }

    public int factorial(int numero){

        int factorial=1;
        for (int i = numero; i > 0; i--) {
            factorial*=i;
        }
        return factorial;
    }
}
