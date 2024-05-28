public class GetEqualSubStringsWithinBudget_Q1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int N = s.length();

        int maxLen = 0;
        int start = 0;
        int currCost = 0;

        for (int i = 0; i < N; i++) {
            currCost += Math.abs(s.charAt(i) - t.charAt(i));
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        GetEqualSubStringsWithinBudget_Q1208 solution = new GetEqualSubStringsWithinBudget_Q1208();

        // Test case 1: Basic test case
        String s1 = "abcd";
        String t1 = "bcdf";
        int maxCost1 = 3;
        System.out.println("Test Case 1: " + solution.equalSubstring(s1, t1, maxCost1)); // Expected Output: 3

        // Test case 2: No cost constraint
        String s2 = "abcd";
        String t2 = "cdef";
        int maxCost2 = 0;
        System.out.println("Test Case 2: " + solution.equalSubstring(s2, t2, maxCost2)); // Expected Output: 1

        // Test case 3: All characters can be changed within budget
        String s3 = "abcd";
        String t3 = "abcd";
        int maxCost3 = 10;
        System.out.println("Test Case 3: " + solution.equalSubstring(s3, t3, maxCost3)); // Expected Output: 4

        // Test case 4: Some characters can be changed within budget
        String s4 = "abcd";
        String t4 = "abcf";
        int maxCost4 = 1;
        System.out.println("Test Case 4: " + solution.equalSubstring(s4, t4, maxCost4)); // Expected Output: 3

        // Test case 5: Maximum length with variable cost
        String s5 = "krrgw";
        String t5 = "zjxss";
        int maxCost5 = 19;
        System.out.println("Test Case 5: " + solution.equalSubstring(s5, t5, maxCost5)); // Expected Output: 2

        // Test case 6: Cost is exactly enough for whole string
        String s6 = "abcd";
        String t6 = "bcda";
        int maxCost6 = 4;
        System.out.println("Test Case 6: " + solution.equalSubstring(s6, t6, maxCost6)); // Expected Output: 4

        // Test case 7: Edge case with single character
        String s7 = "a";
        String t7 = "b";
        int maxCost7 = 1;
        System.out.println("Test Case 7: " + solution.equalSubstring(s7, t7, maxCost7)); // Expected Output: 1

        // Test case 8: Edge case with single character and insufficient budget
        String s8 = "a";
        String t8 = "b";
        int maxCost8 = 0;
        System.out.println("Test Case 8: " + solution.equalSubstring(s8, t8, maxCost8)); // Expected Output: 0
    }
}
