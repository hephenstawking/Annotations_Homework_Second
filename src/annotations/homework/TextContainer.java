package annotations.homework;

import java.io.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.file.Files;

@Retention(RetentionPolicy.RUNTIME)
@interface SavePath {
    String path ();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Saver {

}

@SavePath(path = "some.txt")
public class TextContainer implements Serializable {
    String str = "There is some string";

    @Saver
    public void saveToFileWithSerialize (String path) throws IOException {

        try(FileOutputStream fout = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fout);) {
            out.writeObject(str);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeStringFromFile (String path) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        String str = (String) in.readObject();
        System.out.println(str);
    }

}
