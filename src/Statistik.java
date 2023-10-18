/**
 * Statistik mit insegsamt und richtig, falsch anzeige
 *
 * @version 18.10.2023
 * @author Nicole Benin
 */
public class Statistik {

    private int insgesamt;
    private int richtig;
    private int falsch;
    public Statistik(){
    }

    public int getInsgesamt() {
        return insgesamt;
    }

    public void setInsgesamt() {
        this.insgesamt++;
    }

    public int getRichtig() {
        return richtig;
    }

    public void setRichtig() {
        this.richtig++;
    }

    public int getFalsch() {
        return falsch;
    }

    public void setFalsch() {
        this.falsch++;
    }
}
