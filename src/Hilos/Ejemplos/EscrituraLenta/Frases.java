package Hilos.Ejemplos.EscrituraLenta;

public class Frases {
    public static void main(String[] args) {
        String frase1 = "Preguntarse cuando los ordenadores podrán pensar es como " + "\n" + "preguntarse cuando los submarinos podrán nadar.";
        String autorFrasel1 = "-- Edsger W. Dijkstra";
        String frase2 = "No importa lo estupendamente que haya ido la deno en" + "\n" + "Los ensayos, cuando lo haces frente a tu audiencia la " + "\n" +
                "probabilidad de que sea una presentación existosa es " + "\n" +
                "inversamente proporcional al numero de personas mirando, " + "\n" + "elevado a la cantidad de dinero que hay en juego " + "\n" + "--Mark Gibbs";
        EscrituraLenta.escribir(frase1, 20);
        EscrituraLenta.escribir(autorFrasel1, 400);
        System.out.println();
        EscrituraLenta.escribir("-------------", 200);
        EscrituraLenta.escribir("", 2000);
        System.out.println("Jaqueline Zaldivar Miranda");
        EscrituraLenta.escribir(frase2, 10);
    }
}

