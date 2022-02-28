package Core;


import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String directory = "D:\\TestDirectory";
        DeleteCopyFile filesToDelete = new DeleteCopyFile(new BrowseDirectory(directory).getList());
        if (filesToDelete.getFilesToDelete().size() != 0){
            System.out.println("Следующие файлы будут удалены:");
            for (Path p : filesToDelete.getFilesToDelete()){
                System.out.println(p);
            }
            System.out.println("\nПродолжить?   да/нет\n>>>");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("да")){
                filesToDelete.deleteFiles();
            }
        } else {
            System.out.println("Нет файлов на удаление");
        }
    }
}
