/**
 * Word-Url Paare mit Wort und Url
 *
 * @version 18.10.2023
 * @author Nicole Benin
 */
public class WordBildPaar {
    private String url;
    private String wort;

    public WordBildPaar(String wort, String url) {
        this.url=url;
        this.wort= wort;
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

    public String toString(){
        return ", Wort: " + getWort() + ", Url: " + getUrl();

    }
}
