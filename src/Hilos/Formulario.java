package Hilos;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Formulario extends JFrame {
    private JTextArea cajaTexto;
    private String nombreArchivo = "texto.txt";
    private ArrayList<String> diccionario = new ArrayList<String>();

    public Formulario() {
        super("Formulario");

        // Cargar diccionario en ArrayList
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\IdeaProjects\\ParadigmasII\\src\\Hilos\\dict.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                diccionario.add(linea);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el diccionario.");
            e.printStackTrace();
        }

        // Crear caja de texto y agregar al formulario
        cajaTexto = new JTextArea();
        cajaTexto.setLineWrap(true);
        cajaTexto.setWrapStyleWord(true);
        cajaTexto.setFont(new Font("Arial", Font.PLAIN, 12));
        add(new JScrollPane(cajaTexto));

        // Leer archivo de texto y mostrar en la caja de texto
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                cajaTexto.append(linea + "\n");
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de texto.");
            e.printStackTrace();
        }

        // Hilo para guardar el contenido de la caja de texto en un archivo cada 5 segundos
        Thread hiloGuardar = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        FileWriter fw = new FileWriter(nombreArchivo);
                        fw.write(cajaTexto.getText());
                        fw.close();
                    } catch (IOException e) {
                        System.out.println("Error al guardar en el archivo de texto.");
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        System.out.println("Hilo de guardar interrumpido.");
                        e.printStackTrace();
                    }
                }
            }
        });
        hiloGuardar.start();

        // Hilo para revisar la ortografía cada 60 segundos
        Thread hiloOrtografia = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(60000);
                        String texto = cajaTexto.getText();
                        StringTokenizer st = new StringTokenizer(texto, " .,:;?!¡¿()[]{}+-*/\"\'\n\t");
                        while (st.hasMoreTokens()) {
                            String palabra = st.nextToken().toLowerCase();
                            if (!diccionario.contains(palabra)) {
                                cajaTexto.setBackground(Color.RED);
                                break;
                            } else {
                                cajaTexto.setBackground(Color.WHITE);
                            }
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Hilo de ortografía interrumpido.");
                        e.printStackTrace();
                    }
                }
            }
        });
        hiloOrtografia.start();

        // Configuración del formulario
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Formulario formulario = new Formulario();
    }
}

