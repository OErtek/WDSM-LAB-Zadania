import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroduceYourself {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Introduce Yourself Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        JTextField textField = new JTextField();
        JButton button = new JButton("Witaj");
        JLabel label = new JLabel();
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (text.isEmpty()) {
                    label.setText("Przedstaw się");
                } else {
                    label.setText("Witaj " + text);
                }
            }
        });
        
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(textField);
        frame.add(button);
        frame.add(label);
        
        frame.setVisible(true);
    }
}
