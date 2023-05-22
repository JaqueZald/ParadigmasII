package Venta;

import java.util.stream.DoubleStream;

public class Venta {
    public static void main(String[] args) {
         double[] ventas={37,1978,6377,5211,2435,1536,9634};

        System.out.printf("Ventas que superan los $1000: %d ",
                DoubleStream.of(ventas)
                        .filter(vent->vent>1000).count()

        );
        imprimirRenglon();

        System.out.printf("Venta maxima entre 1000 y 2000: %.1f",
                DoubleStream.of(ventas)
                        .filter(venta->venta >=1000 && venta<=2000)
                        .max().getAsDouble()
        );
        imprimirRenglon();

        System.out.printf("Venta minima entre 0 y 5000: %.1f",
                DoubleStream.of(ventas)
                        .filter(venta->venta >=0 && venta<=5000)
                        .min().getAsDouble()
        );
        imprimirRenglon();

        System.out.printf("Promedio de ventas de la semana: %.1f",
                DoubleStream.of(ventas)
                .average().getAsDouble()
        );
        imprimirRenglon();

        System.out.println("Total de Ventas: ");
        double totalVentas=DoubleStream.of(ventas)
                .sum();
        System.out.println(totalVentas);
    imprimirRenglon();
    }

    public static void imprimirRenglon() {
        System.out.println();
        System.out.println("------------------------");
    }
}
