import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_Q3 {
    public int lengthOfLongestSubstring(String s)
    {
        int maxLength = 0;
        int n = s.length();
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int l = 0 ;
        for (int r = 0; r < n; r++) {
            if (hashmap.containsKey(s.charAt(r))) {
                l = Math.max(hashmap.get(s.charAt(r)) + 1, l);
            }
            hashmap.put(s.charAt(r), r);
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_Q3 solution = new LongestSubstringWithoutRepeatingCharacters_Q3();

        // Test cases
        String testCase1 = "abcdef";
        System.out.println("Length of longest substring in 'abcdef': " + solution.lengthOfLongestSubstring(testCase1));

        String testCase2 = "aaaaaa";
        System.out.println("Length of longest substring in 'aaaaaa': " + solution.lengthOfLongestSubstring(testCase2));

        String testCase3 = "";
        System.out.println("Length of longest substring in '': " + solution.lengthOfLongestSubstring(testCase3));

        String testCase4 = "x";
        System.out.println("Length of longest substring in 'x': " + solution.lengthOfLongestSubstring(testCase4));

        String testCase5 = "abcabcbb";
        System.out.println("Length of longest substring in 'abcabcbb': " + solution.lengthOfLongestSubstring(testCase5));

        String testCase6 = "pwwkew";
        System.out.println("Length of longest substring in 'pwwkew': " + solution.lengthOfLongestSubstring(testCase6));
    }
}

