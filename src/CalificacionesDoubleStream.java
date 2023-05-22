import java.util.stream.DoubleStream;

public class CalificacionesDoubleStream {
    public static void main(String[] args) {
        // Dado el siguiente arreglo de calificaciones
        double[] calificaciones = {3.2, 10.0, 6.7, 5.1, 4.6, 7.8, 8.2, 7.5, 5.8, 8.7};

        // Imprimir las calificaciones originales
        System.out.println("Lista de calificaciones");
        DoubleStream.of(calificaciones)
                .forEach(calificacion -> System.out.printf("%.1f ", calificacion));
        imprimirRenglon();
        // Promedio de aquellos que pasaron
        //  10.0, 6.7, 7.8, 8.2, 7.5, 8.7 = 48.9 / 6 = 8.2
        System.out.printf("Promedio de aquellos que pasaron: %.1f",
                DoubleStream.of(calificaciones)
                        .filter(calificacion -> calificacion >= 6.0)
                        .average().getAsDouble()
        );
        imprimirRenglon();

        // Número de alumnos reprobados
        System.out.printf("Número de alumnos no aprobados: %d",
                DoubleStream.of(calificaciones)
                        .filter(calificacion -> calificacion < 6.0)
                        .count()
        );
        imprimirRenglon();
        // Calificación máxima de los que están entre 6.0 y 8.0
        System.out.printf("Calificación máxima de los que están entre 6.0 y 8.0: %.1f",
                DoubleStream.of(calificaciones)
                        .filter(calif -> calif >= 6.0 && calif <= 8.0)
                        .max().getAsDouble()
        );
        imprimirRenglon();
        // Calificación mínima de los que están entre 4.0 y 6.0
        System.out.printf("Calificación mínima de los que están entre 4.0 y 6.0: %.1f",
                DoubleStream.of(calificaciones)
                        .filter(calif -> calif >= 4.0 && calif <= 6.0)
                        .min().getAsDouble()
        );
        imprimirRenglon();
        // Sumar un punto a todos y mostrarlos
        System.out.println("Sumar un punto a todos y mostrarlos:");
        DoubleStream.of(calificaciones)
                .map(calif -> calif + 1.0)
                .forEach(calif -> System.out.printf("%.1f ", calif));
        imprimirRenglon();
    }

    public static void imprimirRenglon() {
        System.out.println();
        System.out.println("-------------");
    }

}


