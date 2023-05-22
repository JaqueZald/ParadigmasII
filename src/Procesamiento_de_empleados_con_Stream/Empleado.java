package Procesamiento_de_empleados_con_Stream;
public class Empleado {
    private String primerNombre;
    private String apellidoPaterno;
    private double salario;
    private String departamento;

    public Empleado(String primerNombre, String apellidoPaterno, double salario,
                    String departamento) {
        this.primerNombre = primerNombre;
        this. apellidoPaterno = apellidoPaterno;
        this.salario = salario;
        this.departamento = departamento;
    }
    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return String. format ("%-12s %-12s %12.0f %12s",
                primerNombre, apellidoPaterno, salario, departamento);
    }

    // Devuelve primer nombre y apellido combinados del Empleado
    public String obtenerNombreCompleto() {
        return String.format("%s %s", primerNombre, apellidoPaterno);
    }
    public String formatoArchivo() {
        return this.primerNombre + "," + this.apellidoPaterno + "," + this.salario + "," + this.departamento;
    }

}

