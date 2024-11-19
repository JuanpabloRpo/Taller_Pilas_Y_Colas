import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Punto15 {
    public Punto15() throws IOException {
        // Realizar el registro de los siniestros en el año
        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> pilaMaterial = new Stack<>();
        Stack<Integer> pilaPrecio = new Stack<>();
        Queue<String> colaMaterial = new LinkedList<>();
        int numeroMaterial = 1;


        while (true){

            System.out.println("ingrese el nombre del material ("+ numeroMaterial +") o -1 para salir: ");
            String material = cp.readLine();
            if (material.equalsIgnoreCase("-1")){
                break;
            }else {
                pilaMaterial.push(material);
            }
            System.out.println("ingrese la cantidad del material: ");
            int cantidad = Integer.parseInt(cp.readLine());
            pilaPrecio.push(cantidad);

            numeroMaterial++;
        }

        String material = mayorMaterial(pilaMaterial,resultado(pilaMaterial));

        System.out.println("El material mas ingresado es: "+material);
        System.out.println("con una cantidad de: "+cantidadMayor(pilaMaterial,pilaPrecio,material));
    }

    public Queue<String> resultado(Stack<String> pila){

        Queue<String> colaMaterial = new LinkedList<>();

        pila = (Stack<String>) pila.clone();

        int dimension =  pila.size();

        for (int i = 0; i < dimension; i++) {
            String material = pila.pop();

            if (!(colaMaterial.contains(material))){
                colaMaterial.offer(material);
            }

        }


        return colaMaterial;
    }

    public String mayorMaterial(Stack<String> pila, Queue<String> cola){

        int dimensionCola =  cola.size();
        int dimensionPila =  pila.size();
        int mayor = 0;
        String materialMayor = "";
        Stack<String> pila2;

        for (int i = 0; i < dimensionCola; i++) {

            pila2 = (Stack<String>) pila.clone();


            String material = cola.poll();

            int count = 0;

            for (int j = 0; j < dimensionPila; j++) {

                if (material.equalsIgnoreCase(pila2.pop())){
                    count++;
                }

            }

            if (count>mayor){
                mayor = count;
                materialMayor = material;
            }

        }

        return materialMayor;

    }

    public int cantidadMayor(Stack<String> pilaMaterial, Stack<Integer> pilaCantidad,String materialMayor){
        int cantidadTotal = 0;
        pilaMaterial = (Stack<String>) pilaMaterial.clone();
        pilaCantidad = (Stack<Integer>) pilaCantidad.clone();

        int dimension = pilaMaterial.size();
        for (int i = 0; i < dimension; i++) {

            String material = pilaMaterial.pop();
            int cantidad = pilaCantidad.pop();
            if (material.equalsIgnoreCase(materialMayor)){
                cantidadTotal+=cantidad;
            }
        }

        return cantidadTotal;
    }

}

