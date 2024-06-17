import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class HelloWorld {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JLabel label = new JLabel("Hello World", JLabel.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 24));
        
        frame.add(label);
        frame.setVisible(true);
    }
}
