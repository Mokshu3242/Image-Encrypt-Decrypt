import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class Imageen {

    public static void operate(int key) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            int i = 0;
            for (byte b : data) {
                data[i] = (byte) (b ^ key);
                i++;
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Your password is " + key);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Image Decrypton");
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Roboto", Font.BOLD, 25);

        JLabel l1;
        l1 = new JLabel("Set only numeric Key:");
        l1.setBounds(50, 50, 100, 30);
        f.add(l1);

        JTextField textField = new JTextField(10);
        textField.setBounds(50, 50, 100, 30);
        textField.setFont(font);

        JButton buttonR = new JButton();
        buttonR.setText("Random");
        buttonR.setBounds(50, 100, 100, 30);
        buttonR.setFont(font);

        JButton button = new JButton();
        button.setText("Open Image");
        button.setBounds(50, 100, 100, 30);
        button.setFont(font);

        button.addActionListener(e -> {
            String text = textField.getText();
            if (!text.equals("")) {
                int temp = Integer.parseInt(text);
                operate(temp);
            } else {
                JOptionPane.showMessageDialog(null, "Enter Key");
            }
        });

        buttonR.addActionListener(e -> {
            Random r = new Random();
            operate(r.nextInt(1000));
        });
        JButton backButton = new JButton();
        backButton.setText("Back");
        backButton.setBounds(50, 150, 100, 30);
        backButton.setFont(font);

        backButton.addActionListener(e -> {
            f.dispose();
            App.main(args);
        });

        f.setLayout(new FlowLayout());
        f.add(textField);
        f.add(buttonR);
        f.add(button);
        f.add(backButton);
        f.setVisible(true);

    }
}