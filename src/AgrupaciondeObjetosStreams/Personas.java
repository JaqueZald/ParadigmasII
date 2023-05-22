package AgrupaciondeObjetosStreams;

public class Personas {
    private String nombre;
    private String fecha;
    private String edad;
    private String expedicion;
    private String nacionalidad;
    private String causamuerte;
    private String ubicacion;

    public Personas(String nombre, String fecha, String edad, String expedicion, String nacionalidad, String causamuerte, String ubicacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.edad = edad;
        this.expedicion = expedicion;
        this.nacionalidad = nacionalidad;
        this.causamuerte = causamuerte;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getExpedicion() {
        return expedicion;
    }

    public void setExpedicion(String expedicion) {
        this.expedicion = expedicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCausamuerte() {
        return causamuerte;
    }

    public void setCausamuerte(String causamuerte) {
        this.causamuerte = causamuerte;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return String.format("%-25s\t|| %20s\t||  %5s\t || %60s\t||  %20s\t||  %20s\t || %20s\t|| \n",
                nombre, fecha, edad, expedicion, nacionalidad, causamuerte, ubicacion);
    }

    // Devuelve primer nombre y apellido combinados del Empleado
    public String obtenerDatos() {
        return String.format("%s %s", nacionalidad, causamuerte, ubicacion);

    }
}

