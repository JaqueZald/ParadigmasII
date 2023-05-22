package Hilos.Chat;

public class Preguntas {
    private String pregunta;
    private String respuesta;
    private int nPregunta;

    public Preguntas(String pregunta, String respuesta, int nPregunta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.nPregunta = nPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getnPregunta() {
        return nPregunta;
    }

    public void setnPregunta(int nPregunta) {
        this.nPregunta = nPregunta;
    }

    @Override
    public String toString() {
        return "Preguntas{" +
                "pregunta='" + pregunta + '\'' +
                ", respuesta='" + respuesta + '\'' +
                ", nPregunta='" + nPregunta + '\'' +
                '}';
    }
}
