import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests
 *
 * @version 18.10.2023
 * @author Nicole Benin
 */
public class Tests {

    @DisplayName("Pfad null/ungültig")
    @Test
    public void testPfadNull(){
        JsonPersistenz json = new JsonPersistenz(null);
        Map<Integer, WordBildPaar> map = new HashMap<>();
        Map<Integer, WordBildPaar> mapÜbergeben;
        map.put(0, new WordBildPaar("Banane","https://www.kochschule.de/sites/default/files/images/kochwissen/440/banane.jpg"));
        map.put(1, new WordBildPaar("Apfel","https://media.happycolorz.de/zeichnen-vorlagen/apfel-zeichnen-6.jpg"));
        mapÜbergeben = json.laden();
        assertEquals(map.toString(), mapÜbergeben.toString());
    }

    @DisplayName("Index Auswahl Worttrainer richtig Json")
    @Test
    public void IndexAuswahlWorttrainer() throws JSONException, IOException {
        JsonPersistenz json = new JsonPersistenz("D:\\Schule\\5.Klasse\\SEW\\Projekte\\sew9-2324-worttrainer-nbenin1\\WordBilldPaar.json");
        Rechtschreibtrainer rsr = new Rechtschreibtrainer(json);
        WordBildPaar s = rsr.fixPaar(2);
        assertEquals(s.toString(),", Wort: Katze, Url: https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Hauskatze_langhaar.jpg/1200px-Hauskatze_langhaar.jpg");
    }

    @DisplayName("Index Auswahl Worttrainer richtig XML")
    @Test
    public void IndeAuswahlWorttrainerXML() throws JSONException, IOException {
        XmlPersistenz json = new XmlPersistenz("D:\\Schule\\5.Klasse\\SEW\\Projekte\\sew9-2324-worttrainer-nbenin1\\WordBild.xml");
        Rechtschreibtrainer rsr = new Rechtschreibtrainer(json);
        WordBildPaar s = rsr.fixPaar(2);
        assertEquals(s.toString(),", Wort: Katze, Url: https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Hauskatze_langhaar.jpg/1200px-Hauskatze_langhaar.jpg");
    }
}