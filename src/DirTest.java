import java.io.IOException;
import java.nio.file.*;


/**
 * Created by Christian on 29-2-2016.
 */
public class DirTest {
    public static void main(String[] args) {

        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();

        for (Path name : dirs) {
            System.err.println(name);
        }


        Path dir = Paths.get("C:\\");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
    }
}
