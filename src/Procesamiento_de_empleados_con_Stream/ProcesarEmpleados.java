package Procesamiento_de_empleados_con_Stream;
import java.util.*;


public class ProcesarEmpleados {
    public static void main(String[] args) {
        Archivo archivox = new Archivo("C:\\Users\\ADMIN\\IdeaProjects\\ParadigmasII\\src\\Procesamiento_de_empleados_con_Stream\\ListaEmpleados.txt");
        List<Empleado> ListaEmpleados = archivox.leerDeArchivo();
        System.out.println("Jaqueline Zaldivar Miranda");
        System.out.println("Lista completa de empleados");

        imprimirEncabezado() ;
        ListaEmpleados.stream().forEach(System.out::println) ;
        imprimirRenglon();

        //Aqui se muestran los empleados que tienen apellidos Vazquez
        System.out.println("Empleados que tienen el apellido Vázquez:");
        imprimirEncabezado();
        ListaEmpleados.stream().filter(empleado -> empleado.getApellidoPaterno().equals("Vázquez")).forEach(System.out::println);
        imprimirRenglon();
        //La linea de instruccion de aqui es la suma de todos los salarios  de todos los empleados
        //utilizamos el metodo sum
        double sumaSalarios = ListaEmpleados.stream().mapToDouble(Empleado::getSalario).sum();
        System.out.println("La suma de los salarios es: " + sumaSalarios);
        // En esta linea de instruccion se suman los salarios mayores o iguales a $10,000
        double sumaSalariosMayores = ListaEmpleados.stream().filter(empleado -> empleado.getSalario() >= 10000).mapToDouble(Empleado::getSalario).reduce(0, Double::sum);
        System.out.println("La suma de los salarios mayores o iguales a 10000 es: " + sumaSalariosMayores);
        // Aqui se muestran los nombres y apellidos de los empleados que trabajan en el departamento de Marketing
        System.out.println("Empleados que trabajan en el departamento de Marketing:");
        imprimirEncabezado();
        ListaEmpleados.stream().filter(empleado -> empleado.getDepartamento().equals("Marketing")).map(empleado -> empleado.getPrimerNombre() + " " + empleado.getApellidoPaterno()).forEach(System.out::println);
        imprimirRenglon();
        // Aqui se le da al prpograma la instruccion de mostrar el salario más alto del departamento TI
        double maxSalarioTI = ListaEmpleados.stream().filter(empleado -> empleado.getDepartamento().equals("TI")).mapToDouble(empleado -> empleado.getSalario()).max().getAsDouble();

        System.out.printf("Salario maximo de TI: %.2f", maxSalarioTI);
        imprimirRenglon();
        // Se cuentan los empleados que trabajan en el departamento de Ventas
        long numEmpleadosVentas = ListaEmpleados.stream().filter(empleado -> empleado.getDepartamento().equals("Ventas")).count();
        System.out.println("Empleados que trabajan en el departamento de Ventas: "+ numEmpleadosVentas);
    }
    public static void imprimirRenglon() {
        System.out.println();
        System.out.println("----------------------------------------------------");
    }

    public static void imprimirEncabezado() {
        System.out.printf("%12s %12s %12s %12s%n", "Nombre", "Apellidos",
                "Salario","Departamento") ;
        System.out.println("------------------------------------------------------");
    }
}