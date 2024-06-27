import java.util.HashMap;

public class WordPattern_Q290 {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map_char = new HashMap();
        HashMap <String, Character> map_word = new HashMap();
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (!map_char.containsKey(c)) {
                if (map_word.containsKey(w)) {
                    return false;
                } else {
                    map_char.put(c, w);
                    map_word.put(w, c);
                }

            } else {
                String mapped_word = map_char.get(c);
                if (!mapped_word.equals(w))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern_Q290 solution = new WordPattern_Q290();

        // Test 1: Basic match
        String pattern1 = "abba";
        String str1 = "dog cat cat dog";
        System.out.println(solution.wordPattern(pattern1, str1)); // true

        // Test 2: Basic non-match
        String pattern2 = "abba";
        String str2 = "dog cat cat fish";
        System.out.println(solution.wordPattern(pattern2, str2)); // false

        // Test 3: Different pattern length
        String pattern3 = "aaaa";
        String str3 = "dog cat cat dog";
        System.out.println(solution.wordPattern(pattern3, str3)); // false

        // Test 4: Non-matching pattern and string lengths
        String pattern4 = "abc";
        String str4 = "dog cat cat";
        System.out.println(solution.wordPattern(pattern4, str4)); // false

        // Test 5: Single character pattern and single word string
        String pattern5 = "a";
        String str5 = "dog";
        System.out.println(solution.wordPattern(pattern5, str5)); // true

        // Test 6: Single character pattern and multiple word string
        String pattern6 = "a";
        String str6 = "dog dog";
        System.out.println(solution.wordPattern(pattern6, str6)); // false

        // Test 7: Longer pattern and matching string
        String pattern7 = "abcabc";
        String str7 = "dog cat fish dog cat fish";
        System.out.println(solution.wordPattern(pattern7, str7)); // true

        // Test 8: Pattern with same characters and string with same words
        String pattern8 = "aaaa";
        String str8 = "dog dog dog dog";
        System.out.println(solution.wordPattern(pattern8, str8)); // true

        // Test 9: Pattern with repeating characters and string with non-repeating words
        String pattern9 = "aabb";
        String str9 = "dog dog cat cat";
        System.out.println(solution.wordPattern(pattern9, str9)); // true

        // Test 10: Empty pattern and empty string
        String pattern10 = "";
        String str10 = "";
        System.out.println(solution.wordPattern(pattern10, str10)); // false
    }
}
