import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilePooper {
    public static void main(String[] args) {

        //System.out.println("Java is running from: " + System.getProperty("user.dir"));

        String fileName = "input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Something went sideways: " + e.getMessage());
        }
    }
}
