import java.util.Arrays;

public class PerfectSquare_Q279 {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;

        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        PerfectSquare_Q279 solution = new PerfectSquare_Q279();

        // Test Case 1
        int n1 = 12;
        System.out.println("Test Case 1: " + (solution.numSquares(n1) == 3 ? "Passed" : "Failed"));

        // Test Case 2
        int n2 = 13;
        System.out.println("Test Case 2: " + (solution.numSquares(n2) == 2 ? "Passed" : "Failed"));

        // Test Case 3
        int n3 = 16;
        System.out.println("Test Case 3: " + (solution.numSquares(n3) == 1 ? "Passed" : "Failed"));
    }
}
