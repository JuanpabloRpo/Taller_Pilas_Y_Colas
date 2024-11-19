import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));

        boolean flagMenu = true;
        while (flagMenu){
            System.out.println("Ingrese el numero del ejercicio o 0 para salir");
            int opcion = Integer.parseInt(cp.readLine());
            switch (opcion){
                case 0:
                    flagMenu = false;
                    break;
                case 1:
                    Punto1 p1 = new Punto1();
                    break;
                case 2:
                    Punto2 p2= new Punto2();
                    break;
                case 3:
                    Punto3 p3 = new Punto3();
                    break;
                case 4:
                    Punto4 p4 = new Punto4();
                    break;
                case 5:
                    Punto5 p5 = new Punto5();
                    break;
                case 6:
                    Punto6 p6 =  new Punto6();
                    break;
                case 7:
                    Punto7 p7 = new Punto7();
                    break;
                case 8:
                    Punto8 p8=new Punto8();
                    break;
                case 9:
                    Punto9 p9 =  new Punto9();
                    break;
                case 10:
                    Punto10 p10 = new Punto10();
                    break;
                case 11:
                    Punto11 p11 = new Punto11();
                    break;
                case 12:
                    Punto12 p12 = new Punto12();
                    break;
                case 13:
                    Punto13 p13 = new Punto13();
                    break;
                case 14:
                    Punto14 p14 = new Punto14();
                    break;
                case 15:
                    Punto15 p15 = new Punto15();
                    break;
                case 16:
                    Punto16 p16 = new Punto16();
                    break;
                default:
                    System.out.println("Dato invalido");
            }
        }

    }
}