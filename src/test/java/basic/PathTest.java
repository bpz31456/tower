package basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    private static String download = "D:\\计划1\\";

    public static void main(String[] args) {
        Path path = Paths.get(download);

        System.out.println();
        if (!Files.isDirectory(path) && !Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
