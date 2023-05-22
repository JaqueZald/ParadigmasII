package ComparadorPersona;

import java.util.Comparator;

public class ComparadorEdad implements Comparator<Persona>{
    @Override
    public int compare(Persona persona1, Persona persona2) {
        if(persona1.getEdad() == persona2.getEdad()){
            return 0;
        } else if (persona1.getEdad() > persona2.getEdad()) {
            return 1;
        }else {
            return -1;
        }
    }
}