package Exception_.lekc3;

import java.io.FileWriter;
import java.io.IOException;

public class SaveService {
    public  void save() {
        System.out.println("save document started...");
        try (FileWriter writer = new FileWriter("test")) {
            throw new Exception("operation failed");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
