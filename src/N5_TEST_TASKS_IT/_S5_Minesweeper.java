package N5_TEST_TASKS_IT;

import java.util.Arrays;
import java.util.Scanner;

public class _S5_Minesweeper {
    private static final char MINE_SYMBOL = '*';

    public static void main(String[] args) {
        int size = 8; // Size of the matrix (N*N)
        char[][] matrix = createMatrix(size);

        // Prompt the user to input mine coordinates
        inputMineCoordinates(matrix);

        // Fill the matrix with proper values
        fillMatrix(matrix);

        // Print the matrix
        printMatrix(matrix);
    }

    public static char[][] createMatrix(int size) {
        char[][] matrix = new char[size][size];
        for (char[] row : matrix) {
            Arrays.fill(row, '0');
        }
        return matrix;
    }

    public static void inputMineCoordinates(char[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates of 10 mines (row column):");
        for (int i = 0; i < 10; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            matrix[row][col] = MINE_SYMBOL;
        }
    }

    public static void fillMatrix(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] != MINE_SYMBOL) {
                    int count = countAdjacentMines(matrix, row, col);
                    matrix[row][col] = (char) (count + '0');
                }
            }
        }
    }

    public static int countAdjacentMines(char[][] matrix, int row, int col) {
        int count = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < cols && matrix[i][j] == MINE_SYMBOL) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
