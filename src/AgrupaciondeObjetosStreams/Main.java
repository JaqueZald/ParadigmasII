package AgrupaciondeObjetosStreams;

import javax.sql.rowset.Predicate;
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

public class Main extends  JFrame {
    private ArrayList<Personas> Everest;
    private DefaultTableModel modelo = new DefaultTableModel();
    private Object[] fila = new Object[10];
    private JPanel panel = new JPanel(new BorderLayout());
    private JScrollPane scrollTabla = new JScrollPane(panel);
    private JTable tabla = new JTable(modelo);
    private JPanel panelTextArea = new JPanel();
    private JTextArea salidas = new JTextArea("");
    private JScrollPane scrollSalidas = new JScrollPane(salidas);
    private JPanel panelBotones = new JPanel(new GridLayout(3, 2));
    private JButton btnMostrarNacionalidadUK = new JButton("Nombre y Nacionalidad de United Kingdom");
    private JButton btnMostrarEdad18 = new JButton("Nombre y edad personas entre 18 y 21 años");
    private JButton btnMostrarEdad50 = new JButton("Nombre y edad personas que no sean menores a los 50 años");
    private JButton btnMostrarMexicanas = new JButton("nombre, edad y nacionalidad de las personas que tengan 25 años o que sean de nacionalidad mexicana");




}