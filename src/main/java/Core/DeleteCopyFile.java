package Core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class DeleteCopyFile {
    private final LinkedList<BrowseDirectory.FilesInPath> list;
    private final LinkedList<Path> filesToDelete = new LinkedList<>();

    public DeleteCopyFile(LinkedList<BrowseDirectory.FilesInPath> list) {
        this.list = list;
        deletionFiles();
    }

    private void deletionFiles() {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getSizeFile() == (list.get(i + 1)).getSizeFile()) {
                filesToDelete.add(list.get(i + 1).getNameFile());
            }
        }
    }

    public LinkedList<Path> getFilesToDelete() {
        return filesToDelete;
    }

    public void deleteFiles() {
        for (Path p : getFilesToDelete()) {
            try {
                Files.delete(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
