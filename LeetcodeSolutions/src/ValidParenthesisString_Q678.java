public class ValidParenthesisString_Q678 {
    public boolean checkValidString(String s) {
        int openCount = 0;
        int closeCount = 0;
        int length = s.length() - 1;

        // Traverse the string from both ends simultaneously
        for (int i = 0; i <= length; i++) {
            // Count open parentheses or asterisks
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                openCount++;
            } else {
                openCount--;
            }

            // Count close parentheses or asterisks
            if (s.charAt(length - i) == ')' || s.charAt(length - i) == '*') {
                closeCount++;
            } else {
                closeCount--;
            }

            // If at any point open count or close count goes negative, the string is invalid
            if (openCount < 0 || closeCount < 0) {
                return false;
            }
        }

        // If open count and close count are both non-negative, the string is valid
        return true;
    }

    public static void main(String[] args) {
        ValidParenthesisString_Q678 solution = new ValidParenthesisString_Q678();

        // Test case 1
        String s1 = "()";
        boolean result1 = solution.checkValidString(s1);
        System.out.println("Test case 1 result: " + result1); // Expected output: true

        // Test case 2
        String s2 = "(*)";
        boolean result2 = solution.checkValidString(s2);
        System.out.println("Test case 2 result: " + result2); // Expected output: true

        // Test case 3
        String s3 = "(*))";
        boolean result3 = solution.checkValidString(s3);
        System.out.println("Test case 3 result: " + result3); // Expected output: true

        // Test case 4
        String s4 = "((*)";
        boolean result4 = solution.checkValidString(s4);
        System.out.println("Test case 4 result: " + result4); // Expected output: true

        // Test case 5
        String s5 = "())";
        boolean result5 = solution.checkValidString(s5);
        System.out.println("Test case 5 result: " + result5); // Expected output: false
    }
}
