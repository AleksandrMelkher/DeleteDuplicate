package Core;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class BrowseDirectory {
    private final ArrayList<File> filesList = new ArrayList<>();
    private final ArrayList<File> directoriesList = new ArrayList<>();

    public BrowseDirectory(String directory) {
        OpenDir(directory);
    }

    private void OpenDir(String directory) {
        File file = new File(directory);
        for (File files : Objects.requireNonNull(file.listFiles())) {
            if (files.isFile()) {
                filesList.add(files);
            } else{
                directoriesList.add(files);
            }
        }
    }

    public ArrayList<File> getFiles() {
        Collections.sort(filesList);
        return filesList;
    }

    public ArrayList<File> getPath() {
        Collections.sort(directoriesList);
        return directoriesList;
    }
}