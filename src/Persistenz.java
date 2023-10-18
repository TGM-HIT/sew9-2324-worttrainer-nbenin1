import org.json.JSONException;

import java.io.IOException;
import java.util.Map;
/**
 * Interface für die Auswahl von json oder xml Persistierung
 *
 * @version 18.10.2023
 * @author Nicole Benin
 */
public interface Persistenz {
    void speichern(WordBildPaar wbp) throws JSONException, IOException;
    Map<Integer,WordBildPaar> laden();
}
