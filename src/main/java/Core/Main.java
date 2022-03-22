package Core;

public class Main {
    public static void main(String[] args) {
        String directory= "";
        System.out.println(directory);
        DeleteCopyFile filesToDelete = new DeleteCopyFile(new BrowseDirectory(directory).getList());
        Control.managing(filesToDelete);
    }
}
