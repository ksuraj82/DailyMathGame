package arithmetic;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class MathGamePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num1, num2, correctAnswer;
    private String operator;
    private JLabel questionLabel, resultLabel, userName, instructionLabel;
    private JTextField answerField;

    public MathGamePanel(String operator, String gamerName) {
        this.operator = operator;

//        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        setLayout(null);
        
        
        userName = new JLabel();
        userName.setBounds(150, 30, 400, 40);
        userName.setText("Welcome , "+ gamerName);
        userName.setFont(new Font("Arial", Font.BOLD, 24));
        
        
//        JLabel welcomeLabel = new JLabel("Welcome, " + userName);
//        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centers horizontally
//        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // 2. The Label Below (Instruction/Status)
        instructionLabel = new JLabel("Get ready to solve! You are at Level 1");
        instructionLabel.setBounds(150, 60, 400, 40);
        

        questionLabel = new JLabel();
        questionLabel.setBounds(50, 100, 150, 40);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        answerField = new JTextField(5);
        answerField.setBounds(200, 100, 150, 40);
        answerField.setFont(new Font("Arial", Font.PLAIN, 24));
        

        resultLabel = new JLabel("Enter your answer!");
        resultLabel.setBounds(200, 150, 200, 40);
        resultLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        
        JButton checkButton = new JButton("Check Answer");
        checkButton.setBounds(200, 200, 150, 40);
        
        
        add(userName);
        add(Box.createVerticalStrut(10));
        add(instructionLabel);
        add(Box.createVerticalStrut(10));
        add(questionLabel);
        add(answerField);
        add(checkButton);
        add(resultLabel);

        generateNewQuestion();

       
        
        setVisible(true);
        answerField.setEnabled(true);
        answerField.setEditable(true);
        answerField.setFocusable(true);
        
        checkButton.addActionListener(e -> checkAnswer());
        answerField.addActionListener(e -> checkAnswer());
//        answerField.requestFocus();
        
        answerField.addAncestorListener(new javax.swing.event.AncestorListener() {
            @Override
            public void ancestorAdded(javax.swing.event.AncestorEvent event) {
                // Use requestFocusInWindow for better reliability in Swing
                answerField.requestFocusInWindow();
            }

            @Override public void ancestorRemoved(javax.swing.event.AncestorEvent event) {}
            @Override public void ancestorMoved(javax.swing.event.AncestorEvent event) {}
        });
        
        
    }

    private void generateNewQuestion() {
        Random rand = new Random();
        num1 = rand.nextInt(10) + 1;
        num2 = rand.nextInt(10) + 1;

        switch (operator) {
            case "+": correctAnswer = num1 + num2; break;
            case "-": 
                // Ensure no negative answers for kids
                if(num1 < num2) { int temp = num1; num1 = num2; num2 = temp; }
                correctAnswer = num1 - num2; 
                break;
            case "x": correctAnswer = num1 * num2; break;
            case "/": 
                // Ensure clean division
                correctAnswer = num1;
                num1 = num1 * num2; 
                break;
        }
        questionLabel.setText(num1 + " " + operator + " " + num2 + " = ");
        answerField.setText("");

    }

    private void checkAnswer() {
        try {
            int userAnswer = Integer.parseInt(answerField.getText());
            if (userAnswer == correctAnswer) {
                resultLabel.setText("CORRECT!");
                resultLabel.setForeground(new Color(0, 150, 0));
                generateNewQuestion(); // Give them a new one!
            } else {
                resultLabel.setText("Try again! Dont stop");
                answerField.setText(""); 
                resultLabel.setForeground(Color.RED);
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a number!");
        }
    }

}
