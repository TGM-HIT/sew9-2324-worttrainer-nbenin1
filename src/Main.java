import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Main-Klasse mit der View vom Worttrainer
 *
 * @version 18.10.2023
 * @author Nicole Benin
 */
public class Main {
    public static void main(String[] args) throws JSONException, IOException {
        Persistenz persistenz = null;
        boolean richtig = true;
        boolean check = true;
        String wort = "";
        String url = "";
        Statistik sll = new Statistik();
        do {
            String s = JOptionPane.showInputDialog(null, "json oder xml?").toUpperCase();
            if (s.equals("JSON")) {
                persistenz = new JsonPersistenz("D:\\Schule\\5.Klasse\\SEW\\Projekte\\sew9-2324-worttrainer-nbenin1\\WordBilldPaar.json");
                richtig = false;
            } else if (s.equals("XML")) {
                persistenz = new XmlPersistenz("D:\\Schule\\5.Klasse\\SEW\\Projekte\\sew9-2324-worttrainer-nbenin1\\WordBild.xml");
                richtig = false;
            } else {
                persistenz = null;
            }
            System.out.println(s);
        }while(richtig == true);
        Rechtschreibtrainer rsr = new Rechtschreibtrainer(persistenz);
        while(true) {
            JPanel panel = new JPanel(new BorderLayout());
            if(check == true) {
                WordBildPaar wortpaar = rsr.randomPaar();
                wort = wortpaar.getWort();
                url = wortpaar.getUrl();
            }

            ImageIcon bildWeg = new ImageIcon(new URL(url));
            bildWeg.setImage(bildWeg.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT));
            JLabel bild = new JLabel(bildWeg);
            panel.add(bild, BorderLayout.PAGE_START);

            JTextField text = new JTextField(10);
            panel.add(text, BorderLayout.CENTER);

            JLabel ins = new JLabel("Insgesamt: " + sll.getInsgesamt() + ", Richig: " + sll.getRichtig() + ", Falsch: " + sll.getFalsch());
            panel.add(ins, BorderLayout.PAGE_END);

            int jopion = JOptionPane.showConfirmDialog(null, panel, "Worttrainer Reloaded", JOptionPane.OK_CANCEL_OPTION);

            if (jopion == JOptionPane.OK_OPTION) {
                String eingabe = text.getText();
                JOptionPane.showMessageDialog(null, "Eingegebener Text: " + eingabe);
                check = rsr.check(wort,eingabe);
                if(check == true){
                    sll.setRichtig();
                }else{
                    sll.setFalsch();
                }
                sll.setInsgesamt();
                JOptionPane.showMessageDialog(null, "Eingegebener Text: " + check);
            }
            if (jopion == JOptionPane.CANCEL_OPTION) {
                break;
            }
        }
    }
}
