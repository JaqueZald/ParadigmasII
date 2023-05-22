package ListaAmigosArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

public class FrmArrayListAmigos extends JFrame {
    DefaultListModel modelo = new DefaultListModel();
    ArrayList<String> listaAlbumes = new ArrayList<>();

    public FrmArrayListAmigos() {
        initComponents();
        listaAlbumes.add("Love&Letter");
        listaAlbumes.add("Going Seventeen");
        listaAlbumes.add("AL1");
        listaAlbumes.add("TEEN, AGE");
        listaAlbumes.add("Director's Cut");
        listaAlbumes.add("You Make My Day");
        listaAlbumes.add("You Made My Down");
        listaAlbumes.add("An Ode");
        listaAlbumes.add("Heng:garæ");
        listaAlbumes.add("24H");
        llenarJListAlbumes();
    }
    public void llenarJListAlbumes(){
        modelo.removeAllElements();
        for (int i = 0; i < listaAlbumes.size(); i++) {
            modelo.addElement(listaAlbumes.get(i));
        }
    }
    private void initComponents(){
        lblSalir = new JLabel();
        lblMinimizar = new JLabel();
        lblTitulo = new JLabel();
        panelSuperior = new JPanel();

        //Caracteristicas de la ventana

        getContentPane().setBackground(new Color(247,202,201));
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 19, 19));
        //leer imagen para etiqueta
        ImageIcon iconoAlbumes = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("titulo.jpg")).getScaledInstance(600, 190, Image.SCALE_SMOOTH));
        //Establacer un layout de 2 renglones y una columna
        setLayout(null);
        //Agregar boton de salir
        ImageIcon iconorosa = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("rosa.png")).getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        lblSalir.setBounds(570,0,30,30);
        lblSalir.setIcon(iconorosa);
        lblSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        //Agregar boton de minimizar
        ImageIcon iconoAzul = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("azul.png")).getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        lblMinimizar.setBounds(540,0,30,30);
        lblMinimizar.setIcon(iconoAzul);
        lblMinimizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(lblMinimizar);
                frame.setExtendedState(JFrame.ICONIFIED);
            }
        });




        lblTitulo.setBounds(0,30,600,150);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setIcon(iconoAlbumes);

        panelSuperior.setBounds(0,0,600,30);
        panelSuperior.setLayout(null);
        panelSuperior.setBackground(new Color(241, 241, 241));
        panelSuperior.add(lblSalir);
        panelSuperior.add(lblMinimizar);
        add(panelSuperior);
        add(lblTitulo);

        JList<Object> JListAlbumes = new JList<>();
        JListAlbumes.setPreferredSize(new Dimension(300,60));
        JListAlbumes.setVisibleRowCount(5);
        JListAlbumes.setModel(modelo);

        panelParteInferior = new JPanel();
        panelParteInferior.setBounds(0,180,600,220);
        panelParteInferior.setBackground(new Color(247,202,201));
        panelParteInferior.setLayout(new GridLayout(1,2,20,20));
        add(panelParteInferior);
        panelParteInferior.add(add(new JScrollPane(JListAlbumes)));

        //Panel donde se colocan botones
        panelBotones = new JPanel();
        panelBotones.setBackground(new Color(247,202,201));
        panelBotones.setLayout(new GridLayout(3,1,10,10));
        panelParteInferior.add(panelBotones);

        //Se establecen botones y se anaden al panel
        btnAgregar = new JButton("Agregar album");
        btnBuscar = new JButton("Buscar album");
        btnBorrar = new JButton("Borrar album");
        JButton[] botonesPanel = {btnAgregar,btnBuscar,btnBorrar};
        propiedadesBotones(botonesPanel);


        //Eventos
        btnAgregar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnAgregarActionPerfomed(e);
                    }
                }
        );
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBorrarActionPerfomed(e);
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBuscarActionPerfomed(e);
            }
        });

        panelBotones.add(btnAgregar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnBorrar);

    }
    //Lista de eventos
    public void btnAgregarActionPerfomed(ActionEvent event){
        String nombreAlbum = JOptionPane.showInputDialog("Escribe el nombre del album");
        if (nombreAlbum.equals("")||nombreAlbum.equals(" ")||nombreAlbum==null){
            return;
        }
        listaAlbumes.add(nombreAlbum);
        llenarJListAlbumes();
    }
    public void btnBuscarActionPerfomed(ActionEvent event){
        String nombreAlbum = JOptionPane.showInputDialog("Escribe el nombre del album para buscar");
        if (nombreAlbum.equals("")||nombreAlbum.equals(" ")||nombreAlbum==null){
            return;
        }
        if (listaAlbumes.contains(nombreAlbum)){
            JOptionPane.showMessageDialog(this,"Album encontrado");
        }else {
            JOptionPane.showMessageDialog(this, "No se encontro el album");
        }
    }
    public void btnBorrarActionPerfomed(ActionEvent event){
        String nombreAlbum = JOptionPane.showInputDialog("Escribe el album a borrar");
        Boolean encontrado = false;
        if (nombreAlbum.equals("")||nombreAlbum.equals(" ")||nombreAlbum==null){
            return;
        }
        Iterator<String> iterador = listaAlbumes.iterator();
        while (iterador.hasNext()){
            if (nombreAlbum.equals(iterador.next())){
                iterador.remove();
                encontrado=true;
                JOptionPane.showMessageDialog(this, "Album eliminado");
            }
        }
        if (!encontrado){
            JOptionPane.showMessageDialog(this,"No se encontro el elemento");
        }
        llenarJListAlbumes();
    }
    //Aplicar propiedadas a botones
    public void propiedadesBotones (JButton[] botones){
        for (JButton boton:botones) {
            boton.setBackground(new Color(247,202,201));
            boton.setFocusPainted(false);
            boton.setFocusable(false);
            //boton.setForeground(Color.lightGray);
            //boton.setBorderPainted(false);
            // Agregar el MouseListener al botón
            boton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // El cursor ha entrado en el área del botón
                    boton.setBorder(BorderFactory.createLineBorder(Color.RED));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // El cursor ha salido del área del botón
                    boton.setBorder(UIManager.getBorder("Button.border"));
                }
            });
        }
    }

    public static void main(String[] args) {
        new FrmArrayListAmigos().setVisible(true);
    }

    //Se declaran los controles que llevara el formulario
    private JList<String> JListVideojuegos;
    private JLabel lblSalir;
    private JLabel lblMinimizar;
    private JLabel lblTitulo;
    private JButton btnAgregar;
    private JButton btnBuscar;
    private JButton btnBorrar;
    JPanel panelSuperior;
    JPanel panelBotones;
    JPanel panelParteInferior;
}
