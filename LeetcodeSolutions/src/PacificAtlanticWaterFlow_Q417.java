import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow_Q417 {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        if (heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>() ;

        int m = heights.length ;
        int n = heights[0].length ;

        int[][] landHeights = heights;

        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];

        // Loop through each cell adjacent to the oceans and start a DFS
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacificReachable, landHeights);
            dfs(i, n - 1, atlanticReachable, landHeights);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, pacificReachable, landHeights);
            dfs(m - 1, i, atlanticReachable, landHeights);
        }

        // Find all cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, boolean[][] reachable, int[][] landHeights) {
        // This cell is reachable, so mark it
        reachable[row][col] = true;
        for (int[] dir : DIRECTIONS) { // Check all 4 directions
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // Check if new cell is within bounds
            if (newRow < 0 || newRow >= reachable.length || newCol < 0 || newCol >= reachable[0].length) {
                continue;
            }
            // Check that the new cell hasn't already been visited
            if (reachable[newRow][newCol]) {
                continue;
            }
            // Check that the new cell has a higher or equal height,
            // So that water can flow from the new cell to the old cell
            if (landHeights[newRow][newCol] < landHeights[row][col]) {
                continue;
            }
            // If we've gotten this far, that means the new cell is reachable
            dfs(newRow, newCol, reachable, landHeights);
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow_Q417 solution = new PacificAtlanticWaterFlow_Q417();

        // Test case 1
        int[][] heights1 = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> result1 = solution.pacificAtlantic(heights1);
        System.out.println("Test case 1: " + result1); // Expected output: [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]

        // Test case 2
        int[][] heights2 = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        List<List<Integer>> result2 = solution.pacificAtlantic(heights2);
        System.out.println("Test case 2: " + result2); // Expected output: [[0, 2], [1, 0], [1, 1], [1, 2], [2, 0], [2, 1], [2, 2]]

        // Test case 3: Empty heights array
        int[][] heights3 = {};
        List<List<Integer>> result3 = solution.pacificAtlantic(heights3);
        System.out.println("Test case 3: " + result3); // Expected output: []

        // Test case 4: Single row
        int[][] heights4 = {{1, 2, 3}};
        List<List<Integer>> result4 = solution.pacificAtlantic(heights4);
        System.out.println("Test case 4: " + result4); // Expected output: [[0, 2]]

        // Test case 5: Single column
        int[][] heights5 = {{1}, {2}, {3}};
        List<List<Integer>> result5 = solution.pacificAtlantic(heights5);
        System.out.println("Test case 5: " + result5); // Expected output: [[2, 0]]

        // Add more test cases as needed
    }
}
