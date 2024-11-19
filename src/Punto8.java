import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Punto8 {

    public BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));

    public Punto8() throws IOException{

        String lineas = "-------------------------------------------------------------";

        System.out.println("Ingrese la dimension: ");
        int dim = Integer.parseInt(cp.readLine());
        ArrayList<ArrayList<Integer>> matrizA = crearMatriz(dim);
        ArrayList<ArrayList<Integer>> matrizB = crearMatriz(dim);

        mostrarMatriz(matrizA);
        System.out.println(lineas);
        mostrarMatriz(matrizB);
        System.out.println(lineas);

        System.out.println(AporB(matrizA,matrizB));
        System.out.println(lineas);
        double promedioA = media(matrizA);
        double promedioB = media(matrizB);

        System.out.println(promedioA);
        System.out.println(lineas);
        System.out.println(promedioB);
        System.out.println(lineas);

        if ( promedioA> promedioB){
            System.out.println("El promedio mayor es A");
        }else {
            System.out.println("El promedio mayor es B");
        }
        System.out.println(lineas);
        System.out.println("El factorial de "+(int) promedioA+" es: "+factorial((int) promedioA));
        System.out.println(lineas);
        System.out.println("El factorial de "+(int) promedioB+" es: "+factorial((int) promedioB));
        System.out.println(lineas);
        mostrarMatriz(remplazar(matrizA));
        System.out.println(lineas);
        mostrarMatriz(remplazar(matrizB));

    }

    public ArrayList<ArrayList<Integer>> crearMatriz(int dimension) throws IOException {

        ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();

        for (int i = 0; i < dimension; i++) {

            ArrayList<Integer> paso = new ArrayList<>();
            for (int j = 0; j < dimension; j++) {

                System.out.println("Ingrese el valor que va en la posicion: "+"("+i+","+j+")");
                paso.add(Integer.parseInt(cp.readLine()));

            }
            matriz.add(paso);
        }


        return matriz;
    }

    public Queue<Integer> AporB(ArrayList<ArrayList<Integer>> matrizA,ArrayList<ArrayList<Integer>> matrizB){

        Queue<Integer> cola = new LinkedList<>();

        for (int i = 0; i < matrizA.size(); i++) {

            for (int j = 0; j < matrizB.getFirst().size(); j++) {

                cola.offer(multiplicacion(matrizA.get(i),columa(matrizB,j)));

            }

        }
        return cola;
    }

    public ArrayList<Integer> columa(ArrayList<ArrayList<Integer>> matriz, int numeroColumna){

        ArrayList<Integer> columna = new ArrayList<>();

        for (int i = 0; i < matriz.getFirst().size(); i++) {

            if (i != numeroColumna){
                continue;
            }

            for (int j = 0; j < matriz.size(); j++) {
                columna.add(matriz.get(j).get(i));
            }


        }

        return columna;

    }

    public int multiplicacion(ArrayList<Integer> fila , ArrayList<Integer> columna){

        int suma=0;

        for (int i = 0; i < fila.size(); i++) {
            suma+= fila.get(i) * columna.get(i);
        }

        return suma;

    }

    public Double media(ArrayList<ArrayList<Integer>> matriz){


        int suma = 0;
        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz.getFirst().size(); j++) {
                suma+=matriz.get(i).get(j);
            }
        }

        return (double) suma/ (matriz.size()*matriz.getFirst().size());

    }

    public long factorial(int numero){

        long factorial=1;
        for (int i = numero; i > 0; i--) {
            factorial*=i;
        }
        return factorial;
    }

    public ArrayList<ArrayList<Integer>> remplazar(ArrayList<ArrayList<Integer>> matriz){

        for (int i = 0; i < matriz.size(); i++) {

            for (int j = 0; j < matriz.getFirst().size(); j++) {

                if (matriz.get(i).get(j)<0){

                    matriz.get(i).set(j,0);

                }

            }

        }

        return matriz;
    }

    public void mostrarMatriz(ArrayList<ArrayList<Integer>> matriz){
        for(ArrayList<Integer> fila:matriz){
            System.out.println(fila);
        }

    }

}
