package Hilos.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eje17Part2 {
    private JFrame frame;
    private JLabel PreguntaLabel;
    private JTextArea resultadoTextArea;
    private JScrollPane resultadoScrollPane;
    private JTextField respuestaTextField;
    private JButton submitButton;

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

    public Eje17Part2() {
        frame = new JFrame("JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        PreguntaLabel = new JLabel(activities[currentQuestionIndex]);
        topPanel.add(PreguntaLabel);

        respuestaTextField = new JTextField(15);
        submitButton = new JButton("Submit");
        topPanel.add(respuestaTextField);
        topPanel.add(submitButton);

        resultadoTextArea = new JTextArea(30, 50);
        resultadoTextArea.setEditable(false);
        resultadoScrollPane = new JScrollPane(resultadoTextArea);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(resultadoScrollPane, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String response = respuestaTextField.getText().trim();
                String correctAnswer = correctAnswers[currentQuestionIndex];
                resultadoScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                resultadoTextArea.append("Pregunta: " + activities[currentQuestionIndex] + "\n");
                resultadoTextArea.append("Respuesta: " + response + "\n");

                if (response.equalsIgnoreCase(correctAnswer)) {
                    resultadoTextArea.append("Correct!\n");
                } else {
                    resultadoTextArea.append("Incorrecto\n");
                    resultadoTextArea.append("Respuesta correcta: " + correctAnswer + "\n");
                }

                resultadoTextArea.append("-----------------------\n");

                currentQuestionIndex++;

                if (currentQuestionIndex < activities.length) {
                    PreguntaLabel.setText(activities[currentQuestionIndex]);
                    respuestaTextField.setText("");
                    respuestaTextField.requestFocus();
                } else {
                    PreguntaLabel.setText("Cuestionario Completo");
                    respuestaTextField.setEnabled(false);
                    submitButton.setEnabled(false);
                }
            }
        });

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

