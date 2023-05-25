package Hilos.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eje17Part2 {
    private JFrame frame;
    private JLabel questionLabel;
    private JTextArea resultTextArea;
    private JScrollPane resultScrollPane;
    private JTextField answerTextField;
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
        questionLabel = new JLabel(activities[currentQuestionIndex]);
        topPanel.add(questionLabel);

        answerTextField = new JTextField(15);
        submitButton = new JButton("Submit");
        topPanel.add(answerTextField);
        topPanel.add(submitButton);

        resultTextArea = new JTextArea(30, 50);
        resultTextArea.setEditable(false);
        resultScrollPane = new JScrollPane(resultTextArea);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(resultScrollPane, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String response = answerTextField.getText().trim();
                String correctAnswer = correctAnswers[currentQuestionIndex];
                resultScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                resultTextArea.append("Question: " + activities[currentQuestionIndex] + "\n");
                resultTextArea.append("Response: " + response + "\n");

                if (response.equalsIgnoreCase(correctAnswer)) {
                    resultTextArea.append("Correct!\n");
                } else {
                    resultTextArea.append("Incorrect!\n");
                    resultTextArea.append("Correct answer: " + correctAnswer + "\n");
                }

                resultTextArea.append("-----------------------\n");

                currentQuestionIndex++;

                if (currentQuestionIndex < activities.length) {
                    questionLabel.setText(activities[currentQuestionIndex]);
                    answerTextField.setText("");
                    answerTextField.requestFocus();
                } else {
                    questionLabel.setText("Questionnaire completed.");
                    answerTextField.setEnabled(false);
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

