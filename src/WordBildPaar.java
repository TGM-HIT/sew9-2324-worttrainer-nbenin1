import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WordBildPaar {
    private String url;
    private String wort;

    WordBildPaar() {
        try {
            JSONTokener tokener = new JSONTokener(new FileReader("D:\\Schule\\5.Klasse\\SEW\\Projekte\\ReloadedWorttrainer\\WordBilldPaar.json"));
            JSONArray jsonArray = new JSONArray(tokener);

            Map<Integer, String> map = new HashMap<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String wort = jsonObject.getString("wort");
                String url = jsonObject.getString("url");

                map.put(id, wort + " - " + url);
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

    public void randomPaar(){

    }
}
