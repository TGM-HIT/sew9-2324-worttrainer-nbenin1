import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JPanel panel = new JPanel(new BorderLayout());
        ImageIcon bildWeg = new ImageIcon("D:\\Schule\\Diplom\\Logo\\Logo.jpg");
        JLabel bild = new JLabel(bildWeg);
        panel.add(bild, BorderLayout.PAGE_START);

        JTextField text = new JTextField(10);
        panel.add(text, BorderLayout.CENTER);

        int jopion = JOptionPane.showConfirmDialog(null, panel, "Worttrainer Reloaded", JOptionPane.OK_CANCEL_OPTION);

        if (jopion == JOptionPane.OK_OPTION) {
            String eingabe = text.getText();
            JOptionPane.showMessageDialog(null, "Eingegebener Text: " + eingabe);
        }
    }
}