package Predicados;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPredicados extends  JFrame {
    private ArrayList<Personas> Everest;
    private DefaultTableModel modelo = new DefaultTableModel();
    private Object[] fila = new Object[10];
    private JPanel panel = new JPanel(new BorderLayout());
    private JScrollPane scrollTabla = new JScrollPane(panel);
    private JTable tabla = new JTable(modelo);
    private JPanel panelTextArea = new JPanel();
    private JTextArea salidas = new JTextArea("");
    private JScrollPane scrollSalidas = new JScrollPane(salidas);
    private JPanel panelBotones = new JPanel(new GridLayout(3,2));
    private JButton btnMostrarNacionalidad = new JButton("Nacionalidad");
    private JButton btnMostrarCausaMuerte = new JButton("Causa de Muerte");
    private JButton btnMostrarUbicacion = new JButton("Ubicacion");

    public MainPredicados() throws HeadlessException, FileNotFoundException {
        this.setTitle("Personas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1040, 560);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        initComponents();
    }
    private void initComponents() throws FileNotFoundException {
        Everest = leerDatos();
        this.getContentPane().setLayout(null);//Establecemos el layout de la ventana
        panelTextArea.setLayout(null);
        salidas.setEditable(false);
        salidas.setBounds(0,0,1000,170);
        scrollSalidas.setBounds(20,20,1000,170);
        panelTextArea.add(scrollSalidas);
        scrollTabla.setBounds(20,200,1000, 200);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = tabla.getColumnModel();
        for (int column = 0; column < tabla.getColumnCount(); column++) {
            int width = 15; // Ancho mínimo de columna
            for (int row = 0; row < tabla.getRowCount(); row++) {
                TableCellRenderer renderer = tabla.getCellRenderer(row, column);
                Component comp = tabla.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
        panel.add(tabla.getTableHeader(), BorderLayout.NORTH);
        panel.add(tabla, BorderLayout.CENTER);
        panelBotones.setBounds(20,410,1000,100);
        //panelBotones.setBackground(Color.red);
        panelBotones.add(btnMostrarNacionalidad);
        panelBotones.add(btnMostrarCausaMuerte);
        panelBotones.add(btnMostrarUbicacion);

        btnMostrarNacionalidad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarNacionalidad();
            }
        });
        btnMostrarCausaMuerte.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarCausaMuerte();
            }
        });
        btnMostrarUbicacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarUbicacion();
            }
        });



        this.getContentPane().add(panelBotones);
        this.getContentPane().add(scrollTabla);
        this.getContentPane().add(scrollSalidas);
    }

    private ArrayList<Personas> leerDatos() throws FileNotFoundException {
        ArrayList<Personas> datosEverest = new ArrayList<>();
        String[] datos;

        File archivo = new File("C:\\Users\\ADMIN\\IdeaProjects\\ParadigmasII\\src\\AgrupaciondeObjetosStreams\\muertes_everest.txt");
        Scanner lector = new Scanner(archivo);
        int contador = 0;
        while (lector.hasNext()) {
            String linea = lector.nextLine();
            datos = linea.split("\\|");
            if (contador == 0) {
                modelo.addColumn(datos[0]);
                modelo.addColumn(datos[1]);
                modelo.addColumn(datos[2]);
                modelo.addColumn(datos[3]);
                modelo.addColumn(datos[4]);
                modelo.addColumn(datos[5]);
                modelo.addColumn(datos[6]);

            } else {
                String nombre = datos[0];
                String fecha = datos[1];
                String edad = datos[2];
                String expedicion = datos[3];
                String nacionalidad = datos[4];
                String causaDeMuerte = datos[5];
                String ubicacion = datos[6];
                datosEverest.add(new Personas(nombre, fecha, edad,expedicion,
                        nacionalidad,causaDeMuerte,ubicacion));
            }
            contador++;
        }
        for (Personas dato : datosEverest) {
            fila[0] = dato.getNombre();
            fila[1] = dato.getFecha();
            fila[2] = dato.getEdad();
            fila[3] = dato.getExpedicion();
            fila[4] = dato.getNacionalidad();
            fila[5] = dato.getCausamuerte();
            fila[6] = dato.getUbicacion();
            modelo.addRow(fila);
        }
        return datosEverest;
    }
    private void mostrarNacionalidad(){
        salidas.setText("");

        Map<String, List<Personas>> agrupadoPorNacionalidad =
                Everest.stream()
                        .collect(Collectors.groupingBy(Personas::getNacionalidad));

        salidas.setText("Agrupado Por Nacionalidad\n");
        agrupadoPorNacionalidad.forEach((nacionalidad,personasNacionalidad)->{
            salidas.append("\n-------- "+nacionalidad+" ---------\n");
            personasNacionalidad.forEach(personas->salidas.append(personas.toString()));
        });

    }
    private void mostrarCausaMuerte(){
        salidas.setText("");
        Map<String, List<Personas>> agrupadoPorCausaMuerte =
                Everest.stream()
                        .collect(Collectors.groupingBy(Personas::getCausamuerte));

        salidas.setText("Agrupado Por Causa de Muerte\n");
        agrupadoPorCausaMuerte.forEach((CausaMuerte,personasCausaMuerte)->{
            salidas.append("\n-------- "+CausaMuerte+" ---------\n");
            personasCausaMuerte.forEach(persona->salidas.append(personasCausaMuerte.toString()));
        });
    }
    private void mostrarUbicacion(){
        salidas.setText("");
        Map<String, List<Personas>> agrupadoPorUbicacion =
                Everest.stream()
                        .collect(Collectors.groupingBy(Personas::getUbicacion));
        salidas.setText("Agrupado Por Ubicacion\n");
        agrupadoPorUbicacion.forEach((ubicacion,personasUbicacion)->{
            salidas.append("\n-------- "+ubicacion+" ---------\n");
            personasUbicacion.forEach(persona->salidas.append(persona.toString()));
        });
    }
    public static void main(String[] args) throws FileNotFoundException {
        new MainPredicados().setVisible(true);
    }
}
