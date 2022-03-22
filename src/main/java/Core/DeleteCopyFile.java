package Core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class DeleteCopyFile {
    private final LinkedList<Path> filesToDelete = new LinkedList<>();

    public DeleteCopyFile(LinkedList<BrowseDirectory.FilesInPath> list) {
        deletionFiles(list);
    }

    /**
     *  Метод в качестве аргумента принимает объект лист, в ячейках которго содержатся объекты типа
     *  BrowseDirectory.FilesInPath. (лист со всеми файлами в директории, в которой будут удаляться дубликаты)
     *  На вфыходе метода - лист filesToDelete, это лист с файлами помеченными на удаление.
     */
    public void deletionFiles(LinkedList<BrowseDirectory.FilesInPath> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getSizeFile() == (list.get(i + 1)).getSizeFile()) {
                filesToDelete.add(list.get(i + 1).getNameFile());
            }
        }
    }

    public LinkedList<Path> getFilesToDelete() {
        return filesToDelete;
    }

    /**
     * Метод для удаления файлов из спика filesToDelete.
     */
    public void deleteFiles() {
        for (Path p : filesToDelete) {
            try {
                Files.delete(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
