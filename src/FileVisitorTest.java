import java.io.IOException;
import java.nio.file.*;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;


/**
 * Created by Christian on 27-2-2016.
 */
public class FileVisitorTest implements FileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isSymbolicLink()) {
            System.out.format("Symbolic link: %s%n ", file);
        } else if (attrs.isRegularFile()) {
            System.out.format("Regular file: %s%n ", file);
        } else {
            System.out.format("Other: %s%n ", file);
        }
        System.out.println("(" + attrs.size() + "bytes)");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.format("Files visited %s%n", file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.format("Visits failed to %s%n", file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.format("Post Visited %s%n", dir);
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {

        Path startingDir = Paths.get("C:\\Users\\Christian\\Desktop\\Tools");
        FileVisitorTest pf = new FileVisitorTest();
        try {
            Files.walkFileTree(startingDir, pf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}