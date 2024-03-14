import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Leer {
    public static void main(String[] args) {
        try {
            File f = new File("SAC_DeepSky_Ver81_QCQ.TXT");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            String[] busca;
            String OBJECT;// 0
            String TYPE;// 2
            String CON; // 3
            String RA;// 4
            String DEC;// 5
            String MAG;// 6
            File guardar = new File("SAC.bin");
            FileOutputStream fs = new FileOutputStream(guardar);
            ObjectOutputStream oos = new ObjectOutputStream(fs);
            while (linea != null) {
                busca = linea.split(",");
                TYPE = busca[2].replace("\"", "");
                if (TYPE.equals("GALXY")) {
                    OBJECT = busca[0].replace("\"", "").replace(" ", "");
                    CON = busca[3].replace("\"", "").replace(" ", "");
                    RA = busca[4].replace("\"", "");
                    DEC = busca[5].replace("\"", "");
                    MAG = busca[6].replace("\"", "");
                    Galaxy gala = new Galaxy(OBJECT, CON, RA, DEC, MAG);
                    oos.writeObject((Galaxy)gala);
                }
                linea = br.readLine();
            }
            oos.close();
            fs.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("No existe el archivo o el directorio");
        }
    }
}
