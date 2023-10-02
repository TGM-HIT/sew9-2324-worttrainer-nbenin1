import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        JPanel panel = new JPanel(new BorderLayout());
        ImageIcon bildWeg = new ImageIcon(new URL("https://www.kochschule.de/sites/default/files/images/kochwissen/440/banane.jpg"));
        bildWeg.setImage(bildWeg.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT));
        JLabel bild = new JLabel(bildWeg);
        panel.add(bild, BorderLayout.PAGE_START);

        JTextField text = new JTextField(10);
        panel.add(text, BorderLayout.CENTER);

        int jopion = JOptionPane.showConfirmDialog(null, panel, "Worttrainer Reloaded", JOptionPane.OK_CANCEL_OPTION);

        if (jopion == JOptionPane.OK_OPTION) {
            String eingabe = text.getText();
            JOptionPane.showMessageDialog(null, "Eingegebener Text: " + eingabe);
        }

        WordBildPaar wp = new WordBildPaar();

    }
}