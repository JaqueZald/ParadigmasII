import java.util.ArrayList;
import java.util.List;

public class calificaciones {
    public static void main(String[] args) {
        ArrayList<Double> listaCalificaciones = new ArrayList<>();
        listaCalificaciones.add(10.0);
        listaCalificaciones.add(9.5);
        listaCalificaciones.add(6.2);
        listaCalificaciones.add(8.1);
        listaCalificaciones.add(7.0);
        listaCalificaciones.add(5.5);
        listaCalificaciones.add(8.0);
        listaCalificaciones.add(9.5);
        listaCalificaciones.add(2.3);
        listaCalificaciones.add(6.2);

        //Imprimir calificaciones
        System.out.println("Lista calificaciones: ");
        for (Double calificacion : listaCalificaciones) {
            System.out.println(calificacion + "\t\t");
        }
        System.out.println();
        double[]calificaciones={10.0,9.2,8.3,7.4,6.5,5.6,4.7,3.8,2.9,1.0};
        List<Double> Calificaciones = new ArrayList<>();
        for(double calificacion:calificaciones){
            Calificaciones.add(calificacion);
        }
        System.out.println("Lista calificaciones: ");
        for (Double calificacion :Calificaciones) {
            System.out.println(calificacion + "\t\t");
        }
    }
}
