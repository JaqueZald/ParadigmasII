package Hilos;

public class HiloUnicoPrueba {
    public static void main(String[] args) {
        System.out.println("Inicio");
        Thread cuentaAdelante = new Thread(new ContadorAdelante("Contador++"));
        cuentaAdelante.start();
        System.out.println("Final");
}}
