import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Stack;

public class Punto7 {

    public Punto7() throws IOException {
        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();

        Stack<Integer> pila = new Stack<>();
        System.out.println("Ingrese la cantidad de elementos: ");
        int dimension = Integer.parseInt(cp.readLine());


        for (int i = 0; i < dimension; i++) {
            pila.push( random.nextInt(211) - 20);
        }

        System.out.println(pila);
        Stack<Double> pilaCubo = new Stack<>();
        int positivos = 0;
        int contenidos = 0;
        int sumaInforme = 0;

        for (int i = 0; i < dimension; i++) {
            int numero = pila.pop();
            if (numero<0){
                pilaCubo.push(Math.pow(numero,3));

            }else {
                positivos++;
            }
            if (numero>19 && numero<81){
                contenidos++;
            }
            if (numero>79 && numero<201){
                sumaInforme+=numero;
            }

        }

        System.out.println(pilaCubo);
        System.out.println("La cantidad de numeros positivos es: "+positivos);
        System.out.println("La cantidad de numeros entre 20 y 80 es: "+contenidos);
        System.out.println("La suma de los numero entre 80 y 200 es: "+sumaInforme);


    }



}
