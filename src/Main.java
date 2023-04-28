import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /*
        * Створення сканера, завдяки якому, можна буде отримувати дані від користувача.
        */
        Scanner scanner = new Scanner(System.in);
        int width, height;
        /*
        * Користувач вводить розміри матриці, 
        * якщо дані не валідні, то задаються стандартні розміри
        */
        try{
            System.out.println("Enter array width: ");
            width = scanner.nextInt();
            System.out.println("Enter array height: ");
            height = scanner.nextInt();
        } catch(java.util.InputMismatchException exception){
            System.out.println("Error. Wrong input. Now width = 5, height = 5");
            width = 5;
            height = 5;
        }
        
        /*
        * Створення числової матриці
        */
        byte [][] matrix = new byte[height][width];
        Random random = new Random();
        
        /*
        * Заповнення і вивід матриці
        */
        for(byte[] row:matrix)
            Arrays.fill(row, (byte)random.nextInt(10));
        for(byte[] row:matrix)
            System.out.println(Arrays.toString(row));
        
        int firstRow, secondRow;
        /*
        * Користувач вводить номери рядів, які подтрібно поміняти місцями,
        * якщо дані не валідні, то задаються стандартні номери рядів.
        */
        try{
            int matrixLen = matrix.length;
            System.out.println("Enter first row (from 1 to " + matrixLen + "): ");
            firstRow = scanner.nextInt();
            System.out.println("Enter second row (from 1 to " + matrixLen + ", do not match to previous row): ");
            secondRow = scanner.nextInt();
            if(firstRow == secondRow || firstRow < 1 || firstRow > matrixLen || secondRow < 1 || secondRow > matrixLen){
                throw new java.util.InputMismatchException();
            }
        } catch(java.util.InputMismatchException exception){
            System.out.println("Error. Wrong row number. Now First = 1, Second = 2");
            firstRow = 1;
            secondRow = 2;
        }
        
        /*
        * 'Свап' двух рядів, що були задані раніше, та вивід нової матриці
        */
        byte[] temp = Arrays.copyOf(matrix[firstRow - 1], matrix[firstRow].length);
        matrix[firstRow - 1] = matrix[secondRow - 1];
        matrix[secondRow - 1] = temp;
        for(byte[] row:matrix)
            System.out.println(Arrays.toString(row));
    }
}
