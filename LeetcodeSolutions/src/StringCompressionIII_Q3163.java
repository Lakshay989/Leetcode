public class StringCompressionIII_Q3163 {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder() ;
        int i = 0 ;
        int count = 1;

        while (i < word.length() - 1) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                count++;
                if (count == 10) {
                    sb.append(9).append(word.charAt(i));
                    count = 1;
                }
            } else {
                sb.append(count).append(word.charAt(i));
                count = 1;
            }
            i++;
        }

        sb.append(count).append(word.charAt(i));
        return sb.toString() ;
    }
    public static void main(String[] args) {
        StringCompressionIII_Q3163 solution = new StringCompressionIII_Q3163();

        // Test Case 1: Basic test case
        String test1 = "aaabbbccc";
        System.out.println("Test Case 1: " + solution.compressedString(test1)); // Expected Output: "3a3b3c"

        // Test Case 2: String with more than 9 consecutive characters
        String test2 = "aaaaaaaaaaa";
        System.out.println("Test Case 2: " + solution.compressedString(test2)); // Expected Output: "9a2a"

        // Test Case 3: String with no consecutive characters
        String test3 = "abc";
        System.out.println("Test Case 3: " + solution.compressedString(test3)); // Expected Output: "1a1b1c"

        // Test Case 4: Mixed case with different lengths of consecutive characters
        String test4 = "aabbccccc";
        System.out.println("Test Case 4: " + solution.compressedString(test4)); // Expected Output: "2a2b5c"

        // Test Case 5: Edge case with a single character
        String test5 = "a";
        System.out.println("Test Case 5: " + solution.compressedString(test5)); // Expected Output: "1a"

        // Test Case 6: Edge case with two different characters
        String test6 = "ab";
        System.out.println("Test Case 6: " + solution.compressedString(test6)); // Expected Output: "1a1b"

        // Test Case 7: Edge case with two same characters
        String test7 = "aa";
        System.out.println("Test Case 7: " + solution.compressedString(test7)); // Expected Output: "2a"
    }
}
