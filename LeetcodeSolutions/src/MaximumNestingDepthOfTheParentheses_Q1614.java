public class MaximumNestingDepthOfTheParentheses_Q1614 {
    public int maxDepth(String s) {
        int depth = 0 ;
        int max = 0 ;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                depth ++;
            }
            if(s.charAt(i) == ')'){
                depth -- ;
            }
            max = Math.max(depth, max);
        }
        return max ;
    }
    public static void main(String[] args) {
        MaximumNestingDepthOfTheParentheses_Q1614 solution = new MaximumNestingDepthOfTheParentheses_Q1614();

        // Test case 1
        String s1 = "(1+(2*3)+((8)/4))+1";
        int result1 = solution.maxDepth(s1);
        System.out.println("Test case 1 result: " + result1); // Expected output: 3

        // Test case 2
        String s2 = "(1)+((2))+(((3)))";
        int result2 = solution.maxDepth(s2);
        System.out.println("Test case 2 result: " + result2); // Expected output: 3

        // Test case 3
        String s3 = "1+(2*3)/(2-1)";
        int result3 = solution.maxDepth(s3);
        System.out.println("Test case 3 result: " + result3); // Expected output: 1
    }
}
