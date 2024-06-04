public class LongestPalindrome_Q409 {
    public int longestPalindrome(String s) {
        int[] array = new int[58];
        int count = 0,odd = 0;

        for(char each : s.toCharArray()){
            array[each - 'A']++;
        }

        for(int each : array){
            if(each % 2 == 0 && each != 0){
                count += each;
            }else if(each % 2 == 1 && each != 1){
                count += each -1;
                odd = 1;
            }else if(each == 1){
                odd = 1;
            }
        }
        return count + odd;
    }
    public static void main(String[] args) {
        LongestPalindrome_Q409 solution = new LongestPalindrome_Q409();

        // Test case 1: Example case
        String s1 = "abccccdd";
        int expected1 = 7;
        System.out.println("Test Case 1 Passed: " + (solution.longestPalindrome(s1) == expected1));

        // Test case 2: All characters the same
        String s2 = "aaaa";
        int expected2 = 4;
        System.out.println("Test Case 2 Passed: " + (solution.longestPalindrome(s2) == expected2));

        // Test case 3: Mixed characters with no palindrome
        String s3 = "abc";
        int expected3 = 1;
        System.out.println("Test Case 3 Passed: " + (solution.longestPalindrome(s3) == expected3));

        // Test case 4: Multiple odd counts
        String s4 = "aabbc";
        int expected4 = 5;
        System.out.println("Test Case 4 Passed: " + (solution.longestPalindrome(s4) == expected4));

        // Test case 5: Single character
        String s5 = "z";
        int expected5 = 1;
        System.out.println("Test Case 5 Passed: " + (solution.longestPalindrome(s5) == expected5));

        // Test case 6: Empty string
        String s6 = "";
        int expected6 = 0;
        System.out.println("Test Case 6 Passed: " + (solution.longestPalindrome(s6) == expected6));
    }
}
