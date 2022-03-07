package Core;

public class Main {
    public static void main(String[] args) {
        String directory = "D:\\TestDirectory";
        DeleteCopyFile filesToDelete = new DeleteCopyFile(new BrowseDirectory(directory).getList());
        Control.managing(filesToDelete);
    }
}
