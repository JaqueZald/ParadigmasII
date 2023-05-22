package ComparadorEmpleado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmpleadoPrueba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Programa hecho por Jaqueline Zaldivar Miranda ");
        ArrayList<Empleado> empleados = new ArrayList<>();
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Ordenar por salario");
            System.out.println("3. Ordenar por departamento");
            System.out.println("4. Ordenar por departamento y puesto");
            System.out.println("5. Ordenar por departamento y salario");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // consume el salto de línea después de la opción
            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Número de identificación: ");
                    int idNumero = scanner.nextInt();
                    scanner.nextLine(); // consume el salto de línea después
                    System.out.print("Departamento: ");
                    String departamento = scanner.nextLine();
                    System.out.print("Puesto: ");
                    String puesto = scanner.nextLine();
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); // consume el salto de línea después del salario
                    Empleado empleado = new Empleado(nombre, idNumero, departamento, puesto, salario);
                    empleados.add(empleado);
                    System.out.println("Empleado agregado.");
                    break;
                case 2:
                    Collections.sort(empleados, new ComparadorSalario());
                    mostrarEmpleados(empleados);
                    break;
                case 3:
                    Collections.sort(empleados, new ComparadorDepartamento());
                    mostrarEmpleados(empleados);
                    break;
                case 4:
                    Collections.sort(empleados, new ComparadorDepartamentoPuesto());
                    mostrarEmpleados(empleados);
                    break;
                case 5:
                    Collections.sort(empleados, new ComparadorDepartamentoSalario());
                    mostrarEmpleados(empleados);
                    break;
                case 6:
                    System.out.println("Adiós.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    public static void mostrarEmpleados(ArrayList<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
}
