package Lenguajes;

import java.util.*;

public class Lenguajes {
    public static void main(String[] args) {
        System.out.println("Programa elaborado por Jaqueline Zaldivar Miranda.");
        Scanner scanner = new Scanner(System.in);
        List<String> listaLenguajes = new ArrayList<>();
        String[] arregloLenguajes = {"Java", "Python", "JavaScript", "C#", "PHP"};

        // Convertir el arreglo en una LinkedList
        LinkedList<String> listaLenguajesEnlazada = new LinkedList<>(Arrays.asList(arregloLenguajes));

        int opcion = 0;
        do {
            System.out.println("Lenguajes de Programación 2023");
            System.out.println("1. Añadir elemento");
            System.out.println("2. Añadir elemento al final");
            System.out.println("3. Añadir elemento al principio");
            System.out.println("4. Mostrar Lista de Lenguajes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el lenguaje a agregar: ");
                    scanner.nextLine(); // Limpia el buffer
                    String lenguaje = scanner.nextLine();
                    listaLenguajes.add(lenguaje);
                    listaLenguajesEnlazada.add(lenguaje);
                    break;
                case 2:
                    System.out.print("Ingrese el lenguaje a agregar al final: ");
                    scanner.nextLine();
                    String lenguajeFinal = scanner.nextLine();
                    listaLenguajes.add(listaLenguajes.size(), lenguajeFinal);
                    listaLenguajesEnlazada.addLast(lenguajeFinal);
                    break;
                case 3:
                    System.out.print("Ingrese el lenguaje a agregar al principio: ");
                    scanner.nextLine();
                    String lenguajePrincipio = scanner.nextLine();
                    listaLenguajes.add(0, lenguajePrincipio);
                    listaLenguajesEnlazada.addFirst(lenguajePrincipio);
                    break;
                case 4:
                    System.out.println("Lista de lenguajes (ArrayList):");
                    listaLenguajes.forEach(lenguajeActual -> System.out.println(lenguajeActual));

                    System.out.println("\nLista de lenguajes (LinkedList):");
                    listaLenguajesEnlazada.forEach(lenguajeActual -> System.out.println(lenguajeActual));
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            System.out.println();
        } while (opcion != 5);

        // Convertir LinkedList de vuelta a arreglo
        String[] arregloLenguajesEnlazado = listaLenguajesEnlazada.toArray(new String[0]);
        System.out.println("Lista de lenguajes en arreglo:");
        System.out.println(Arrays.toString(arregloLenguajesEnlazado));

        scanner.close();
    }
}