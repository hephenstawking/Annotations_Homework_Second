package annotations.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface SavePath {
    String path ();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Saver {

}

@SavePath(path = "some.txt")
public class TextContainer {
    String str = "There is some string";

    @Saver
    public void saveToFile (String path) throws IOException {

        try(FileWriter fileWriter = new FileWriter(path, true);
            PrintWriter pw = new PrintWriter(fileWriter);) {
            pw.println(str);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

}
