package Metodo.shuffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MazodeCartas {
    private List<Carta> listaCartas;
    public MazodeCartas() {
        Carta[] mazo = new Carta[52];
        int cuenta = 0;
        for (Carta.Palo palo : Carta.Palo.values()) {
            for (Carta.Cara cara : Carta.Cara.values()) {
                mazo[cuenta] = new Carta(cara, palo);
                ++cuenta;
            }
        }
        listaCartas = Arrays.asList(mazo);
        Collections.shuffle(listaCartas);
    }

    public void imprimirCartas(){
        for (int i = 0; i< listaCartas.size(); i++){
            System.out.printf("%-23s%s", listaCartas.get(i),
                    ((i+1)% 6==0) ? "\n":"");
        }
    }
    public List<Carta> getListaCartas(){
        return listaCartas;
    }
    public  static void main (String[] args){
        MazodeCartas cartas = new MazodeCartas();
        cartas.imprimirCartas();
    }
    public List<Carta> getCartasAleatorias(int cantidad){
        Collections.shuffle(listaCartas);
        return listaCartas.subList(0, cantidad);
    }
}