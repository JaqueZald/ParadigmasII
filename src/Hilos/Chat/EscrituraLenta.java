package Hilos.Chat;

public class EscrituraLenta {
    public static void escribir(String palabra, int velociddad) {
        char[] caracteres = palabra.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            System.out.print(caracteres[i]);
            try {
                Thread.sleep(velociddad);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
