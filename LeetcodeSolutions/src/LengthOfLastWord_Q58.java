public class LengthOfLastWord_Q58 {
    public int lengthOfLastWord(String s) {
        int count = 0 ;
        s = s.trim() ;
        for(int i = s.length() - 1 ; i>=0 ; i--){
            if(s.charAt(i) == ' ')
                break ;
            count++ ;
        }
        return count ;
    }

    public static void main(String[] args) {
        LengthOfLastWord_Q58 solution = new LengthOfLastWord_Q58();

        // Test Case 1: General case
        String s1 = "Hello World";
        int expected1 = 5;
        System.out.println("Test Case 1: " + (solution.lengthOfLastWord(s1) == expected1 ? "Check" : "Error"));

        // Test Case 2: Empty string
        String s2 = "";
        int expected2 = 0;
        System.out.println("Test Case 2: " + (solution.lengthOfLastWord(s2) == expected2 ? "Check" : "Error"));

        // Test Case 3: String with trailing spaces
        String s3 = "   Hello World   ";
        int expected3 = 5;
        System.out.println("Test Case 3: " + (solution.lengthOfLastWord(s3) == expected3 ? "Check" : "Error"));

        // Test Case 4: String with only spaces
        String s4 = "    ";
        int expected4 = 0;
        System.out.println("Test Case 4: " + (solution.lengthOfLastWord(s4) == expected4 ? "Check" : "Error"));

        // Test Case 5: String with single word
        String s5 = "Hello";
        int expected5 = 5;
        System.out.println("Test Case 5: " + (solution.lengthOfLastWord(s5) == expected5 ? "Check" : "Error"));
    }
}
