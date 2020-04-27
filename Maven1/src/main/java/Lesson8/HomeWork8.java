package Lesson8;

/*1 Задать размерность матрицы от 5 до 7
2 Создать матрицу с указанной размерностью
3 Заполнить матрицу по спирали (числа увеличиваются на 1) (число начинается с 1)*/

import java.util.Scanner;

public class HomeWork8 {

    public static void main(String[] args) {
        System.out.println("Write the size of the matrix. The first digit is the value of the row and the second is the value of the column.");
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextByte();
        scanner.close();

        System.out.println("The dimensions of the matrix are set:" + "\n x = " + row + "\n y = " + col);

        int[][] matrix = new int[row][col];
        int maxSize = row * col;
        int count = 1;
        int minCol = 0;
        int maxCol = col - 1;
        int minRow = 0;
        int maxRow = row - 1;

        while (count <= maxSize) {

            for (int i = minCol; i <= maxCol; i++) {
                matrix[minRow][i] = count;
                count++;
            }
            minRow = minRow + 1;
            for (int i = minRow; i <= maxRow; i++) {
                matrix[i][maxCol] = count;
                count++;
            }
            maxCol = maxCol - 1;
            for (int i = maxCol; i >= minCol; i--) {
                matrix[maxRow][i] = count;
                count++;
            }
            maxRow = maxRow - 1;
            for (int i = maxRow; i >= minRow; i--) {
                matrix[i][minCol] = count;
                count++;
            }
            minCol = minCol + 1;

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println("");
        }
    }
}