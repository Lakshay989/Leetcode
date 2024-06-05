import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters_Q1002 {
    public List<String> commonChars(String[] words) {
        int[] last = count(words[0]);
        for (int i = 1; i < words.length; i++) {
            last = intersection(last, count(words[i]));
        }
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a';
                a += i;
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }

    int[] intersection(int[] a, int[] b) {
        int[] t = new int[26];
        for (int i = 0; i < 26; i++) {
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }

    int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) t[c - 'a']++;
        return t;
    }

    public static void main(String[] args) {
        FindCommonCharacters_Q1002 solution = new FindCommonCharacters_Q1002();

        // Test case 1: Example case
        String[] words1 = {"bella", "label", "roller"};
        List<String> expected1 = List.of("e", "l", "l");
        System.out.println("Test Case 1 Passed: " + solution.commonChars(words1).equals(expected1));

        // Test case 2: All words are the same
        String[] words2 = {"aaa", "aaa", "aaa"};
        List<String> expected2 = List.of("a", "a", "a");
        System.out.println("Test Case 2 Passed: " + solution.commonChars(words2).equals(expected2));

        // Test case 3: No common characters
        String[] words3 = {"abc", "def", "ghi"};
        List<String> expected3 = new ArrayList<>();
        System.out.println("Test Case 3 Passed: " + solution.commonChars(words3).equals(expected3));

        // Test case 4: Mixed characters with partial matches
        String[] words4 = {"cool", "lock", "cook"};
        List<String> expected4 = List.of("c", "o");
        System.out.println("Test Case 4 Passed: " + solution.commonChars(words4).equals(expected4));

        // Test case 5: Single character words
        String[] words5 = {"a", "b", "c"};
        List<String> expected5 = new ArrayList<>();
        System.out.println("Test Case 5 Passed: " + solution.commonChars(words5).equals(expected5));

        // Test case 6: Words with different lengths
        String[] words6 = {"abcd", "abc", "ab"};
        List<String> expected6 = List.of("a", "b");
        System.out.println("Test Case 6 Passed: " + solution.commonChars(words6).equals(expected6));
    }
}