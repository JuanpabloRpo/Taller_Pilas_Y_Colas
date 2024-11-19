import java.io.*;
import java.util.*;

public class Punto12 {

    public BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));

    public Punto12() throws IOException{

        System.out.println("Ingrese la dimension: ");
        int dim = Integer.parseInt(cp.readLine());
        ArrayList<ArrayList<Integer>> matriz = crearMatriz(dim);

        for (ArrayList<Integer> fila: matriz){
            System.out.println(fila);
        }
        System.out.println("Las posiciones donde hay un numero par son: "+posicionPar(matriz));
        System.out.println("Las posiciones donde hay un numero impar son: "+posicionImpar(matriz));

    }

    public ArrayList<ArrayList<Integer>> crearMatriz(int dimension) throws IOException {

        Random random = new Random();

        ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();

        for (int i = 0; i < dimension; i++) {

            ArrayList<Integer> paso = new ArrayList<>();
            for (int j = 0; j < dimension; j++) {

                paso.add(random.nextInt(211));

            }
            matriz.add(paso);
        }


        return matriz;
    }

    public Queue<String> posicionPar(ArrayList<ArrayList<Integer>> matriz){

        Queue<String> colaPar = new LinkedList<>();

        for (int i = 0; i < matriz.size(); i++) {

            for (int j = 0; j < matriz.getFirst().size(); j++) {
                if (matriz.get(i).get(j)%2==0){
                    colaPar.offer("("+i+","+j+")");
                }
            }
        }
        return colaPar;
    }

    public Queue<String> posicionImpar(ArrayList<ArrayList<Integer>> matriz){

        Queue<String> colaImpar = new LinkedList<>();

        for (int i = 0; i < matriz.size(); i++) {

            for (int j = 0; j < matriz.getFirst().size(); j++) {
                if (matriz.get(i).get(j)%2==1){
                    colaImpar.offer("("+i+","+j+")");
                }
            }
        }
        return colaImpar;
    }

}
