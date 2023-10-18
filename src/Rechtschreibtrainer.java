import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * Rechtschreibtrainer mit einer map mit wort und url Paaren. Es sucht zufällig ein paar herraus oder mit index.
 *
 * @version 18.10.2023
 * @author Nicole Benin
 */
public class Rechtschreibtrainer {
    private Map<Integer, WordBildPaar> map;
    private Persistenz ppp;
    Rechtschreibtrainer(Persistenz wbp) throws JSONException, IOException {
        this.ppp = wbp;
        wbp.speichern(new WordBildPaar("Vogel", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Ein_Eisvogel_im_Schwebflug.jpg/450px-Ein_Eisvogel_im_Schwebflug.jpg"));

        this.map = wbp.laden();
        System.out.println(map.size());

        System.out.println("onvienreivnerinviernvuiervnernverivuiernviuernvnerivnerinviervuiernvi");
        for (Map.Entry<Integer, WordBildPaar> entry : map.entrySet()) {
            int id = entry.getKey();
            WordBildPaar p = entry.getValue();
            System.out.println("ID: " + id + ", Wort: " + p.getWort() + ", Url: " + p.getUrl());
        }
    }

    public WordBildPaar randomPaar(){
        Random r = new Random();
        System.out.println(map.size());
        int z = r.nextInt(map.size());
        System.out.println(map.size());
        System.out.println(z);
        WordBildPaar w = map.get(z);
        System.out.println(w.getWort() + " - " + w.getUrl());
        return w;
    }

    public WordBildPaar fixPaar(int id){
        WordBildPaar s = map.get(id);
        System.out.println(s.getWort() + " - " + s.getUrl());
        return s;
    }

    public boolean check(String richtigwort, String eingabeWort){
        boolean r = eingabeWort.toLowerCase().equals(richtigwort.toLowerCase());
        System.out.println(r);
        return r;
    }

    public void speichern(WordBildPaar wbpS) throws JSONException, IOException {
        this.ppp.speichern(wbpS);
    }
}
