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
    private JLabel questionLabel, resultLabel;
    private JTextField answerField;

    public MathGamePanel(String operator) {
        this.operator = operator;

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        answerField = new JTextField(5);
        answerField.setFont(new Font("Arial", Font.PLAIN, 24));

        JButton checkButton = new JButton("Check Answer");
        resultLabel = new JLabel("Enter your answer!");
        resultLabel.setFont(new Font("Arial", Font.ITALIC, 18));

        add(questionLabel);
        add(answerField);
        add(checkButton);
        add(resultLabel);

        generateNewQuestion();

        checkButton.addActionListener(e -> checkAnswer());
        
        setVisible(true);
        
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
                resultLabel.setText("CORRECT! 🎉");
                resultLabel.setForeground(new Color(0, 150, 0));
                generateNewQuestion(); // Give them a new one!
            } else {
                resultLabel.setText("Try again! You are at level 1");
                resultLabel.setForeground(Color.RED);
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a number!");
        }
    }

}
