public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating_Q1888 {
    public static int minFlips(String s) {
        int n = s.length();
        s = s + s;
        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            alt1.append(i % 2 == 0 ? "0" : "1");
            alt2.append(i % 2 == 0 ? "1" : "0");
        }

        int res = Integer.MAX_VALUE;
        int diff1 = 0, diff2 = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) != alt1.charAt(r)) {
                diff1++;
            }
            if (s.charAt(r) != alt2.charAt(r)) {
                diff2++;
            }
            if ((r - l + 1) > n) {
                if (s.charAt(l) != alt1.charAt(l)) {
                    diff1--;
                }
                if (s.charAt(l) != alt2.charAt(l)) {
                    diff2--;
                }
                l++;
            }
            if ((r - l + 1) == n) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }
        return res;
    }

    // Test cases
    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
                "10111", // Expected output: 1
                "101",   // Expected output: 0
                "00000"  // Expected output: 2
        };

        for (String testCase : testCases) {
            int result = minFlips(testCase);
            System.out.println("For string " + testCase + ", minimum flips required: " + result);
        }
    }
}
