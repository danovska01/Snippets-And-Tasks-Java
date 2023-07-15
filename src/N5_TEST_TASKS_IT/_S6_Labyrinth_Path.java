package N5_TEST_TASKS_IT;

// Write a method that finds whether there is path between two given cells in 2D labyrinth.
// The method takes 5 parameters – the coordinates of the two cells and the labyrinth itself.
// The labyrinth has walls marked with symbol 'W', that you cannot pass through.
// The other cells are marked with ' '. The method must return true or false depending on whether there is a path between start and end cells.

public class _S6_Labyrinth_Path {
    public static boolean hasPath(int startRow, int startCol, int endRow, int endCol, char[][] labyrinth) {
        int rows = labyrinth.length;
        int cols = labyrinth[0].length;
        boolean[][] visited = new boolean[rows][cols];

        return dfs(startRow, startCol, endRow, endCol, labyrinth, visited);
    }

    private static boolean dfs(int row, int col, int endRow, int endCol, char[][] labyrinth, boolean[][] visited) {
        int rows = labyrinth.length;
        int cols = labyrinth[0].length;

        // Check if current cell is out of bounds or a wall
        if (row < 0 || row >= rows || col < 0 || col >= cols || labyrinth[row][col] == 'W') {
            return false;
        }

        // Check if reached the end cell
        if (row == endRow && col == endCol) {
            return true;
        }

        // Mark current cell as visited
        visited[row][col] = true;

        // Explore neighboring cells
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            // Check if the neighbor is not visited
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                if (dfs(newRow, newCol, endRow, endCol, labyrinth, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] labyrinth = {
                {' ', ' ', 'W', 'W', 'W'},
                {'W', ' ', ' ', ' ', 'W'},
                {'W', 'W', 'W', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' '},
                {'W', 'W', 'W', 'W', ' '}
        };

        int startRow = 0;
        int startCol = 0;
        int endRow = 4;
        int endCol = 4;

        boolean hasPath = hasPath(startRow, startCol, endRow, endCol, labyrinth);
        System.out.println("Path exists: " + hasPath);
    }
}
