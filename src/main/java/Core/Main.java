package Core;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String directory = "D:\\TestDirectory";
        BrowseDirectory browseDirectory = new BrowseDirectory(directory);
        // Здесь происходит выбор удалять копии файлов или папок или и то и другое (не реализовано)

        System.out.println("Удаление файлов:");
        new DeleteCopyFile(browseDirectory.getFiles());
    }
}
