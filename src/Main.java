
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        * Створення сканера, завдяки якому, можна буде отримувати дані від користувача.
        */
        Scanner scanner = new Scanner(System.in);
        Task task = new Task();
        task.arraySize(scanner);
        task.arrayFill();
        task.arrayShow();
        task.arraySwap(scanner);
        task.arrayShow();
    }
}
