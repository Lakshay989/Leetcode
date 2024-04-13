import java.util.Arrays;

public class MaximalRectangle_Q85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n]; // initialize left as the leftmost boundary possible
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n); // initialize right as the rightmost boundary possible

        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // update height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }
            // update left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            // update area
            for (int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        MaximalRectangle_Q85 solution = new MaximalRectangle_Q85();

        // Test case 1
        char[][] matrix1 = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int result1 = solution.maximalRectangle(matrix1);
        System.out.println("Test case 1 result: " + result1);
        // Expected output: 6

        // Test case 2
        char[][] matrix2 = {
                {'0','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'}
        };
        int result2 = solution.maximalRectangle(matrix2);
        System.out.println("Test case 2 result: " + result2);
        // Expected output: 0

        // Test case 3
        char[][] matrix3 = {
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'}
        };
        int result3 = solution.maximalRectangle(matrix3);
        System.out.println("Test case 3 result: " + result3);
        // Expected output: 20
    }
}
