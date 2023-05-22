package Procesamiento_de_empleados_con_Stream;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Archivo {
    private String nombreArchivo;
    public Archivo(String nombreA) {
        this.nombreArchivo = nombreA;
    }
    public ArrayList<Empleado> leerDeArchivo() {
        ArrayList<Empleado> ListaEmpleados = new ArrayList<>();
        try {
            File archivoLectura = new File(nombreArchivo);
            Scanner leerArchivo = new Scanner(archivoLectura);

            while (leerArchivo.hasNextLine()) {
                String linea = leerArchivo.nextLine();
                String[] datos = linea.split(",");

                String primerNombre = datos[0];
                String apellidoPaterno = datos[1];
                double salario = Double.parseDouble(datos[2]);
                String departamento = datos[3];

                Empleado empleado = new Empleado(primerNombre, apellidoPaterno, salario, departamento);
                ListaEmpleados.add(empleado);
            }
            leerArchivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ListaEmpleados;

    } // fin de leerDeArchivo
}

