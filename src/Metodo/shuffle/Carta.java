package Metodo.shuffle;

public class Carta {
    public  static enum Cara{
        as,Dos,Tres,Cuatro,cinco,sesis, siete, ocho ,nueve, diez, Joker, Reina, Rey
    };
    public static enum Palo{
        Treboles, Diamantes, Corazones, Espadas
    };
    private final Cara cara;
    private final Palo palo;
    public Carta (Cara cara, Palo palo){
        this.cara=cara;
        this.palo=palo;
    }
    public Cara getCara(){
        return cara;
    }
    public Palo getPalo(){
        return palo;
    }

    @Override
    public String toString() {
        return String.format("%s de %s",cara,palo);
    }
}

