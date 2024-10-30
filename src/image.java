import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class image {
    public static void operate(int key) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
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
                JOptionPane.showMessageDialog(null, "Image decrypted!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Image Encrypton");
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Roboto", Font.BOLD, 25);

        JLabel l1;
        l1 = new JLabel("Enter key to decrypt image:");
        l1.setBounds(50, 50, 300, 30);
        f.add(l1);

        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setBounds(50, 50, 100, 30);
        passwordField.setFont(font);

        JButton button = new JButton();
        button.setText("Decrypt Image");
        button.setBounds(50, 100, 150, 30);
        button.setFont(font);

        button.addActionListener(e -> {
            String password = new String(passwordField.getPassword());
            if (!password.equals("")) {
                int temp = Integer.parseInt(password);
                operate(temp);
            } else {
                JOptionPane.showMessageDialog(null, "Enter Key");
            }
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
        f.add(passwordField);
        f.add(button);
        f.add(backButton);
        f.setVisible(true);

    }
}