package R20220126.Z03;

import java.io.File;
import java.nio.file.Path;

public class Poba {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Intellij Projects\\Java\\L06\\Z02\\proizvodi");
        Path parent = path.getParent().getFileName();
        System.out.println(parent);

        File file = new File("C:/aaa/bbb/ccc/ddd/test.java");
        File currentPath = new File(file.getParent());
//get current path "C:/aaa/bbb/ccc/ddd/"
        String currentFolder= currentPath.getName();
        System.out.println(currentFolder);
    }
}