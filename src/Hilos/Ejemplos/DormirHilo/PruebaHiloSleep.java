package Hilos.Ejemplos.DormirHilo;

public class PruebaHiloSleep {
    public static void main(String[] args) {
        System.out.println("Jaqueline Zaldivar Miranda");
        Thread h1 = new Thread(new Runner());
        h1.start();
    }
}

