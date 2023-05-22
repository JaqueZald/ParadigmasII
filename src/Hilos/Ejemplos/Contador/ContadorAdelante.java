package Hilos.Ejemplos.Contador;

public class ContadorAdelante implements Runnable {
    private String nombre;

    public ContadorAdelante(String nombrex) {
        this.nombre = nombrex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; ++i) {
            System.out.println("\t" + nombre + "" + i + "\n");
        }
        System.out.println();
    }
}
