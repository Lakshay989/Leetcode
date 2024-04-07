public class LexicographicallySmallestStringAfterOperationsWithConstraint_Q3106 {
    public String getSmallestString(String s, int k) {
        char[] sArray = s.toCharArray();
        int n = sArray.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                char newChar = (char) ('a' + j);
                int distance = Math.min(minDistance(sArray[i], newChar), minDistance(newChar, sArray[i]));
                if (distance <= k) {
                    sArray[i] = newChar;
                    k -= distance;
                    break;
                }
            }
        }

        return new String(sArray);
    }
    public int minDistance(char c1, char c2) {
        return Math.min(Math.abs(c1 - c2), 26 - Math.abs(c1 - c2));
    }

    public static void main(String[] args) {
        LexicographicallySmallestStringAfterOperationsWithConstraint_Q3106 solution = new LexicographicallySmallestStringAfterOperationsWithConstraint_Q3106();

        // Test case 1
        String s1 = "leet";
        int k1 = 3;
        String result1 = solution.getSmallestString(s1, k1);
        System.out.println("Test case 1 result: " + result1); // Expected output: "aaa"

        // Test case 2
        String s2 = "abcdef";
        int k2 = 3;
        String result2 = solution.getSmallestString(s2, k2);
        System.out.println("Test case 2 result: " + result2); // Expected output: "aabdef"

        // Test case 3
        String s3 = "abczdefghijklmnopqrstuvwxy";
        int k3 = 80;
        String result3 = solution.getSmallestString(s3, k3);
        System.out.println("Test case 3 result: " + result3); // Expected output: "aaaaaaaaaaaaaamopqrstuvwxy"

        // Test case 4
        String s4 = "xyz";
        int k4 = 17;
        String result4 = solution.getSmallestString(s4, k4);
        System.out.println("Test case 4 result: " + result4); // Expected output: "aab"

        // Test case 5
        String s5 = "bbb";
        int k5 = 10;
        String result5 = solution.getSmallestString(s5, k5);
        System.out.println("Test case 5 result: " + result5); // Expected output: "aaa"
    }
}
