package N5_TEST_TASKS_IT;

public class _S6_Chessboard {

    // Write a method that by given chessboard filled with figures on some squares,
    //coordinates of knight and king, finds whether the knight can reach the king. The knight can move only
    // on “Г”-shaped moves. The method must return true/false. The other figures are marked with 'X' on the board a
    // nd the empty squares are marked with ' '(space).

    public static void main(String[] args) {
        char[][] board = {
                {'X', ' ', ' ', 'X'},
                {' ', 'X', ' ', 'X'},
                {' ', ' ', 'K', 'X'},
                {'X', ' ', ' ', 'X'},
        };
        int knightRow = 1;
        int knightCol = 2;
        int kingRow = 2;
        int kingCol = 2;

        System.out.println(canKnightReachKing(board, knightRow, knightCol, kingRow, kingCol)); // Output: true
    }

    public static boolean canKnightReachKing(char[][] board, int knightRow, int knightCol, int kingRow, int kingCol) {
        // Check if the knight is in a valid position on the board
        if (!isValidPosition(board, knightRow, knightCol) || board[knightRow][knightCol] != ' ') {
            return false;
        }

        // Check if the knight can reach the king
        return canKnightReachKingRecursive(board, knightRow, knightCol, kingRow, kingCol);
    }

    private static boolean canKnightReachKingRecursive(char[][] board, int row, int col, int kingRow, int kingCol) {
        // Base case: If the knight reaches the king, return true
        if (row == kingRow && col == kingCol) {
            return true;
        }

        // Possible knight moves
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < dx.length; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            // Check if the new position is a valid position on the board and not occupied
            if (isValidPosition(board, newRow, newCol) && board[newRow][newCol] == ' ') {
                // Recursive call to check if the knight can reach the king from the new position
                if (canKnightReachKingRecursive(board, newRow, newCol, kingRow, kingCol)) {
                    return true;
                }
            }
        }

        return false; // Knight cannot reach the king
    }

    private static boolean isValidPosition(char[][] board, int row, int col) {
        int numRows = board.length;
        int numCols = board[0].length;

        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
}
