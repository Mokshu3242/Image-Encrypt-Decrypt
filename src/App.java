import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("Image Encrypton & Decryption");
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Font font = new Font("Roboto", Font.BOLD, 25);

    JLabel label = new JLabel("Choose one of the options:");
    label.setFont(font);

    JButton button1 = new JButton("Encryption");
    button1.setFont(font);
    button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Imageen.main(args);
        }
    });

    JButton button2 = new JButton("Decryption");
    button2.setFont(font);
    button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            image.main(args);
        }
    });

    frame.setLayout(new FlowLayout());
    frame.add(label);
    frame.add(button1);
    frame.add(button2);
    frame.setVisible(true);
}
}