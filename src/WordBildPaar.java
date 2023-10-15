import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WordBildPaar {
    private String url;
    private String wort;
    private Map<Integer, String> map = new HashMap<>();
    WordBildPaar(String pfad) {
        try {
            if(pfad == null){
                map.put(0, "Banane" + " - " + "https://www.kochschule.de/sites/default/files/images/kochwissen/440/banane.jpg");
                map.put(1, "Apfel" + " - " + "https://media.happycolorz.de/zeichnen-vorlagen/apfel-zeichnen-6.jpg");
            }else {
                JSONTokener tokener = new JSONTokener(new FileReader(pfad));
                JSONArray jsonArray = new JSONArray(tokener);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    String wort = jsonObject.getString("wort");
                    String url = jsonObject.getString("url");

                    map.put(id, wort + " - " + url);
                }
            }
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                int id = entry.getKey();
                String data = entry.getValue();
                System.out.println("ID: " + id + ", Data: " + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WordBildPaar(){
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWort() {
        return wort;
    }

    public void setWort(String wort) {
        this.wort = wort;
    }

    public Map<Integer,String> getMap(){
        return map;
    }
}
