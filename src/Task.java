import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Task {
    public byte[][] matrix;
    public int width;
    public int height;
    public int firstRow;
    public int secondRow;
    
    /*
    * Користувач вводить розміри матриці, 
    * якщо дані не валідні, то задаються стандартні розміри
    */
    public void arraySize(Scanner scanner){
        try{
            System.out.println("Enter array width: ");
            this.width = scanner.nextInt();
            System.out.println("Enter array height: ");
            this.height = scanner.nextInt();
        } catch(java.util.InputMismatchException exception){
            System.out.println("Error. Wrong input. Now width = 5, height = 5");
            this.width = 5;
            this.height = 5;
        }
        this.matrix = new byte[this.height][this.width];
    }
    
    /*
    * Заповнення матриці
    */
    public void arrayFill(){
        Random random = new Random();
        for(byte[] row:matrix)
            Arrays.fill(row, (byte)random.nextInt(10));
    }
    
    /*
    * Вивід матриці
    */
    public void arrayShow(){
        for(byte[] row:matrix)
            System.out.println(Arrays.toString(row));
    }
    
    public void arraySwap(Scanner scanner){
        /*
        * Користувач вводить номери рядів, які подтрібно поміняти місцями,
        * якщо дані не валідні, то задаються стандартні номери рядів.
        */
        try{
            int matrixLen = matrix.length - 1;
            System.out.println("Enter first row (from 0 to " + matrixLen + "): ");
            firstRow = scanner.nextInt();
            System.out.println("Enter second row (from 0 to " + matrixLen + ", do not match to previous row): ");
            secondRow = scanner.nextInt();
            if(firstRow == secondRow || firstRow < 0 || firstRow > matrixLen || secondRow < 0 || secondRow > matrixLen){
                throw new java.util.InputMismatchException();
            }
        } catch(java.util.InputMismatchException exception){
            System.out.println("Error. Wrong row number. Now First = 0, Second = 1");
            firstRow = 0;
            secondRow = 1;
        }
        
        /*
        * 'Свап' двух рядів, що були задані раніше, та вивід нової матриці
        */
        byte[] temp = Arrays.copyOf(matrix[firstRow], matrix[firstRow].length);
        matrix[firstRow] = matrix[secondRow];
        matrix[secondRow] = temp;
    }
}
