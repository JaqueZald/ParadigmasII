package ComparadorEmpleado;

import java.util.Comparator;

public class Empleado {
    private String nombre;
    private int idNumero;
    private String departamento;
    private String puesto;
    private double salario;

    public Empleado(String nombre, int idNumero, String departamento, String puesto, double salario) {
        this.nombre = nombre;
        this.idNumero = idNumero;
        this.departamento = departamento;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdNumero() {
        return idNumero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", idNumero=" + idNumero +
                ", departamento='" + departamento + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario +
                '}';
    }
}

class ComparadorSalario implements Comparator<Empleado> {
    public int compare(Empleado emp1, Empleado emp2) {
        return Double.compare(emp1.getSalario(), emp2.getSalario());
    }
}

class ComparadorDepartamento implements Comparator<Empleado> {
    public int compare(Empleado emp1, Empleado emp2) {
        return emp1.getDepartamento().compareTo(emp2.getDepartamento());
    }
}

class ComparadorDepartamentoPuesto implements Comparator<Empleado> {
    public int compare(Empleado emp1, Empleado emp2) {
        int resultado = emp1.getDepartamento().compareTo(emp2.getDepartamento());
        if (resultado == 0) {
            resultado = emp1.getPuesto().compareTo(emp2.getPuesto());
        }
        return resultado;
    }
}

class ComparadorDepartamentoSalario implements Comparator<Empleado> {
    public int compare(Empleado emp1, Empleado emp2) {
        int resultado = emp1.getDepartamento().compareTo(emp2.getDepartamento());
        if (resultado == 0) {
            resultado = Double.compare(emp1.getSalario(), emp2.getSalario());
        }
        return resultado;
    }
}

