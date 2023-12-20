import java.util.HashMap;

public class MinimumWindowSubstring_Q76 {
    public String minWindow(String s, String t) {

        if (t.length() == 0 ) return "";

        HashMap<Character, Integer> countT = new HashMap<>();
        HashMap<Character, Integer> minWindow = new HashMap<>();

        String result = "" ;
        float resLength = Integer.MAX_VALUE;
        int l = 0 ;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0 ; // Conditions we have which are satisfied.
        int need = t.length() ; // Total conditions

        for (int r = 0 ; r < s.length(); r ++){
            char c = s.charAt(r) ;
            minWindow.put(c , minWindow.getOrDefault(c,0) + 1) ;
            if (countT.containsKey(c) && minWindow.get(c) <= countT.get(c)){
                have += 1 ;
            }

            while (have == need){
                if ((r - l + 1) < resLength){
                    result = s.substring(l, r + 1);
                    resLength = r- l + 1;
                }

                char charToBeRemoved = s.charAt(l) ;
                minWindow.put(charToBeRemoved, minWindow.get(charToBeRemoved) - 1) ;

                if (countT.containsKey(charToBeRemoved) && minWindow.get(charToBeRemoved) < countT.get(charToBeRemoved)){
                    have -= 1 ;
                }

                l += 1 ;
            }
        }
        // result = s.substring(l, r + 1) ;

        if (resLength == Integer.MAX_VALUE) {
            return "";
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring_Q76 solution = new MinimumWindowSubstring_Q76();

        // Test cases
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Test Case 1: " + solution.minWindow(s1, t1)); // Expected Output: "BANC"

        String s2 = "this is a test string";
        String t2 = "tist";
        System.out.println("Test Case 2: " + solution.minWindow(s2, t2)); // Expected Output: "t stri"

        String s3 = "ab";
        String t3 = "b";
        System.out.println("Test Case 3: " + solution.minWindow(s3, t3)); // Expected Output: "b"

        String s4 = "a";
        String t4 = "a";
        System.out.println("Test Case 4: " + solution.minWindow(s4, t4)); // Expected Output: "a"

        String s5 = "aa";
        String t5 = "aa";
        System.out.println("Test Case 5: " + solution.minWindow(s5, t5)); // Expected Output: "aa"
    }
}
