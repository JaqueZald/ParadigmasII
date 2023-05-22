package MetodosMatematicos;

import java.util.Scanner;

public class Ejer1 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            // Pedimos los coeficientes a, b y c
            System.out.print("Ingrese el valor de a: ");
            double a = input.nextDouble();
            System.out.print("Ingrese el valor de b: ");
            double b = input.nextDouble();
            System.out.print("Ingrese el valor de c: ");
            double c = input.nextDouble();

            // Calculamos el discriminante
            double discriminante = Math.pow(b, 2) - 4 * a * c;

            // Verificamos si la ecuación tiene solución real
            if (discriminante >= 0) {
                // Calculamos las raíces reales
                double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);

                // Mostramos las raíces
                System.out.println("Las raíces son: ");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else {
                // Calculamos las raíces complejas
                double real = -b / (2 * a);
                double imaginario = Math.sqrt(-discriminante) / (2 * a);

                // Mostramos las raíces complejas
                System.out.println("Las raíces son complejas: ");
                System.out.println("x1 = " + real + " + " + imaginario + "i");
                System.out.println("x2 = " + real + " - " + imaginario + "i");
            }
        }
    }
