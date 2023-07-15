package N5_TEST_TASKS_IT;

import java.util.LinkedList;
import java.util.Queue;

// Write a method that by given 2D labyrinth represented as matrix filled with 'W' for walls and ' ' (space) for empty cell,
// returns the number of steps to exit the labyrinth. You cannot pass through walls and you can move only up, down, left or right.
// If there is no way to escape the labyrinth, then -1 should be returned as a result.

public class _S6_Labyrinth_Escape {
    public static int findStepsToExit(char[][] labyrinth) {
        int rows = labyrinth.length;
        int cols = labyrinth[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Define directions: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Starting position
        int startX = 0;
        int startY = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] currentPos = queue.poll();
            int x = currentPos[0];
            int y = currentPos[1];
            int steps = currentPos[2];

            // Check if reached the exit
            if (x == rows - 1 && y == cols - 1) {
                return steps;
            }

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // Check if the neighbor is within bounds and not a wall
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && labyrinth[newX][newY] == ' ' && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY, steps + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        // No way to escape the labyrinth
        return -1;
    }

    public static void main(String[] args) {
        char[][] labyrinth = {
                {' ', ' ', 'W', 'W', 'W'},
                {'W', ' ', ' ', ' ', 'W'},
                {'W', 'W', 'W', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' '},
                {'W', 'W', 'W', 'W', ' '}
        };

        int steps = findStepsToExit(labyrinth);
        System.out.println("Number of steps to exit: " + steps);
    }
}
