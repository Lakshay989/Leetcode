public class ScoreOfAString_Q3110 {
    public int scoreOfString(String s) {
        int result = 0 ;
        for(int i = 0 ; i < s.length() - 1 ; i ++){
            result += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return result ;
    }
    public static void main(String[] args) {
        ScoreOfAString_Q3110 solution = new ScoreOfAString_Q3110();

        // Test case 1: Basic test with alternating characters
        String s1 = "abcd";
        int expected1 = Math.abs('a' - 'b') + Math.abs('b' - 'c') + Math.abs('c' - 'd');
        System.out.println("Test Case 1 Passed: " + (solution.scoreOfString(s1) == expected1));

        // Test case 2: Single character string
        String s2 = "a";
        int expected2 = 0; // No pairs to calculate the difference
        System.out.println("Test Case 2 Passed: " + (solution.scoreOfString(s2) == expected2));

        // Test case 3: Repeated characters
        String s3 = "aaa";
        int expected3 = 0; // Differences are zero
        System.out.println("Test Case 3 Passed: " + (solution.scoreOfString(s3) == expected3));

        // Test case 4: String with mix of letters
        String s4 = "azAZ";
        int expected4 = Math.abs('a' - 'z') + Math.abs('z' - 'A') + Math.abs('A' - 'Z');
        System.out.println("Test Case 4 Passed: " + (solution.scoreOfString(s4) == expected4));

        // Test case 5: String with increasing ASCII values
        String s5 = "aceg";
        int expected5 = Math.abs('a' - 'c') + Math.abs('c' - 'e') + Math.abs('e' - 'g');
        System.out.println("Test Case 5 Passed: " + (solution.scoreOfString(s5) == expected5));

        // Test case 6: String with special characters
        String s6 = "!@#";
        int expected6 = Math.abs('!' - '@') + Math.abs('@' - '#');
        System.out.println("Test Case 6 Passed: " + (solution.scoreOfString(s6) == expected6));
    }
}
