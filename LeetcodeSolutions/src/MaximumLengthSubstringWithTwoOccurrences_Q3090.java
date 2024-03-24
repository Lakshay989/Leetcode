import java.util.HashMap;

public class MaximumLengthSubstringWithTwoOccurrences_Q3090 {
    public int maximumLengthSubstring(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> charCount = new HashMap<>();
            int length = 0;

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);

                // If a character's count exceeds 2, break the loop
                if (charCount.get(c) > 2) {
                    break;
                }
                // Update length with the current substring length
                length = j - i + 1;
                // Update maxLength if length is greater
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        MaximumLengthSubstringWithTwoOccurrences_Q3090 solution = new MaximumLengthSubstringWithTwoOccurrences_Q3090();

        // Test cases
        String s1 = "abcabcbb";
        System.out.println("Maximum length substring in '" + s1 + "': " + solution.maximumLengthSubstring(s1));

        String s2 = "bbbbb";
        System.out.println("Maximum length substring in '" + s2 + "': " + solution.maximumLengthSubstring(s2));

        String s3 = "pwwkew";
        System.out.println("Maximum length substring in '" + s3 + "': " + solution.maximumLengthSubstring(s3));
    }
}
