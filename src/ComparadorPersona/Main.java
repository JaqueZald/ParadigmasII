package ComparadorPersona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Pedro", "Picapiedra", 40));
        listaPersonas.add(new Persona("Pablo", "Mármol", 30));
        listaPersonas.add(new Persona("Vilma", "De Picapiedra", 35));
        listaPersonas.add(new Persona("Betty", "Mármol", 25));
        listaPersonas.add(new Persona("Tony", "Stark", 56));
        // imprime los elementos del objeto list
        System.out.println("Elementos desordenados: ");
        listaPersonas.forEach(persona -> System.out.println(persona));
        System.out.println();
        // Ordenamos por edad
        Collections.sort(listaPersonas, new ComparadorEdad());
        System.out.println("Elementos de la lista ordenados por edad:");
        listaPersonas.forEach(persona -> System.out.println(persona));
        System.out.println();

    }
}
