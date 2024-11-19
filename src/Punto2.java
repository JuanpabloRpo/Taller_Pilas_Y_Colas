import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Punto2 {

    public Punto2() throws IOException {
        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese la cadena");
        invertir(cp.readLine());

    }

    public void invertir(String cadena){

        Stack<String> pila = new Stack<>();
        int caracteres = 0;
        for (char caracter : cadena.toCharArray()){
            pila.push(String.valueOf(caracter));
            caracteres++;
        }

         String newCadena = "";

        // .peek .push .pop
        int dimension = pila.size();
        for (int i = 0; i < dimension; i++) {
            newCadena+=pila.pop();
        }

        System.out.println("Su cadena era: "+cadena+"\nAhora es: "+newCadena+"\ncon: "+caracteres+" caracteres.");
    }
}
