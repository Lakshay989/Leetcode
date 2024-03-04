import java.util.Arrays;

public class BagOfTokens_Q948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        int low = 0;
        int high = tokens.length - 1;
        int score = 0;
        Arrays.sort(tokens);

        while (low <= high) {
            // When we have enough power, play lowest token face-up
            if (power >= tokens[low]) {
                score += 1;
                power -= tokens[low];
                low += 1;
                // We don't have enough power to play a token face-up
                // If there is at least one token remaining,
                // and we have enough score, play highest token face-down
            } else if (low < high && score > 0) {
                score -= 1;
                power += tokens[high];
                high -= 1;
                // We don't have enough score, power, or tokens
                // to play face-up or down and increase our score
            } else {
                return score;
            }
        }
        return score;
    }
    public static void main(String[] args) {
        BagOfTokens_Q948 solution = new BagOfTokens_Q948();

        // Test case 1
        int[] tokens1 = {100};
        int power1 = 50;
        int expected1 = 0;
        int result1 = solution.bagOfTokensScore(tokens1, power1);
            System.out.println("Test Case 1: " + (result1 == expected1));

        // Test case 2
        int[] tokens2 = {100, 200};
        int power2 = 150;
        int expected2 = 1;
        int result2 = solution.bagOfTokensScore(tokens2, power2);
            System.out.println("Test Case 2: " + (result2 == expected2));

        // Test case 3
        int[] tokens3 = {100, 200, 300, 400};
        int power3 = 200;
        int expected3 = 2;
        int result3 = solution.bagOfTokensScore(tokens3, power3);
            System.out.println("Test Case 3: " + (result3 == expected3));
    }
}
