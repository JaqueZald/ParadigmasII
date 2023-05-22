package VideoJuegosStream;

public class Videojuego {
    private int indice;
    private String titulo;
    private String plataforma;
    private int ano;
    private String genero;
    private String publisher;
    private double Ventas_NA;
    private double Ventas_EU;
    private double Ventas_JP;
    private double ventas_Globales;

    public Videojuego(int indice, String titulo, String plataforma, int ano, String genero, String publisher, double ventas_NA, double ventas_EU, double ventas_JP, double ventas_Globales) {
        this.indice = indice;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.ano = ano;
        this.genero = genero;
        this.publisher = publisher;
        Ventas_NA = ventas_NA;
        Ventas_EU = ventas_EU;
        Ventas_JP = ventas_JP;
        this.ventas_Globales = ventas_Globales;
    }

    public int getIndice() {
        return indice;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int getAno() {
        return ano;

    }

    public String getGenero() {
        return genero;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getVentas_NA() {
        return Ventas_NA;
    }

    public double getVentas_EU() {
        return Ventas_EU;
    }

    public double getVentas_JP() {
        return Ventas_JP;
    }

    public double getVentas_Globales() {
        return ventas_Globales;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "indice=" + indice +
                ", titulo='" + titulo + '\'' +
                ", plataforma='" + plataforma + '\'' + ", año=" + ano +
                ", genero='" + genero + '\'' +
                ", publisher='" + publisher + '\'' + ", Ventas_NA=" + Ventas_NA +
                ", Ventas_EU=" + Ventas_EU + ", Ventas_JP=" + Ventas_JP +
                ", ventas_Globales=" + ventas_Globales + '}';
    }
}
