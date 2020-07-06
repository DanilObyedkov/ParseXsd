/*
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteFile {

    public static void main(String[] args) {
        String data = "566436fwe0ig2wehg023gh239-gh3540gbhn2403gb243g";

        int noOfLines = 10000;


        // пишем в файл с помощью OutputStream
        writeUsingOutputStream(data);


    // пишем в файл с помощью OutputStream
    private static void writeUsingOutputStream(String data) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File("H:/Try/src/main/resources/class.txt"));

            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}*/
