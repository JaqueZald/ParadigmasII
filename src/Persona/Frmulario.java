package Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Frmulario extends JFrame {
    static List<Persona> personas= new ArrayList<>();
    static List<Persona> personasMilenarias = new ArrayList<>();
    DefaultTableModel modelo = new DefaultTableModel();
    public Frmulario() throws HeadlessException {
        initComponents();
        llenarTabla();
    }
    private void llenarTabla(){
        personas.add(new Persona(0, "Roberto", "Tellez", 1995, 218, 6.55));
        personas.add(new Persona(1, "Maria", "González", 2013, 2, 5.67));
        personas.add(new Persona(2, "Juan", "Davila", 2003, 299, 1.99));
        personas.add(new Persona(3, "Guillermo", "Tellez", 1997, 507, 4.18));
        personas.add(new Persona(4, "Elizabeth", "Sánchez", 2015, 605, 0.42));
        personas.add(new Persona(5, "Guillermo", "Robles", 2018, 636, 6.97));
        personas.add(new Persona(6, "Maria", "Robles", 1993, 307, 4.92));
        personas.add(new Persona(7, "Elizabeth", "González", 1998, 44, 1.47));
        personas.add(new Persona(8, "Juan", "Juárez", 2020, 632, 5.36));
        personas.add(new Persona(9, "Juan", "Sánchez", 2017, 619, 0.55));
        personas.add(new Persona(10, "Jaime", "González", 2014, 435, 6.75));
        personas.add(new Persona(11, "Maria", "González", 2005, 377, 2.52));
        personas.add(new Persona(12, "Linda", "Munguia", 2014, 440, 8.84));
        personas.add(new Persona(13, "Linda", "Davila", 2010, 724, 2.37));
        personas.add(new Persona(14, "Maria", "Robles", 1996, 929, 2.25));
        personas.add(new Persona(15, "Barbara", "González", 2005, 617, 3.69));
        personas.add(new Persona(16, "Elizabeth", "Munguia", 2001, 179, 4.69));
        personas.add(new Persona(17, "Roberto", "Méndez", 2013, 626, 8.36));
        personas.add(new Persona(18, "Miguel", "Juárez", 2002, 781, 3.93));
        personas.add(new Persona(19, "Roberto", "Robles", 2007, 270, 4.77));
        personas.add(new Persona(20, "Miguel", "Méndez", 2022, 731, 2.82));
        personas.add(new Persona(21, "Linda", "Robles", 2010, 192, 1.68));
        personas.add(new Persona(22, "Roberto", "Juárez", 2008, 151, 2.03));
        personas.add(new Persona(23, "Maria", "Robles", 2016, 734, 1.61));
        personas.add(new Persona(24, "Jaime", "Sánchez", 2018, 985, 0.41));
        personas.add(new Persona(25, "Maria", "González", 2006, 970, 3.85));
        personas.add(new Persona(26, "Barbara", "Robles", 2005, 453, 1.02));
        personas.add(new Persona(27, "Patricia", "Davila", 2002, 966, 8.21));
        personas.add(new Persona(28, "Elizabeth", "Robles", 2022, 338, 4.4));
        personas.add(new Persona(29, "Guillermo", "García", 2002, 400, 6.77));
        personas.add(new Persona(30, "Jaime", "García", 2006, 763, 5.32));
        personas.add(new Persona(31, "Patricia", "Tellez", 2020, 309, 5.58));
        personas.add(new Persona(32, "Miguel", "García", 1998, 301, 5.33));
        personas.add(new Persona(33, "Patricia", "Davila", 2014, 275, 3.45));
        personas.add(new Persona(34, "Miguel", "Sánchez", 2021, 857, 1.77));
        personas.add(new Persona(35, "Miguel", "García", 2004, 744, 1.71));
        personas.add(new Persona(36, "Juan", "Sánchez", 1998, 452, 4.34));
        personas.add(new Persona(37, "Guillermo", "Sánchez", 2017, 383, 0.54));
        personas.add(new Persona(38, "Linda", "Sánchez", 2020, 417, 8.39));
        personas.add(new Persona(39, "Patricia", "Robles", 2017, 913, 3.42));
        personas.add(new Persona(40, "Maria", "Suárez", 2013, 832, 9.67));
        personas.add(new Persona(41, "Roberto", "Munguia", 2010, 976, 6.08));
        personas.add(new Persona(42, "Elizabeth", "Davila", 2016, 887, 7.78));
        personas.add(new Persona(43, "Juan", "González", 2014, 471, 7.09));
        personas.add(new Persona(44, "Miguel", "Juárez", 2009, 54, 5.24));
        personas.add(new Persona(45, "Jaime", "Munguia", 2003, 310, 0.57));
        personas.add(new Persona(46, "Roberto", "Suárez", 2003, 136, 0.22));
        personas.add(new Persona(47, "Barbara", "Juárez", 2005, 514, 1.33));
        personas.add(new Persona(48, "Guillermo", "Tellez", 2018, 933, 2.61));
        personas.add(new Persona(49, "Juan", "García", 1998, 185, 9.06));
        personas.add(new Persona(50, "Roberto", "Suárez", 2005, 652, 4.66));
        personas.add(new Persona(51, "Linda", "Juárez", 2022, 700, 9.96));
        personas.add(new Persona(52, "Barbara", "González", 1995, 53, 8.64));
        personas.add(new Persona(53, "Barbara", "Robles", 2010, 710, 6.09));
        personas.add(new Persona(54, "Jaime", "Sánchez", 2015, 644, 6.65));
        personas.add(new Persona(55, "Patricia", "Suárez", 2016, 393, 9.22));
        personas.add(new Persona(56, "Barbara", "Davila", 2007, 946, 3.79));
        personas.add(new Persona(57, "Juan", "Davila", 2010, 481, 4.05));
        personas.add(new Persona(58, "Juan", "Robles", 1996, 285, 0.14));
        personas.add(new Persona(59, "Elizabeth", "Munguia", 2007, 576, 8.01));
        personas.add(new Persona(60, "Patricia", "Davila", 2004, 799, 1.62));
        personas.add(new Persona(61, "Maria", "Suárez", 2000, 953, 9.55));
        personas.add(new Persona(62, "Jaime", "Sánchez", 2016, 548, 4.92));
        personas.add(new Persona(63, "Guillermo", "Davila", 1998, 497, 4.48));
        personas.add(new Persona(64, "Patricia", "Davila", 2008, 117, 7.09));
        personas.add(new Persona(65, "Guillermo", "Juárez", 2004, 200, 9.95));
        personas.add(new Persona(66, "Elizabeth", "Méndez", 2022, 497, 4.08));
        personas.add(new Persona(67, "Maria", "González", 2017, 142, 6.96));
        personas.add(new Persona(68, "Guillermo", "Juárez", 2009, 810, 1.11));
        personas.add(new Persona(69, "Roberto", "Tellez", 1994, 96, 5.86));
        personas.add(new Persona(70, "Elizabeth", "Munguia", 2002, 509, 4.83));
        personas.add(new Persona(71, "Barbara", "Robles", 2012, 482, 0.79));
        personas.add(new Persona(72, "Guillermo", "Juárez", 2007, 331, 0.52));
        personas.add(new Persona(73, "Juan", "Méndez", 1997, 152, 2.5));
        personas.add(new Persona(74, "Linda", "Robles", 2018, 893, 3.0));
        personas.add(new Persona(75, "Patricia", "González", 2007, 654, 6.92));
        personas.add(new Persona(76, "Patricia", "Sánchez", 2011, 555, 6.3));
        personas.add(new Persona(77, "Patricia", "Tellez", 2021, 182, 5.38));
        personas.add(new Persona(78, "Barbara", "Tellez", 2019, 637, 5.25));
        personas.add(new Persona(79, "Roberto", "González", 1995, 447, 0.89));
        personas.add(new Persona(80, "Jaime", "Méndez", 2003, 258, 9.55));
        personas.add(new Persona(81, "Juan", "Méndez", 2004, 835, 2.77));
        personas.add(new Persona(82, "Patricia", "Davila", 2010, 773, 3.83));
        personas.add(new Persona(83, "Miguel", "Suárez", 1995, 978, 4.5));
        personas.add(new Persona(84, "Linda", "Méndez", 2003, 704, 2.5));
        personas.add(new Persona(85, "Miguel", "Juárez", 1996, 379, 9.0));
        personas.add(new Persona(86, "Linda", "Méndez", 2021, 416, 7.13));
        personas.add(new Persona(87, "Elizabeth", "Juárez", 1999, 121, 4.88));
        personas.add(new Persona(88, "Miguel", "Robles", 2009, 191, 2.81));
        personas.add(new Persona(89, "Elizabeth", "Tellez", 2006, 402, 9.1));
        personas.add(new Persona(90, "Linda", "Munguia", 1995, 688, 4.57));
        personas.add(new Persona(91, "Guillermo", "Davila", 2006, 436, 8.31));
        personas.add(new Persona(92, "Jaime", "Sánchez", 2019, 629, 1.77));
        personas.add(new Persona(93, "Miguel", "Robles", 2007, 249, 6.28));
        personas.add(new Persona(94, "Linda", "Robles", 2002, 732, 6.75));
        personas.add(new Persona(95, "Patricia", "Suárez", 1996, 793, 8.14));
        personas.add(new Persona(96, "Elizabeth", "Davila", 2020, 816, 2.2));
        personas.add(new Persona(97, "Linda", "Suárez", 2009, 943, 9.67));
        personas.add(new Persona(98, "Miguel", "Davila", 2022, 387, 1.76));
        personas.add(new Persona(99, "Patricia", "González", 1994, 413, 8.33));
        personasMilenarias=personas.stream()
                .filter(p -> p.getAnioNacimiento()>2000)
                .collect(Collectors.toList());
//Se pasan los objetos de personas milenarias al JTable
        Object[] fila = new Object[6];
        for (Persona aux:personasMilenarias){
            fila[0]=aux.getId();
            fila[1]=aux.getNombre();
            fila[2]=aux.getApellido();
            fila[3]=aux.getAnioNacimiento();
            fila[4]=aux.getSalario();
            fila[5]=aux.getCoeficiente();
            modelo.addRow(fila);
        }
    }
    private void initComponents() {
        JButton boton = new JButton("Asistente Inteligente");
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new FormularioAyuda().setVisible(true);
            }
        });
        JPanel panel = new JPanel(new BorderLayout());
//JPanel panelBoton = new JPanel();
//panelBoton.setLayout(null);
//panelBoton.setBackground(Color.pink);
//panelBoton.setSize(200,30);
//Crear JScrollPane para agregar la tabla
//(Cuando se usa un contendor intermedio para agregar la tabla)
//el encabezado y el contenido de la tabla deben agregarse por separado
        JScrollPane scroll = new JScrollPane(panel);
        JTable tabla = new JTable(modelo);
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Año de nacimiento");
        modelo.addColumn("Salario");
        modelo.addColumn("Coeficiente");
//Agregue el encabezado a la parte superior del contenedor
//(Cuando se usa un contendor intermedio para comun para agregar la tabla)
//el encabezado y el contenido de la tabla deben agregarse por separado
        panel.add(tabla.getTableHeader(), BorderLayout.NORTH);
//Agregue el contenido de la tabla al centro del contenedor
        panel.add(tabla,BorderLayout.CENTER);
        panel.add(boton,BorderLayout.SOUTH);
//panel.add(panelBoton);
        //Agregue el JScrollPane al contenedor
        setContentPane(scroll);
//caracteristicas de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700,600);
        setTitle("Procesamiento con Streams");
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new Frmulario().setVisible(true);
    }
}