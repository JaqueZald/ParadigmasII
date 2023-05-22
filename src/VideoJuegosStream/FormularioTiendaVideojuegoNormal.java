package VideoJuegosStream;

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
import java.util.Scanner;
import java.util.stream.Collectors;

public class FormularioTiendaVideojuegoNormal extends JFrame {
    private ArrayList<Videojuego> videojuegos;
    private DefaultTableModel modelo = new DefaultTableModel();
    private Object[] fila = new Object[10];
    private JPanel panel = new JPanel(new BorderLayout());
    private JScrollPane scrollTabla = new JScrollPane(panel);
    private JTable tabla = new JTable(modelo);
    private JPanel panelTextArea = new JPanel();
    private JTextArea salidas = new JTextArea("");
    private JScrollPane scrollSalidas = new JScrollPane(salidas);
    private JPanel panelBotones = new JPanel(new GridLayout(3,2));
    private JButton btnMostrarTitulos = new JButton("Mostrar titulos de Videojuegos");
    private JButton btnMostrarAno = new JButton("Mostrar solo columna Año");
    private JButton btnMostrarSuma_NA = new JButton("Suma de los valores de la columna Ventas_NA");
    private JButton btnMostrar_Max_Min_JP = new JButton("Obtener valor máximo y mínimo de la columna Ventas_JP");
    private JButton btnMostrarPromedioGlobal = new JButton("Obtener promedio de Ventas Globales");
    private JButton btnMostrarTitulo_Plataforma = new JButton("Mostrar solo Titulo y Plataforma");
    public FormularioTiendaVideojuegoNormal() throws HeadlessException, FileNotFoundException {
        this.setTitle("Tienda de Videojuegos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1040, 560);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        initComponents();
    }
    private void initComponents() throws FileNotFoundException {
        videojuegos = leerDatosVideojuegos();
        this.getContentPane().setLayout(null);
        panelTextArea.setLayout(null);
        salidas.setEditable(false);
        salidas.setBounds(0,0,1000,170);
        scrollSalidas.setBounds(20,20,1000,170);
        panelTextArea.add(scrollSalidas);
        scrollTabla.setBounds(20,200,1000, 200);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = tabla.getColumnModel();
        for (int column = 0; column < tabla.getColumnCount(); column++) {
            int width = 15;
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
        panelBotones.add(btnMostrarTitulos);
        panelBotones.add(btnMostrarAno);
        panelBotones.add(btnMostrarSuma_NA);
        panelBotones.add(btnMostrar_Max_Min_JP);
        panelBotones.add(btnMostrarPromedioGlobal);
        panelBotones.add(btnMostrarTitulo_Plataforma);
        btnMostrarTitulos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarTitulos();
            }
        });
        btnMostrarAno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarColumnaAno();
            }
        });
        btnMostrarSuma_NA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarSuma_NA();
            }
        });
        btnMostrar_Max_Min_JP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrar_Max_Min_JP();
            }
        });
        btnMostrarPromedioGlobal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarPromedioGlobal();
            }
        });
        btnMostrarTitulo_Plataforma.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarTitulo_Plataforma();
            }
});
        this.getContentPane().add(panelBotones);
        this.getContentPane().add(scrollTabla);
        this.getContentPane().add(scrollSalidas);
    }
    private ArrayList<Videojuego> leerDatosVideojuegos() throws FileNotFoundException {
        ArrayList<Videojuego> datosVideojuegos = new ArrayList<>();
        String[] datos;
        File archivo = new File(getClass().getResource("ventas_videojuegos.txt").getFile());
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
                modelo.addColumn(datos[7]);
                modelo.addColumn(datos[8]);
                modelo.addColumn(datos[9]);
            } else {
                int indice = Integer.parseInt(datos[0]);
                String titulo = datos[1];
                String plataforma = datos[2];
                int anio = Integer.parseInt(datos[3]);
                String genero = datos[4];
                String publisher = datos[5];
                double ventasNA = Double.parseDouble(datos[6]);
                double ventasEU = Double.parseDouble(datos[7]);
                double ventasJP = Double.parseDouble(datos[8]);
                double ventasGlob = Double.parseDouble(datos[9]);
                datosVideojuegos.add(new Videojuego(indice, titulo, plataforma, anio, genero, publisher,
                        ventasNA, ventasEU, ventasJP, ventasGlob));
            }
            contador++;
        }
        for (Videojuego juego : datosVideojuegos) {
            fila[0] = juego.getIndice();
            fila[1] = juego.getTitulo();
            fila[2] = juego.getPlataforma();
            fila[3] = juego.getAno();
            fila[4] = juego.getGenero();
            fila[5] = juego.getPublisher();
            fila[6] = juego.getVentas_NA();
            fila[7] = juego.getVentas_EU();
            fila[8] = juego.getVentas_JP();
            fila[9] = juego.getVentas_Globales();
            modelo.addRow(fila);
        }
        return datosVideojuegos;
    }
    private void mostrarTitulos(){
        salidas.setText("");
        List<String> titulos;
        titulos = videojuegos.stream().map(v -> v.getTitulo()).collect(Collectors.toList());
        salidas.setText("-- Titulos de Videojuegos-- \n");
        for (String titulo: titulos) {
            salidas.append(titulo + "\n");
        }
    }
    private void mostrarColumnaAno(){
        salidas.setText("");
        List<Integer> anos;
        anos = videojuegos.stream().map(v -> v.getAno()).collect(Collectors.toList());
        salidas.setText("-- Anios de Videojuegos -- \n");
        for (int anio: anos){
            salidas.append(anio + "\n");
        }
    }
    private void mostrarSuma_NA(){
        salidas.setText("");
        double suma_NA = videojuegos.stream().mapToDouble(v -> v.getVentas_NA()).sum();
        salidas.setText("-- Ventas de NA -- \n");
        salidas.append("La suma total de ventas de NA es: $" + suma_NA + "\n");
    }
    private void mostrar_Max_Min_JP(){
        salidas.setText("");
        double max_JP = videojuegos.stream().mapToDouble(v -> v.getVentas_JP()).max().getAsDouble();
        double min_JP = videojuegos.stream().mapToDouble(v -> v.getVentas_JP()).min().getAsDouble();
        salidas.setText("-- Ventas de JP -- \n");
        salidas.append("La venta máxima de JP es: $" + max_JP + "\n");
        salidas.append("La venta mínima de JP es: $" + min_JP + "\n");
    }
    private void mostrarPromedioGlobal(){
        salidas.setText("");
        double promedio = videojuegos.stream().mapToDouble(v ->
                v.getVentas_Globales()).average().getAsDouble();
        salidas.setText("-- Ventas Globales -- \n");
        salidas.append("El promedio de ventas globales es: $" + promedio + "\n");
    }
    private void mostrarTitulo_Plataforma(){
        salidas.setText("");
        List<String> titulos;
        List<String> plataformas;
        titulos = videojuegos.stream().map(v -> v.getTitulo()).collect(Collectors.toList());
        plataformas = videojuegos.stream().map(v -> v.getPlataforma()).collect(Collectors.toList());
        salidas.setText("-- Titulos y Plataformas -- \n");
        for (int i = 0; i < titulos.size(); i++) {
            salidas.append(titulos.get(i) + " - " + plataformas.get(i) + "\n");
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        new FormularioTiendaVideojuegoNormal().setVisible(true);
    }
}