import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Punto9 {

    public Punto9() throws IOException {
        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        Stack<Integer> pila1 = new Stack<>();
        Stack<Integer> pila2 = new Stack<>();

        System.out.println("Ingrese la cantidad de elementos: ");
        int dimension = Integer.parseInt(cp.readLine());


        for (int i = 0; i < dimension; i++) {
            pila1.push( random.nextInt(100));
        }

        for (int i = 0; i < dimension; i++) {
            pila2.push( random.nextInt(100));
        }

        System.out.println(pila1);
        System.out.println(pila2);
        Queue<Queue<Integer>> colas = numerosParesEImpares(pila1,pila2);
        System.out.println("los numeros pares son: "+ colas.poll());
        System.out.println("los numeros impares son: "+colas.poll());
    }

    public Queue<Queue<Integer>>  numerosParesEImpares(Stack<Integer> pila1,Stack<Integer> pila2){

        Queue<Queue<Integer>> colas = new LinkedList<>();
        int dimension = pila1.size();

        pila1 = (Stack<Integer>) pila1.clone();
        pila2 = (Stack<Integer>) pila2.clone();

        Queue<Integer> pares = new LinkedList<>();
        Queue<Integer> impares = new LinkedList<>();

        for (int i=0; i<dimension ;i++){
            int numero1 = pila1.pop();
            int numero2 = pila2.pop();
            if (numero1%2==0){
                pares.offer(numero1);
            }else {
                impares.offer(numero1);
            }
            if (numero2%2==0){
                pares.offer(numero2);
            }else {
                impares.offer(numero2);
            }

        }
        colas.offer(pares);
        colas.offer(impares);
        return colas;
    }


}
