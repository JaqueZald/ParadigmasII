package LinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class UsandoToArray {
    public static void main(String[] args) {

        String[] colores = {"negro", "azul", "amarillo"};
        // Convierte un arreglo en un LinkedList
        LinkedList<String> listaColores = new LinkedList<>(Arrays.asList(colores));
        listaColores.addLast("rojo"); // Lo agrega como último elemento
        listaColores.add("rosa"); // lo agrega al final
        listaColores.add(3, "verde"); // lo agrega en el 3er índice
        listaColores.addFirst("cyan"); // lo agrega como primer elemento

// === Iterar sobre el LinkedList usando Java 8 forEach y lambda ===
        System.out.println("Valores del LinkedList listaColores: ");
        listaColores.forEach(color -> {
            System.out.print(color + " ");
        });
        // Convertir el LinkedList listaColores en un arreglo
        String[] ArregloColores = listaColores.toArray(new String[listaColores.size()]);
        System.out.println("n");
        System.out.println("Valores del arreglo ArregloColores:");
        for (String color : ArregloColores) {
            System.out.print(color + " ");
        }
    }
}
