package Core;

import java.io.File;
import java.util.ArrayList;

public class DeleteCopyFile {

    private final ArrayList<File> filesListDelete;

    public DeleteCopyFile(ArrayList<File> object) {
        this.filesListDelete = object;
        fleOrPath();
    }

    private void fleOrPath() {
        deleteFile();
        // метод выбора удаление папок или файлов не создан. (по умолчанию удаляются файлы)
    }

    private void deleteFile() {
        int numRemoteObjects = 0;
        int numberObjects = filesListDelete.size();
        for (int i = 0; i < numberObjects - 1; i++) {
            if (filesListDelete.get(i).length() == filesListDelete.get(i + 1).length()) {
                var delete = filesListDelete.get(i).delete();
                numRemoteObjects += 1;
            }
        }
        System.out.printf("Удалено %d файлов.\n", numRemoteObjects);
    }
}
