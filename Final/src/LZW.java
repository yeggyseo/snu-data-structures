import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Dictionary;


public class LZW {
    private String fileName = "";

    public LZW(String file) {
        fileName = file;
    }

    void decodeLZW() {
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String fileContent = file.readLine();
            String[] code = fileContent.split(",");

            System.out.println(Arrays.toString(code));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        LZW l = new LZW("encoded.txt");

        l.decodeLZW();

    }
}
