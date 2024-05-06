import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_Q994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = grid;
        Queue<int[]> q = new LinkedList<>();
        int countFreshOrange = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
                if (visited[i][j] == 1) {
                    countFreshOrange++;
                }
            }
        }
        if (countFreshOrange == 0)
            return 0;
        if (q.isEmpty())
            return -1;

        int minutes = -1;
        int[][] dirs = {{1, 0},{-1, 0},{0, -1},{0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                for (int[] dir : dirs) {
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == 1) {
                        visited[i][j] = 2;
                        countFreshOrange--;
                        q.offer(new int[] {i, j});
                    }
                }
            }
            minutes++;
        }

        if (countFreshOrange == 0)
            return minutes;
        return -1;
    }

    public static void main(String[] args) {
        RottingOranges_Q994 rotter = new RottingOranges_Q994();

        // Test case 1: grid with no fresh oranges
        int[][] grid1 = {
                {2, 0, 2},
                {0, 2, 2},
                {2, 2, 2}
        };
        System.out.println("Test Case 1: " + rotter.orangesRotting(grid1)); // Expected output: 0

        // Test case 2: grid with no rotten oranges
        int[][] grid2 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println("Test Case 2: " + rotter.orangesRotting(grid2)); // Expected output: -1

        // Test case 3: grid with both fresh and rotten oranges
        int[][] grid3 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("Test Case 3: " + rotter.orangesRotting(grid3)); // Expected output: 4
    }
}
