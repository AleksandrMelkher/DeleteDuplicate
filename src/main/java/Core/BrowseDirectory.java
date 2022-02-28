package Core;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedList;


public class BrowseDirectory {
    private final LinkedList<FilesInPath> list = new LinkedList<>();

    public BrowseDirectory(String directory) {
        openDir(directory);
        Collections.sort(list);
    }

    public LinkedList<FilesInPath> getList() {
        return this.list;
    }

    /**
     * В метод передается директория в виде строки и все файлы из нее и из поддиректорий
     * помещаются в список list в виде объектов с полем sizeFile и nameFiles
     */
    private void openDir(String directory) {
        Path file = Path.of(directory);
        try (var directoryStream = Files.newDirectoryStream(file)) {
            for (Path d : directoryStream) {
                if (Files.isDirectory(d)) {
                    openDir(d.toString());
                } else {
                    try (InputStream inputStream = Files.newInputStream(d)) {
                        int sizeFile = inputStream.available();
                        list.add(new FilesInPath(sizeFile, d));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Объект FilesInPath, нужен для упорядочевания коллекции list.
     * Имеет поля: "имя файла" и "размер файла".
     * Коллекция list упорядочивается по размеру файла, для этого объект наследует
     * интерфейс Comparable и его метод compareTo().
     */
    protected static class FilesInPath implements Comparable<FilesInPath> {
        private final int sizeFile;
        private final Path nameFile;

        private FilesInPath(int sizeSile, Path nameFiles) {
            this.sizeFile = sizeSile;
            this.nameFile = nameFiles;
        }

        public int getSizeFile() {
            return sizeFile;
        }

        public Path getNameFile() {
            return nameFile;
        }

        @Override
        public int compareTo(FilesInPath f) {
            return this.getSizeFile() - f.getSizeFile();
        }
    }
}

