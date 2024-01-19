public class MinimumFallingPathSum_Q931 {
    public int minFallingPathSum(int[][] A) {
        int dp[][] = new int[A.length][A.length];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++)
        {
            dp[0][i] = A[0][i];
        }
        for(int i = 1; i < A.length; i++)
        {
            for(int j = 0; j < A.length; j++)
            {
                if(j == 0)
                {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else if(j == A.length - 1)
                {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                }
                else
                {
                    dp[i][j] = A[i][j] + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]);
                }
            }
        }
        for(int i = 0; i < A.length; i++)
        {
            if(dp[A.length-1][i] < min)  min = dp[A.length-1][i];
        }
        return min;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] A1 = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        test(A1);

        // Test Case 2
        int[][] A2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        test(A2);

        // Test Case 3
        int[][] A3 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        test(A3);
    }

    private static void test(int[][] A) {
        MinimumFallingPathSum_Q931 solution = new MinimumFallingPathSum_Q931();
        int result = solution.minFallingPathSum(A);

        // Display the result for each test case
        System.out.println("Minimum Falling Path Sum: " + result);
    }
}
