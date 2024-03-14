import java.io.Serializable;

public class Galaxy implements Serializable {

    public String OBJECT;
    public String CON;
    public String RA;
    public String DEC;
    public String MAG;

    public Galaxy(String oBJECT, String cON, String rA, String dEC, String mAG) {
        this.OBJECT = oBJECT;
        this.CON = cON;
        this.RA = rA;
        this.DEC = dEC;
        this.MAG = mAG;
    }

}
