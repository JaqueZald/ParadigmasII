package Lenguajes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Lenguaje3 extends JFrame {
    private List<String> listaLenguajes = new ArrayList<>();
    private String[] arregloLenguajes = { "Java", "Python", "JavaScript", "C#", "PHP" };
    private LinkedList<String> listaLenguajesEnlazada = new LinkedList<>(Arrays.asList(arregloLenguajes));
    private JTextArea txtAreaLenguajes;


    public Lenguaje3() {
        super("Lenguajes de Programación 2023");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los componentes
        JLabel lblTitulo = new JLabel("Seleccione una opción:");
        JLabel lblAgregar = new JLabel("Ingrese el lenguaje a agregar:");
        JLabel lblAgregarFinal = new JLabel("Ingrese el lenguaje a agregar al final:");
        JLabel lblAgregarPrincipio = new JLabel("Ingrese el lenguaje a agregar al principio:");
        JTextField txtAgregar = new JTextField();
        JTextField txtAgregarFinal = new JTextField();
        JTextField txtAgregarPrincipio = new JTextField();
        JButton btnAgregar = new JButton("Añadir elemento");
        JButton btnAgregarFinal = new JButton("Añadir elemento al final");
        JButton btnAgregarPrincipio = new JButton("Añadir elemento al principio");
        JButton btnMostrar = new JButton("Mostrar Lista de Lenguajes");
        txtAreaLenguajes = new JTextArea(10, 30);
        txtAreaLenguajes.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaLenguajes);
        add(scrollPane, BorderLayout.CENTER);
        JButton btnSalir = new JButton("Salir");
        txtAreaLenguajes = new JTextArea(100, 50);

        // Crear los paneles
        JPanel pnlTitulo = new JPanel();
        JPanel pnlOpciones = new JPanel();
        JPanel pnlAgregar = new JPanel();
        JPanel pnlAgregarFinal = new JPanel();
        JPanel pnlAgregarPrincipio = new JPanel();
        JPanel pnlBotones = new JPanel();

        // Configurar los paneles
        pnlTitulo.add(lblTitulo);

        pnlAgregar.add(lblAgregar);
        pnlAgregar.add(txtAgregar);
        pnlAgregar.add(btnAgregar);

        pnlAgregarFinal.add(lblAgregarFinal);
        pnlAgregarFinal.add(txtAgregarFinal);
        pnlAgregarFinal.add(btnAgregarFinal);

        pnlAgregarPrincipio.add(lblAgregarPrincipio);
        pnlAgregarPrincipio.add(txtAgregarPrincipio);
        pnlAgregarPrincipio.add(btnAgregarPrincipio);

        pnlOpciones.setLayout(new BorderLayout());
        pnlOpciones.add(pnlAgregar, BorderLayout.NORTH);
        pnlOpciones.add(pnlAgregarFinal, BorderLayout.CENTER);
        pnlOpciones.add(pnlAgregarPrincipio, BorderLayout.SOUTH);

        JScrollPane scrollPane1 = new JScrollPane(txtAreaLenguajes);
        pnlBotones.add(btnMostrar);
        pnlBotones.add(btnSalir);

        // Agregar los paneles a la ventana
        add(pnlTitulo, BorderLayout.NORTH);
        add(pnlOpciones, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
        add(pnlBotones, BorderLayout.PAGE_END);

        // Agregar los listeners de los botones
        btnAgregar.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                String lenguaje = txtAgregar.getText();
                listaLenguajes.add(lenguaje);
                txtAgregar.setText("");
            }
        });

        btnAgregarFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lenguaje = txtAgregarFinal.getText();
                listaLenguajesEnlazada.addLast(lenguaje);
                txtAgregarFinal.setText("");
            }
        });

        btnAgregarPrincipio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lenguaje = txtAgregarPrincipio.getText();
                listaLenguajesEnlazada.addFirst(lenguaje);
                txtAgregarPrincipio.setText("");
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Lista de Lenguajes:\n");

                // Iterar sobre el ArrayList utilizando Java 8 forEach y lambdas
                listaLenguajes.forEach(l -> sb.append("- " + l + "\n"));

                // Convertir el LinkedList en un arreglo para iterar sobre él
                String[] arregloLenguajesEnlazado = listaLenguajesEnlazada.toArray(new String[0]);

                // Iterar sobre el arreglo utilizando un bucle for
                for (String l : arregloLenguajesEnlazado) {
                    sb.append("- " + l + "\n");
                }

                txtAreaLenguajes.setText(sb.toString());
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Configurar la ventana
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Lenguaje3 formulario = new Lenguaje3();
    }
}