package N3_SNIPPETS;



public class matrixTheNumberWithLargerstOccurence {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {1, 2, 3},
                {4, 4, 4}
        };

        int mostFrequentNumber = findMostFrequentNumber(matrix);
        System.out.println("Най-често срещаното число е: " + mostFrequentNumber);
    }

    public static int findMostFrequentNumber(int[][] matrix) {
        int maxCount = 0;
        int mostFrequentNumber = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int currentNumber = matrix[i][j];
                int count = 0;

                for (int k = 0; k < matrix.length; k++) {
                    for (int l = 0; l < matrix[k].length; l++) {
                        if (matrix[k][l] == currentNumber) {
                            count++;
                        }
                    }
                }

                if (count > maxCount) {
                    maxCount = count;
                    mostFrequentNumber = currentNumber;
                }
            }
        }

        return mostFrequentNumber;
    }
}

