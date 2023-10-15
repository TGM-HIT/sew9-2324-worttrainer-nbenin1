import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Rechtschreibtrainer {
    private Map<Integer, String> map = new HashMap<>();
    Rechtschreibtrainer(WordBildPaar wbp) {
        this.map = wbp.getMap();
        System.out.println(map.size());

        System.out.println("onvienreivnerinviernvuiervnernverivuiernviuernvnerivnerinviervuiernvi");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int id = entry.getKey();
            String data = entry.getValue();
            System.out.println("ID: " + id + ", Data: " + data);
        }
    }

    public String randomPaar(){
        Random r = new Random();
        System.out.println(map.size());
        int z = r.nextInt(map.size());
        System.out.println(map.size());
        System.out.println(z);
        String s = map.get(z);
        System.out.println(s);
        return s;
    }

    public String fixPaar(int id){
        String s = map.get(id);
        System.out.println(s);
        return s;
    }

    public void check(String richtigwort, String eingabeWort){
        boolean r = eingabeWort.toLowerCase().equals(richtigwort.toLowerCase());
        System.out.println(r);
    }
}
