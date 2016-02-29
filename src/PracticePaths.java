import java.io.IOException;
import java.nio.file.*;

/**
 * Created by Christian on 29-2-2016.
 */
public class PracticePaths {

    public static void main(String[] args) {
        try {
            Path p1 = Paths.get("C:\\Users\\Christian\\Desktop\\Tools\\Personen.txt");

            System.out.format("toString: %s%n", p1.toString());
            System.out.format("getFileName: %s%n", p1.getFileName());
            System.out.format("getName(0): %s%n", p1.getName(0));
            System.out.format("getNameCount: %d%n", p1.getNameCount());
            System.out.format("subpath(0,2): %s%n", p1.subpath(0, 2));
            System.out.format("getParent: %s%n", p1.getParent());
            System.out.format("getRoot: %s%n", p1.getRoot());

            for (Path name : p1) {
                System.out.println(name);
            }

            boolean isRegularFile = Files.isRegularFile(p1);
            boolean isReadableFile = Files.isReadable(p1);
            boolean isExecutableFile = Files.isExecutable(p1);
            System.out.println(isRegularFile + "+" + isReadableFile + "+" + isExecutableFile);


            Path p2 = Paths.get("C:\\Users\\Christian\\Desktop\\Tools\\onzin.txt");
            //Files.delete(p2); ((Throws Exception))

            FileStore store = Files.getFileStore(p1);

            long total = store.getTotalSpace() / 1024;
            long used = (store.getTotalSpace() -
                    store.getUnallocatedSpace()) / 1024;
            long avail = store.getUsableSpace() / 1024;

            System.out.println("Total space = " + total);
            System.out.println("Used space = " + used);
            System.out.println("Available space = " + avail);

        } catch (NoSuchFileException a) {
            System.err.format("%s: no such" + " file or directory%n", a);
        } catch (DirectoryNotEmptyException a) {
            System.err.format("%s not empty%n", a);
        } catch (IOException a) {
            // File permission problems are caught here.
            System.err.println(a);
        }
    }
}








