package Programacion_Declarativa;

import java.util.stream.IntStream;

public class MostrarArregloImperativo {
    public static void main(String[] args) {
        int[]valores={3,10,6,1,4,8,2,5,9,7};
        for(int i=0;i<valores.length;i++){
            System.out.printf("%d",valores[i]);
        }
        System.out.println();
        //Prog declarativa
        IntStream.of(valores).forEach(valor-> System.out.printf("%d ",valor));
    }
}
