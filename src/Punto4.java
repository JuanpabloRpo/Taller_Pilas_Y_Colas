import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Random;
public class Punto4 {

    public BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));

    public Punto4() throws IOException {


        Random random = new Random();

        Stack<String> pilaCaracter = new Stack<>();

        String cadena = "";

        while (!cadena.equals("-1")){

            System.out.println("ingrese los caracteres o numeros que tiene la pila, o -1 para dejar de ingresar");
            cadena = cp.readLine();


            if (cadena.equals("-1") && pilaCaracter.isEmpty()){
                cadena ="";

            }else if (!cadena.equals("-1")){
                pilaCaracter.push(cadena);
            }


        }
        System.out.println(pilaCaracter);
        System.out.println("Ingrese el caracter a buscar: ");
        buscar(pilaCaracter,cp.readLine());
    }

    public void buscar(Stack<String> pila,String abuscar) throws IOException{


        pila = (Stack<String>) pila.clone();
        Stack<String> operaciones = (Stack<String>) pila.clone();
        int dimension = pila.size();

        boolean isHere = false;
        for (int i = 0; i < dimension; i++) {
            String caracter = operaciones.pop();
            if (caracter.equals(abuscar)){
                System.out.println("el caracter "+caracter+" esta en el indice "+i);
                isHere = true;
                break;
            }

        }

        if (!isHere){
            System.out.println("No se encontro el caracter, ingrese otro caracter: ");
            buscar(pila, cp.readLine());
        }

    }
}
