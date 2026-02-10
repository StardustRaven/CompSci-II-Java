import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilePooper {
    public static void main(String[] args) {

        String fileName = "data/input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Something went sideways: " + e.getMessage());
            System.out.println("Working directory: " + System.getProperty("user.dir"));
        }
    }
}
