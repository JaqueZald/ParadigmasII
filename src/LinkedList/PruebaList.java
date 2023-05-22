package LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class PruebaList {
    public static void main(String[] args) {
        // Agrega varios colores a listal
        LinkedList<String> listal = new LinkedList<>();
        listal.add("negro");
        listal.add("amarillo");
        listal.add("'verde");
        listal.add("azul");
        listal.add("violeta");
        listal.add("plateado");

        // Agrega varios colores a lista2
        LinkedList<String> lista2 = new LinkedList<>();
        lista2.add("dorado");
        lista2.add("blanco");
        lista2.add("cafe");
        lista2.add("azul");
        lista2.add("gris");
        lista2.add("plateado");

        //Concatenar las 2 listas
        listal.addAll(lista2);
//Libera los recursos de lista2
        lista2 = null;
        imprimirLista(listal);

// convierte cada elemento de listal a mayúsculas
        convertirCadenasAMayusculas(listal);
        imprimirLista(listal); // imprime los elementos de listal
        System.out.printf("%nEliminando elementos 4 a 6...");

        eliminarElementos(listal, 4, 7); // elimina los elementos 4 a 6 de la lista
        imprimirLista(listal); // imprime los elementos de listal
        imprimirListaInversa(listal); // imprime la lista en orden inverso
    }

    private static void imprimirLista(LinkedList<String> lista) {
        System.out.printf("%nlista:%n'");
        for (
                String color : lista) {
            System.out.printf("%s ", color);
        }
        System.out.println();
    }

    //localiza los objetos string y los convierte a mayúsculas
    private static void convertirCadenasAMayusculas(LinkedList<String> lista) {
        ListIterator<String> iterator = lista.listIterator();
        while (iterator.hasNext()) {
            String color = iterator.next(); //obtiene el elemento
            iterator.set(color.toUpperCase()); // Convierte a mayúsculas
        }
    }
    // obtener una sublista y utilizar el método clear para eliminar los elementos de la misma

    private static void eliminarElementos(List<String> lista, int inicio, int fin) {
        lista.subList(inicio, fin).clear(); // elimina los elementos
    }
    // imprime la lista inversa
    private static void imprimirListaInversa(List<String> lista) {
        ListIterator<String> iterador = lista.listIterator(lista.size());
        System.out.printf("%nLista inversa:%n");
// imprime la lista en orden inverso
        while (iterador.hasPrevious()) {
            System.out.printf("%s ", iterador.previous());

        }
    }
}