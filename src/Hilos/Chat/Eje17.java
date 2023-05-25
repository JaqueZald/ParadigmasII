package Hilos.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eje17 {
    private JFrame frame;
    private JLabel PreguntaLabel;
    private JTextField RespuestaTextField;
    private JButton submitButton;
    private JTextArea resultadoTextArea;

    private String[] activities = {
            "Anne is Paul's?",
            "Jason and Emily are their?",
            "Paul is Anne's?",
            "Emily is Paul's?",
            "Jason is Emily's?",
            "Emily is Jason's?",
            "Paul and Anne are Jason's?"
    };

    private String[] correctAnswers = {
            "wife",
            "children",
            "husband",
            "son",
            "daughter",
            "sister",
            "parents"
    };

    private int currentQuestionIndex = 0;

    public Eje17() {
        frame = new JFrame("JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        PreguntaLabel = new JLabel(activities[currentQuestionIndex]);
        RespuestaTextField= new JTextField(15);
        submitButton = new JButton("Submit");
        resultadoTextArea = new JTextArea(30, 30);
        resultadoTextArea.setEditable(false);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String response = RespuestaTextField.getText().trim();
                String correctAnswer = correctAnswers[currentQuestionIndex];

                resultadoTextArea.append("Pregunta: " + activities[currentQuestionIndex] + "\n");
                resultadoTextArea.append("Respuesta: " + response + "\n");

                if (response.equalsIgnoreCase(correctAnswer)) {
                    resultadoTextArea.append("Correcto\n");
                } else {
                    resultadoTextArea.append("Incorrecto\n");
                    resultadoTextArea.append("Respuesta Correcta: " + correctAnswer + "\n");
                }

                resultadoTextArea.append("-----------------------\n");

                currentQuestionIndex++;

                if (currentQuestionIndex < activities.length) {
                    PreguntaLabel.setText(activities[currentQuestionIndex]);
                    RespuestaTextField.setText("");
                    RespuestaTextField.requestFocus();
                } else {
                    PreguntaLabel.setText("Cuestionario Terminado.");
                    RespuestaTextField.setEnabled(false);
                    submitButton.setEnabled(false);
                }
            }
        });

        frame.add(PreguntaLabel);
        frame.add(RespuestaTextField);
        frame.add(submitButton);
        frame.add(resultadoTextArea);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Eje17Part2();
            }
        });
    }
}

