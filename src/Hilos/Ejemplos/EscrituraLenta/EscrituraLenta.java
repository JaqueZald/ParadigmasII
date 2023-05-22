package Hilos.Ejemplos.EscrituraLenta;

public class EscrituraLenta {
    public static void escribir(String palabra, int velocidad) {
        char[] caracteres = palabra.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            System.out.print(caracteres[i]);
            try {
                Thread.sleep(velocidad);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

