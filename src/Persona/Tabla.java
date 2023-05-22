package Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
public class Tabla  extends  JFrame {
    private DefaultTableModel modelo = new DefaultTableModel();
    private Object[] fila = new Object[6];
    private JPanel panel = new JPanel(new BorderLayout());
    private JScrollPane scroll = new JScrollPane(panel);
    private JTable tabla = new JTable(modelo);
    public Tabla(int bandera) throws HeadlessException {
        this.setTitle("Vistas de datos");
        this.setSize(500,700);
        this.setLocationRelativeTo(null);
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Año de nacimiento");
        modelo.addColumn("Salario");
        modelo.addColumn("Coeficiente");
        if (bandera==1){
            mostrarTablaPersonas2000();
        } else if (bandera==2) {
            mostrarPersonasCoeficientes5_10();
        }else mostrarPersonasApellidoRobles();
    }
    void mostrarTablaPersonas2000(){
        this.setTitle("Personas nacidas despues del 2000");
        List<Persona> personasMilenarias;
        personasMilenarias=Frmulario.personas.stream()
                .filter(p -> p.getAnioNacimiento() > 2000).collect(Collectors.toList());
        for (Persona aux:personasMilenarias) {
            fila[0]=aux.getId();
            fila[1]=aux.getNombre();
            fila[2]=aux.getApellido();
            fila[3]=aux.getAnioNacimiento();
            fila[4]=aux.getSalario();
            fila[5]=aux.getCoeficiente();
            modelo.addRow(fila);
        }
        panel.add(tabla.getTableHeader(), BorderLayout.NORTH);
//Agregue el contenido de la tabla al centro del contenedor
        panel.add(tabla,BorderLayout.CENTER);
        setContentPane(scroll);
    }
    void mostrarPersonasCoeficientes5_10(){
        this.setTitle("Personas con coeficientes entre 5 y 10");
        List<Persona> personasCoeficientes;
        personasCoeficientes=Frmulario.personas.stream()
                .filter(p -> p.getCoeficiente() > 5 && p.getCoeficiente() < 10).collect(Collectors.toList());
        for (Persona aux:personasCoeficientes) {
            fila[0]=aux.getId();
            fila[1]=aux.getNombre();
            fila[2]=aux.getApellido();
            fila[3]=aux.getAnioNacimiento();
            fila[4]=aux.getSalario();
            fila[5]=aux.getCoeficiente();
            modelo.addRow(fila);
        }
        panel.add(tabla.getTableHeader(), BorderLayout.NORTH);
//Agregue el contenido de la tabla al centro del contenedor
        panel.add(tabla,BorderLayout.CENTER);
        setContentPane(scroll);
    }
    void mostrarPersonasApellidoRobles(){
        this.setTitle("Personas que se apellidan Robles");
        List<Persona> personasRobles;
        personasRobles=Frmulario.personas.stream()
                .filter(p -> p.getApellido().equals("Robles")).collect(Collectors.toList());
        for (Persona aux:personasRobles) {
            fila[0]=aux.getId();
            fila[1]=aux.getNombre();
            fila[2]=aux.getApellido();
            fila[3]=aux.getAnioNacimiento();
            fila[4]=aux.getSalario();
            fila[5]=aux.getCoeficiente();
            modelo.addRow(fila);
        }
        panel.add(tabla.getTableHeader(), BorderLayout.NORTH);
//Agregue el contenido de la tabla al centro del contenedor
        panel.add(tabla,BorderLayout.CENTER);
        setContentPane(scroll);
    }
}
