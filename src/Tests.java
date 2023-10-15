import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Tests {
    @DisplayName("Pfad null/ungültig")
    @Test
    public void testPfadNull(){
        WordBildPaar wbp = new WordBildPaar(null);
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> mapÜbergeben = new HashMap<>();
        map.put(0, "Banane" + " - " + "https://www.kochschule.de/sites/default/files/images/kochwissen/440/banane.jpg");
        map.put(1, "Apfel" + " - " + "https://media.happycolorz.de/zeichnen-vorlagen/apfel-zeichnen-6.jpg");
        mapÜbergeben = wbp.getMap();
        assertEquals(map, mapÜbergeben);
    }

    @DisplayName("Index Auswahl Worttrainer richtig")
    @Test
    public void IndexAuswahlWorttrainer(){
        WordBildPaar wbp = new WordBildPaar("D:\\Schule\\5.Klasse\\SEW\\Projekte\\sew9-2324-worttrainer-nbenin1\\WordBilldPaar.json");
        Rechtschreibtrainer rsr = new Rechtschreibtrainer(wbp);
        String s = rsr.fixPaar(2);
        assertEquals(s,"Katze - https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Hauskatze_langhaar.jpg/1200px-Hauskatze_langhaar.jpg");
    }

    //url ungültig
}