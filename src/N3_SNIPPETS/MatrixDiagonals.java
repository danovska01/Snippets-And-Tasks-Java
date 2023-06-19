package N3_SNIPPETS;

public class MatrixDiagonals {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Main Diagonal:");
        printMainDiagonal(matrix);

        System.out.println("\nSecondary Diagonal:");
        printSecondaryDiagonal(matrix);
    }

    public static void printMainDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }

    public static void printSecondaryDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i + j == rows - 1) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
}
