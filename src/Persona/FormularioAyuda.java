package Persona;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormularioAyuda extends JFrame {
    private JPanel panel;
    
    public FormularioAyuda() throws HeadlessException {
        setTitle("Asistente Inteligente");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);
        panel = new JPanel();
        panel.setBounds(0, 35, 500, 500);
        panel.setLayout(null);
//panel.setBackground(new Color(116, 153, 199, 204));

//Añadir botones de operaciones
        JLabel btnNumPersonas = new JLabel("Mostrar numeros de personas registradas");
        btnNumPersonas.setForeground(Color.white);
        btnNumPersonas.setFont(new Font("Roboto", Font.BOLD, 12));
        btnNumPersonas.setBounds(125, 0, 250, 40);
        btnNumPersonas.setBackground(Color.BLACK);
        btnNumPersonas.setBorder(BorderFactory.createLineBorder(Color.white));
        btnNumPersonas.setHorizontalAlignment(JLabel.CENTER);
        JLabel btnSumaSalarios = new JLabel("Suma de salarios");
        btnSumaSalarios.setForeground(Color.white);
        btnSumaSalarios.setFont(new Font("Roboto", Font.BOLD, 12));
        btnSumaSalarios.setBounds(0, 45, 240, 40);
        btnSumaSalarios.setBackground(Color.BLACK);
        btnSumaSalarios.setBorder(BorderFactory.createLineBorder(Color.white));
        btnSumaSalarios.setHorizontalAlignment(JLabel.CENTER);
        JLabel btnSalarioMayor500 = new JLabel("Salario mayor a 500");
        btnSalarioMayor500.setForeground(Color.white);
        btnSalarioMayor500.setFont(new Font("Roboto", Font.BOLD, 12));
        btnSalarioMayor500.setBounds(0, 86, 240, 40);
        btnSalarioMayor500.setBackground(Color.BLACK);
        btnSalarioMayor500.setBorder(BorderFactory.createLineBorder(Color.white));
        btnSalarioMayor500.setHorizontalAlignment(JLabel.CENTER);
        JLabel btnMayorSalarioRobles = new JLabel("Mayor salario de Robles");
        btnMayorSalarioRobles.setForeground(Color.white);
        btnMayorSalarioRobles.setFont(new Font("Roboto", Font.BOLD, 12));
        btnMayorSalarioRobles.setBounds(0, 127, 240, 40);
        btnMayorSalarioRobles.setBackground(Color.BLACK);
        btnMayorSalarioRobles.setBorder(BorderFactory.createLineBorder(Color.white));
        btnMayorSalarioRobles.setHorizontalAlignment(JLabel.CENTER);
        JLabel btnNacidos2000 = new JLabel("Nacidos despues del 2000");
        btnNacidos2000.setForeground(Color.white);
        btnNacidos2000.setFont(new Font("Roboto", Font.BOLD, 12));
        btnNacidos2000.setBounds(250, 45, 240, 40);
        btnNacidos2000.setBackground(Color.BLACK);
        btnNacidos2000.setBorder(BorderFactory.createLineBorder(Color.white));
        btnNacidos2000.setHorizontalAlignment(JLabel.CENTER);
        JLabel btnCoeficiente5_10 = new JLabel("Personas con coeficiente de 5 a 10");
        btnCoeficiente5_10.setForeground(Color.white);
        btnCoeficiente5_10.setFont(new Font("Roboto", Font.BOLD, 12));
        btnCoeficiente5_10.setBounds(250, 86, 240, 40);
        btnCoeficiente5_10.setBackground(Color.BLACK);
        btnCoeficiente5_10.setBorder(BorderFactory.createLineBorder(Color.white));
        btnCoeficiente5_10.setHorizontalAlignment(JLabel.CENTER);
        JLabel btnApellidoRobles = new JLabel("Personas con apellido Robles");
        btnApellidoRobles.setForeground(Color.white);
        btnApellidoRobles.setFont(new Font("Roboto", Font.BOLD, 12));
        btnApellidoRobles.setBounds(250, 127, 240, 40);
        btnApellidoRobles.setBackground(Color.BLACK);
        btnApellidoRobles.setBorder(BorderFactory.createLineBorder(Color.white));
        btnApellidoRobles.setHorizontalAlignment(JLabel.CENTER);
//Aniadimos listeners a los botones con sus respectivas operaciones
        btnNumPersonas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                long numPersonas = Frmulario.personas
                        .stream()
                        .count();
                JOptionPane.showMessageDialog(null, "Cantidad de personas registradas: " + numPersonas);
            }
        });
        btnSumaSalarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double sumaSalarios = Frmulario.personas.stream()
                        .mapToDouble(p -> p.getSalario()).sum();
                JOptionPane.showMessageDialog(null, "La suma de salarios de todas las personas registradas es: $" + sumaSalarios);
            }
        });
        btnSalarioMayor500.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//imprimir numeros de personas con un salario mayor a 500
                long numPersonasMayor500 = Frmulario.personas.stream()
                        .filter(p -> p.getSalario() > 500).count();
                JOptionPane.showMessageDialog(null, "Cantidad de personas con un salario mayor a 500: " + numPersonasMayor500);
            }
        });
        btnMayorSalarioRobles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double mayorSalario = Frmulario.personas.stream()
                        .filter(p -> p.getApellido().equals("Robles"))
                        .mapToDouble(p -> p.getSalario()).max().getAsDouble();
                JOptionPane.showMessageDialog(null, "Mayor salario entre las personas que se apellidan 'Robles': $" + mayorSalario);
            }
        });
        btnNacidos2000.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Tabla(1).setVisible(true);
            }
        });
        btnCoeficiente5_10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Tabla(2).setVisible(true);
            }
        });
        btnApellidoRobles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Tabla(3).setVisible(true);
            }
        });
        panel.add(btnNumPersonas);
        panel.add(btnSumaSalarios);
        panel.add(btnSalarioMayor500);
        panel.add(btnMayorSalarioRobles);
        panel.add(btnNacidos2000);
        panel.add(btnCoeficiente5_10);
        panel.add(btnApellidoRobles);
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        FormularioAyuda frm = new FormularioAyuda();
        frm.setVisible(true);
    }
}