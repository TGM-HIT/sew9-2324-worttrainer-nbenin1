import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
public class Main {
    public static void main(String[] args) throws MalformedURLException {
        while(true) {
            JPanel panel = new JPanel(new BorderLayout());
            WordBildPaar wp = new WordBildPaar(null);
            String wortpaar = wp.randomPaar();
            String[] teile = wortpaar.split(" - ");

            String wort = "";
            String url = "";
            if (teile.length == 2) {
                wort = teile[0];
                url = teile[1];
            }

            ImageIcon bildWeg = new ImageIcon(new URL(url));
            bildWeg.setImage(bildWeg.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT));
            JLabel bild = new JLabel(bildWeg);
            panel.add(bild, BorderLayout.PAGE_START);

            JTextField text = new JTextField(10);
            panel.add(text, BorderLayout.CENTER);

            int jopion = JOptionPane.showConfirmDialog(null, panel, "Worttrainer Reloaded", JOptionPane.OK_CANCEL_OPTION);

            if (jopion == JOptionPane.OK_OPTION) {
                String eingabe = text.getText();
                JOptionPane.showMessageDialog(null, "Eingegebener Text: " + eingabe);
            }
            if (jopion == JOptionPane.CANCEL_OPTION) {
                break;
            }
        }
    }
}