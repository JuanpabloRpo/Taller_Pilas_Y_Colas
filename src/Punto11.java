import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Punto11 {

    public Punto11() throws IOException {
        // Realizar el registro de los siniestros en el año
        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> pilaSiniestros = new Stack<>();
        Queue<String> colaSiniestros = new LinkedList<>();

        int numeroSiniestro = 1;
        boolean flag = true;
        while (flag){

            System.out.println("ingrese el nombre del siniestro ("+ numeroSiniestro +") o -1 para salir: ");
            String siniestro = cp.readLine();
            if (siniestro.equalsIgnoreCase("-1")){
                flag = false;
            }else {
                pilaSiniestros.push(siniestro);
            }
            numeroSiniestro++;

        }
        colaSiniestros = resultado(pilaSiniestros);
        System.out.println(colaSiniestros);
        System.out.println("El siniestro mayor es: "+mayorSiniestro(pilaSiniestros,colaSiniestros));

    }

    public Queue<String> resultado(Stack<String> pila){

        Queue<String> colaSiniestros = new LinkedList<>();

        pila = (Stack<String>) pila.clone();

        int dimension =  pila.size();

        for (int i = 0; i < dimension; i++) {
            String siniestro = pila.pop();

            if (!(colaSiniestros.contains(siniestro))){
                colaSiniestros.offer(siniestro);
            }

        }


        return colaSiniestros;
    }

    public String mayorSiniestro(Stack<String> pila, Queue<String> cola){

        int dimensionCola =  cola.size();
        int dimensionPila =  pila.size();
        int mayor = 0;
        String siniestroMayor = "";
        Stack<String> pila2;

        for (int i = 0; i < dimensionCola; i++) {

            pila2 = (Stack<String>) pila.clone();


            String siniestro = cola.poll();

            int count = 0;

            for (int j = 0; j < dimensionPila; j++) {

                if (siniestro.equalsIgnoreCase(pila2.pop())){
                    count++;
                }

            }

            if (count>mayor){
                mayor = count;
                siniestroMayor = siniestro;
            }

        }

        return siniestroMayor;

    }

}
