package N3_SNIPPETS;

public class MaxSum2X2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int sum = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1];
                if (sum > maxSum) {
                    maxSum = sum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Максималната подматрица 2x2 се намира в горния ляв ъгъл на индекси [" + maxRow + "][" + maxCol + "]");
        System.out.println("Елементите на подматрицата са:");
        System.out.println(matrix[maxRow][maxCol] + " " + matrix[maxRow][maxCol+1]);
        System.out.println(matrix[maxRow+1][maxCol] + " " + matrix[maxRow+1][maxCol+1]);
    }
}
