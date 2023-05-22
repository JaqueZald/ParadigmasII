package Hilos.Ejemplos.Contador;

public class ContadorAtras  implements Runnable {
    private String nombre;

    public ContadorAtras(String nombrex) {
        this.nombre = nombrex;
    }

    @Override
    public void run() {
        for (int i = 1000; i >= 1; i--) {
            System.out.print("\t\t\t" + nombre + "" + i + "\n");
        }
        System.out.println();
    }
}

