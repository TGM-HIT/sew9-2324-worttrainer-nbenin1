import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * Speichern und Laden von einem Json-File
 *
 * @version 18.10.2023
 * @author Nicole Benin
 */
public class JsonPersistenz implements Persistenz{
    private String pfad = "";
    public JsonPersistenz(String pfad){
        this.pfad = pfad;
    }

    @Override
    public void speichern(WordBildPaar wbp) {
        try {
            Map<Integer, WordBildPaar> map = laden();

            int size = map.size();
            map.put(size, wbp);

            JSONArray jsonArray = new JSONArray();
            for (Map.Entry<Integer, WordBildPaar> entry : map.entrySet()) {
                JSONObject obj = new JSONObject();
                obj.put("id", entry.getKey());
                obj.put("wort", entry.getValue().getWort());
                obj.put("url", entry.getValue().getUrl());
                jsonArray.put(obj);
            }

            try (FileWriter file = new FileWriter(pfad)) {
                file.write(jsonArray.toString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public Map<Integer,WordBildPaar> laden(){
        Map<Integer, WordBildPaar> map = new HashMap<>();
        try {
            if(pfad == null){
                map.put(0, new WordBildPaar("Banane","https://www.kochschule.de/sites/default/files/images/kochwissen/440/banane.jpg"));
                map.put(1, new WordBildPaar("Apfel","https://media.happycolorz.de/zeichnen-vorlagen/apfel-zeichnen-6.jpg"));
            }else {
                JSONTokener tokener = new JSONTokener(new FileReader(pfad));
                JSONArray jsonArray = new JSONArray(tokener);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    String wort = jsonObject.getString("wort");
                    String url = jsonObject.getString("url");

                    map.put(id, new WordBildPaar(wort, url));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
