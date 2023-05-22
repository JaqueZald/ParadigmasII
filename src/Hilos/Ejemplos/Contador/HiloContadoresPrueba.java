package Hilos.Ejemplos.Contador;


public class HiloContadoresPrueba {
    public static void main(String[] args) {
        System.out.println("Jaqueline Zaldivar Miranda");
        Thread cuentaAtras = new Thread(new ContadorAtras("Contador--"));
        cuentaAtras.start();
        Thread cuentaAdelante = new Thread(new ContadorAdelante("Contador++"));
        cuentaAdelante.start();
    }
}
