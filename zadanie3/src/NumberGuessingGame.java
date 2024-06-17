import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Enhanced Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JLabel promptLabel = new JLabel("Guess the number between 1 and 100:");
        JTextField guessField = new JTextField();
        JButton guessButton = new JButton("Guess");
        JLabel resultLabel = new JLabel();
        
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        final int[] attempts = {0};
        
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(guessField.getText());
                    attempts[0]++;
                    int difference = guess - numberToGuess;
                    
                    if (Math.abs(difference) > 10) {
                        if (guess < numberToGuess) {
                            resultLabel.setText("Value too low");
                        } else {
                            resultLabel.setText("Value too high");
                        }
                    } else {
                        if (guess < numberToGuess) {
                            resultLabel.setText("low");
                        } else if (guess > numberToGuess) {
                            resultLabel.setText("high");
                        } else {
                            resultLabel.setText("Correct! You guessed it in " + attempts[0] + " tries.");
                        }
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });
        
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(promptLabel);
        frame.add(guessField);
        frame.add(guessButton);
        frame.add(resultLabel);
        
        frame.setVisible(true);
    }
}
