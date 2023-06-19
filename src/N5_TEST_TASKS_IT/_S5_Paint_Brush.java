package N5_TEST_TASKS_IT;

public class _S5_Paint_Brush {

    //Write a method that represents the operation “paint brush” in Paint. The
    // method takes a matrix of pixels N*N and the coordinates of a single pixel of the matrix
    //as parameters. We know that the matrix contains areas, surrounded by black pixels
    //(cells that contain the letter 'b'). The method then paints the whole area around the
    //pixel that is surrounded by black pixels or that ends with the border of the matrix.
    //Painting the area means setting all pixels to red (the letter 'r').

    public static void paintArea(char[][] matrix, int row, int col) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        // Check if the given coordinates are within the matrix bounds
        if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
            return;
        }

        // Check if the current pixel is already painted or is a black pixel
        if (matrix[row][col] == 'r' || matrix[row][col] == 'b') {
            return;
        }

        // Paint the current pixel
        matrix[row][col] = 'r';

        // Recursively paint the neighboring pixels
        paintArea(matrix, row - 1, col); // Up
        paintArea(matrix, row + 1, col); // Down
        paintArea(matrix, row, col - 1); // Left
        paintArea(matrix, row, col + 1); // Right
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'b', 'b', 'b', 'b', 'b'},
                {'b', 'w', 'w', 'w', 'b'},
                {'b', 'w', 'b', 'w', 'b'},
                {'b', 'w', 'w', 'w', 'b'},
                {'b', 'b', 'b', 'b', 'b'}
        };

        int row = 2;
        int col = 2;

        paintArea(matrix, row, col);

        // Print the updated matrix
        for (char[] rowArr : matrix) {
            for (char pixel : rowArr) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
