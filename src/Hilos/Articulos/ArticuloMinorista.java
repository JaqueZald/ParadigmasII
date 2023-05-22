package Hilos.Articulos;

public class ArticuloMinorista {
    private String descripcion;
    private int unidadesDisponobles;
    private double precio;

    public ArticuloMinorista(String descripcion, int unidadesDisponobles, double precio) {
        this.descripcion = descripcion;
        this.unidadesDisponobles = unidadesDisponobles;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUnidadesDisponobles() {
        return unidadesDisponobles;
    }

    public void setUnidadesDisponobles(int unidadesDisponobles) {
        this.unidadesDisponobles = unidadesDisponobles;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ArticuloMinorista{" +
                "descripcion='" + descripcion + '\'' +
                ", unidadesDisponobles=" + unidadesDisponobles +
                ", precio=$" + precio +
                '}';
    }
}
