package Core;

import java.util.Scanner;

public class Control {
    public static void managing(DeleteCopyFile filesToDelete) {
        if (filesToDelete.getFilesToDelete().size() != 0) {
            System.out.println("Следующие файлы будут удалены:");

            filesToDelete.getFilesToDelete().forEach(System.out::println);
            System.out.println("\nПродолжить?   да/нет\n>>>");

            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("да".toLowerCase())) {
                filesToDelete.deleteFiles();
            } else System.out.println("Не удалять, так не удалять... Нечего и начинать. :(");
        } else {
            System.out.println("Нет файлов на удаление");
        }
    }
}
