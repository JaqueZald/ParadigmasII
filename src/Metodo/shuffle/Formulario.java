package Metodo.shuffle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class Formulario extends JFrame {
    MazodeCartas cartas;
    private List<Carta> listaCartas;
    public Formulario (){
        initComponents();
        revolverCartas();
    }
    public void revolverCartas(){
        cartas = new MazodeCartas();
        listaCartas = cartas.getListaCartas();
        agregarImagenes();
    }
    public void agregarImagenes(){
        List<Carta> cartasAleatorias=cartas.getListaCartas();
        asignarImagen(cartasAleatorias.get(0).toString(), imagen1);
        asignarImagen(cartasAleatorias.get(1).toString(), imagen2);
        asignarImagen(cartasAleatorias.get(2).toString(), imagen3);
        asignarImagen(cartasAleatorias.get(3).toString(), imagen4);
        asignarImagen(cartasAleatorias.get(4).toString(), imagen5);
        asignarImagen(cartasAleatorias.get(5).toString(), imagen6);
        asignarImagen(cartasAleatorias.get(6).toString(), imagen7);
    }
    public void asignarImagen(String nombreImagen, JLabel imagen){
        ImageIcon picture;
        try{
            String carpeta = "cartas/";
            picture = new ImageIcon(getClass().getResource(carpeta + nombreImagen+ ".png"));
            Icon imgEscalada = new ImageIcon(picture.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH));
            imagen.setIcon(imgEscalada);
        }catch(Exception e){
            e.printStackTrace();;
        }
    }
    private void initComponents(){
        imagen1= new JLabel();
        imagen2= new JLabel();
        imagen3= new JLabel();
        imagen4= new JLabel();
        imagen5= new JLabel();
        imagen6= new JLabel();
        imagen7= new JLabel();
        lblTitulo= new JLabel();
        btnRevolver = new JButton("Revolver Cartas");
        btnRevolver.setForeground(Color.white);
        btnRevolver.setBackground(Color.black);
        btnRevolver.setFont(new Font("Dialog", 0, 30));
        btnRevolver.setPreferredSize(new Dimension(100, 60));
        btnRevolver.setHorizontalAlignment(SwingConstants.CENTER);
        //Caracteristicas ventana
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);
        //Titulo
        setLayout( new GridLayout(3, 1, 10, 10));
        lblTitulo.setFont(new Font("Dialog", 0, 48));
        lblTitulo.setText("JUEGO DE CARTAS");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setPreferredSize(new Dimension(100, 60));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitulo);
        add(btnRevolver);
        //eventos boton
        btnRevolver.addActionListener(new ActionListener(){
                                          @Override
                                          public void actionPerformed(ActionEvent e){
                                              revolverCartas();
                                          }
                                      }
        );
        panelImagenes = new JPanel();
        panelImagenes.setBackground(Color.black);
        panelImagenes.setLayout(new GridLayout(1, 5, 10, 10));
        add(panelImagenes);
        int altura = 180;
        int anchura = 120;
        imagen1.setSize(anchura, altura);
        imagen2.setSize(anchura, altura);
        imagen3.setSize(anchura, altura);
        imagen4.setSize(anchura, altura);
        imagen5.setSize(anchura, altura);
        imagen6.setSize(anchura, altura);
        imagen7.setSize(anchura, altura);
        panelImagenes.add(imagen1);
        panelImagenes.add(imagen2);
        panelImagenes.add(imagen3);
        panelImagenes.add(imagen4);
        panelImagenes.add(imagen5);
        panelImagenes.add(imagen6);
        panelImagenes.add(imagen7);
    }
    public static void main(String [] args){
        new Formulario().setVisible(true);
    }
    private JLabel lblTitulo;
    private JLabel imagen1;
    private JLabel imagen2;
    private JLabel imagen3;
    private JLabel imagen4;
    private JLabel imagen5;
    private JLabel imagen6;
    private JLabel imagen7;
    private JButton btnRevolver;
    JPanel panelImagenes;
}