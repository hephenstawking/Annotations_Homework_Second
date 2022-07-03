package annotations.homework;

import java.io.IOException;
import java.lang.reflect.Method;

public class Worker {
    public static void main(String[] args) {
        TextContainer tc = new TextContainer();
        Class<?> cls = tc.getClass();

        if (cls.isAnnotationPresent(SavePath.class)) {
            SavePath savePath = cls.getAnnotation(SavePath.class);
            String path = savePath.path();

            Method[] mtds = cls.getDeclaredMethods();

            for (Method mtd : mtds) {
                if (mtd.isAnnotationPresent(Saver.class)) {
                    try {
                        tc.saveToFile(path);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
