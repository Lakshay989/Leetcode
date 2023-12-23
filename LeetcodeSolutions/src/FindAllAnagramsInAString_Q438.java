import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString_Q438 {
        public List<Integer> findAnagrams(String s, String p) {
            HashMap<Character, Integer> hashmap = new HashMap<>();
            HashMap<Character, Integer> hashmapS = new HashMap<>();
            ArrayList<Integer> result = new ArrayList<>();

            // Populate hashmap with characters from string p
            for (char ch : p.toCharArray()) {
                hashmap.put(ch, hashmap.getOrDefault(ch, 0) + 1);
            }

            int left = 0;
            int right = 0;
            int count = 0;
            int pLength = p.length();

            while (right < s.length()) {
                char ch = s.charAt(right);
                hashmapS.put(ch, hashmapS.getOrDefault(ch, 0) + 1);

                // Increment 'right' pointer to move the window
                right++;

                // Check if the window size is equal to the length of string p
                if (right - left == pLength) {
                    // Compare hashmaps to determine if an anagram exists
                    if (hashmap.equals(hashmapS)) {
                        result.add(left);
                    }

                    char leftChar = s.charAt(left);
                    if (hashmapS.containsKey(leftChar)) {
                        hashmapS.put(leftChar, hashmapS.get(leftChar) - 1);
                        if (hashmapS.get(leftChar) == 0) {
                            hashmapS.remove(leftChar);
                        }
                    }

                    // Increment 'left' pointer to slide the window
                    left++;
                }
            }

            return result;
        }
    public static void main(String[] args) {
        FindAllAnagramsInAString_Q438 solution = new FindAllAnagramsInAString_Q438();

        // Test Case 1: Basic case with an anagram present at the start
        String s1 = "cbaebabacd";
        String p1 = "abc";
        List<Integer> result1 = solution.findAnagrams(s1, p1);
        System.out.println("Test Case 1 Result: " + result1); // Expected output: [0, 6]

        // Test Case 2: No anagram present in the string
        String s2 = "hello";
        String p2 = "xyz";
        List<Integer> result2 = solution.findAnagrams(s2, p2);
        System.out.println("Test Case 2 Result: " + result2); // Expected output: []

        // Test Case 3: Anagram present multiple times in the string
        String s3 = "abab";
        String p3 = "ab";
        List<Integer> result3 = solution.findAnagrams(s3, p3);
        System.out.println("Test Case 3 Result: " + result3); // Expected output: [0, 1, 2]

        // Test Case 4: Anagram string is longer than the search string
        String s4 = "abc";
        String p4 = "abcd";
        List<Integer> result4 = solution.findAnagrams(s4, p4);
        System.out.println("Test Case 4 Result: " + result4); // Expected output: []

        // Test Case 5: Both strings are empty
        String s5 = "";
        String p5 = "";
        List<Integer> result5 = solution.findAnagrams(s5, p5);
        System.out.println("Test Case 5 Result: " + result5); // Expected output: [0]
    }
}
