package ContadorFrecuencia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FrmConteoPalabras extends JFrame {
    StringBuilder enunciadoUnido = new StringBuilder();
    DefaultTableModel model = new DefaultTableModel();
    Map<String, Integer> frecuencias = new HashMap<>();

    public FrmConteoPalabras() {
        initComponents();
        enunciado();
        crearMapa();
        llenarTabla();
    }
    public void enunciado() {
        File archivo = new File("C:\\Users\\ADMIN\\IdeaProjects\\ParadigmasII\\src\\ContadorFrecuencia\\03.1 melville-moby_dick.txt");

        Scanner lector = null;
        try {
            lector = new Scanner(archivo);
            while (lector.hasNext()) {
                String enunciado = lector.nextLine();
                // Eliminar signos de puntuación y convertir a minúsculas
                enunciado = enunciado.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
                enunciadoUnido.append(enunciado);
            }
            System.out.println(enunciadoUnido);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void crearMapa() {

        String enunciado = String.valueOf(enunciadoUnido);
        // divide el enunciado en tokens
        String[] tokens = enunciado.split(" ");
        // procesamiento del texto de entrada
        for (String token : tokens) {
            String palabra = token.toLowerCase();
            if (frecuencias.containsKey(palabra)) {
                int cuenta = frecuencias.get(palabra);
                frecuencias.put(palabra, cuenta + 1);
            } else {
                frecuencias.put(palabra, 1);
            }
        }
        System.out.println("Prueba");
        System.out.println(enunciadoUnido.toString());
    }
    private void llenarTabla() {
        Object[] fila = new Object[2];
        Set<String> claves = frecuencias.keySet();
        TreeSet<String> clavesOrdenadas = new TreeSet<>(claves);
        for (String clave : clavesOrdenadas) {
            fila[0] = clave;
            fila[1] = frecuencias.get(clave);
            model.addRow(fila);
        }
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable table = new JTable(model);
        model.addColumn("Palabra");
        model.addColumn("No. de ocurrencias");
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        // Características de la ventana
        setTitle("Frecuencia de palabras de un archivo de texto");
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new FrmConteoPalabras().setVisible(true);
    }
}