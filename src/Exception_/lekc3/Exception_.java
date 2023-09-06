package Exception_.lekc3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exception_ {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("OOP_intellij/src/Excetion_/lekc3/file.txt");
            FileWriter writer = new FileWriter("OOP_intellij/src/Excetion_/lekc3/test")){
            while (reader.ready()) {
                writer.write(reader.read());
            }
        }catch (RuntimeException | IOException e){
            System.out.println("catch exception: " + e.getClass().getSimpleName());
        }
        System.out.println("copy sucess");
        try{
            System.out.println(1/0);
        }catch (Exception e){
            System.out.println(e);
        }

        finally {
            System.out.println("er2");
        }
    }
}
