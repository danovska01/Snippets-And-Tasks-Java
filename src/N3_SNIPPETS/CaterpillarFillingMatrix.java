package N3_SNIPPETS;

import java.util.Scanner;

public class CaterpillarFillingMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Въведете брой редове (R): ");
        int R = scanner.nextInt();

        System.out.print("Въведете брой колони (C): ");
        int C = scanner.nextInt();

        int[][] matrix = new int[R][C];

        int count = 1;

        for (int col = 0; col < C; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < R; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            } else {
                for (int row = R - 1; row >= 0; row--) {
                    matrix[row][col] = count;
                    count++;
                }
            }
        }

        // Извеждане на матрицата
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
