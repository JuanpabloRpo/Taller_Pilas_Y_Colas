import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SimpleTimeZone;

public class Punto10 {

    public Punto10() throws IOException {

        BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> cola = new LinkedList<>();

        System.out.println("Ingrese el valor de la hora");
        int valorHora = Integer.parseInt(cp.readLine());

        int numeroEmpleado = 1;
        boolean flag = true;
        while (flag){
            System.out.println("ingrese las horas del empleado ("+ numeroEmpleado +") o -1 para salir: ");
            int horaEmpleados = Integer.parseInt(cp.readLine());
            if (horaEmpleados<0 && horaEmpleados !=-1){
                System.out.println("El valor no puede ser negativo");
            }else if (horaEmpleados == -1){
                flag = false;
            }else {
                cola.offer(horaEmpleados);
            }
            numeroEmpleado++;
        }


        System.out.println(pagoCompleto(cola,valorHora));

    }
    public Queue<Integer> pagoCompleto(Queue<Integer> cola, int valorHora){

        int horasExtra;
        int horas;

        Queue<Integer> pagoReal = new LinkedList<>();
        int dimension = cola.size();
        for (int i = 0; i < dimension; i++) {

            horas = cola.poll();
            horasExtra = horas-40;
            int pago = 0;


            if (horasExtra>0){
                horas -= horasExtra;
                if (horasExtra>7){
                    pago += (horasExtra-7)*(valorHora*3);
                    horasExtra = horasExtra-(horasExtra-7);

                }

                pago += horasExtra * (valorHora*2);


                pago += horas*valorHora;


                pagoReal.offer(pago);

            }else {
                pagoReal.offer(horas*valorHora);
            }
        }

        return pagoReal;

    }

}
