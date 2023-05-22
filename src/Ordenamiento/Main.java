package Ordenamiento;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[]palos={"Corazones","Diamantes","Bastos","Espadas"};

        //Crear y mostrar la lista que contieene el arreglo
        List<String>lista= Arrays.asList(palos);

        Collections.sort(lista);//Ordena la lista
        System.out.printf("Elementos Ordenados: %s%n",lista);

        Collections.sort(lista,Collections.reverseOrder());//Ordena la lista
        System.out.printf("Elementos Ordenados forma descendiente: %s%n",lista);

    }
}
