public class MinimumTimeToRevertWordToInitialStateII_Q3031 {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length(), v = 0, dp[] = new int[n];
        for (int i = 1; i < n; i++) { // kmp
            while (v > 0 && word.charAt(i) != word.charAt(v)) {
                v = dp[v - 1];
            }
            v = dp[i] = v + (word.charAt(i) == word.charAt(v) ? 1 : 0);
        }
        while (v > 0 && (n - v) % k > 0) {
            v = dp[v - 1];
        }
        return (n - v + k - 1) / k;
    }
    public static void main(String[] args) {
        MinimumTimeToRevertWordToInitialStateII_Q3031 solution = new MinimumTimeToRevertWordToInitialStateII_Q3031();

        // Test Case 1
        String word1 = "abab";
        int k1 = 2;
        int result1 = solution.minimumTimeToInitialState(word1, k1);
        System.out.println("Test Case 1: " + (result1 == 1 ? "Passed" : "Failed"));

        // Test Case 2
        String word2 = "ababa";
        int k2 = 2;
        int result2 = solution.minimumTimeToInitialState(word2, k2);
        System.out.println("Test Case 2: " + (result2 == 1 ? "Passed" : "Failed"));

        // Test Case 3
        String word3 = "abcabc";
        int k3 = 3;
        int result3 = solution.minimumTimeToInitialState(word3, k3);
        System.out.println("Test Case 3: " + (result3 == 1 ? "Passed" : "Failed"));

        // Additional Test Case 4
        String word4 = "aaaaa";
        int k4 = 2;
        int result4 = solution.minimumTimeToInitialState(word4, k4);
        System.out.println("Test Case 4: " + (result4 == 1 ? "Passed" : "Failed"));
    }
}
