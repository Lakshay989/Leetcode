import java.util.Arrays;

public class LargestLocalValuesInAMatrix_Q2373 {
    private int findMax(int[][] grid, int x, int y) {
        int maxElement = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                maxElement = Math.max(maxElement, grid[i][j]);
            }
        }

        return maxElement;
    }

    public int[][] largestLocal(int[][] grid) {
        int N = grid.length;

        int[][] maxLocal = new int[N - 2][N - 2];
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < N - 2; j++) {
                maxLocal[i][j] = findMax(grid, i, j);
            }
        }

        return maxLocal;
    }

    public static void main(String[] args) {
        LargestLocalValuesInAMatrix_Q2373 solution = new LargestLocalValuesInAMatrix_Q2373();

        // Test case 1
        int[][] grid1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] result1 = solution.largestLocal(grid1);
        System.out.println("Test Case 1 Result:");
        printMatrix(result1);
        // Expected output: {{11, 12}, {15, 16}}

        // Test case 2
        int[][] grid2 = {
                {5, 3, 9, 1},
                {4, 8, 2, 7},
                {6, 1, 4, 3},
                {9, 7, 5, 2}
        };
        int[][] result2 = solution.largestLocal(grid2);
        System.out.println("Test Case 2 Result:");
        printMatrix(result2);
        // Expected output: {{9, 9}, {9, 7}}

        // Add more test cases as needed
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
