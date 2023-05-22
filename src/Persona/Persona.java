package Persona;

public class Persona {
    private int id, anioNacimiento, salario;
    private String nombre, apellido;
    private double coeficiente;

    public Persona(int id, String nombre, String apellido,
                   int anioNaciminetoto, int salario, double coeficiente) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioNacimiento = anioNaciminetoto;
        this.salario = salario;
        this.coeficiente = coeficiente;
    }

    public int getId() {
        return id;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public int getSalario() {
        return salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getCoeficiente() {
        return coeficiente;
    }
}