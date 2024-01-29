public class NumberOfChangingKeys_Q3019 {
    public int countKeyChanges(String s) {
        s = s.toLowerCase() ;

        int count = 0 ;

        for( int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i-1) != s.charAt(i)){
                count ++ ;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfChangingKeys_Q3019 solution = new NumberOfChangingKeys_Q3019();

        // Test Case 1
        String input1 = "aAbBcC";
        int output1 = solution.countKeyChanges(input1);
        System.out.println("Test Case 1: " + (output1 == 2 ? "Passed" : "Failed"));

        // Test Case 2
        String input2 = "AaAaAaaA";
        int output2 = solution.countKeyChanges(input2);
        System.out.println("Test Case 2: " + (output2 == 0 ? "Passed" : "Failed"));

        // Additional Test Case 3
        String input3 = "abcd";
        int output3 = solution.countKeyChanges(input3);
        System.out.println("Test Case 3: " + (output3 == 3 ? "Passed" : "Failed"));
    }
}
