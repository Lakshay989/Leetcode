import java.util.HashMap;
import java.util.Map;

public class MinimumLengthOfAnagramConcatenation_Q3138 {
    public int minAnagramLength(String s) {

        int n = s.length() ;
        Map<Character, Integer> lookup = new HashMap<>() ;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            lookup.put(ch, lookup.getOrDefault(ch,0) + 1);
        }

        for (int t_length = 1; t_length <= n ; t_length++) {
            if (n % t_length == 0) {
                boolean valid = true;
                int segmentLength = n / t_length;

                // Check if frequencies are divisible by segmentLength
                for (int freq : lookup.values()) {
                    if (freq % segmentLength != 0) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    return t_length;
                }
            }
        }

        return n;
    }

    public static void main(String[] args) {
        MinimumLengthOfAnagramConcatenation_Q3138 solver = new MinimumLengthOfAnagramConcatenation_Q3138();

        // Test case 1: Anagram exists with single character
        String s1 = "aabb";
        System.out.println("Test case 1:");
        System.out.println("Minimum length of anagram concatenation: " + solver.minAnagramLength(s1));

        // Test case 2: Anagram exists with multiple characters
        String s2 = "abcabcabc";
        System.out.println("\nTest case 2:");
        System.out.println("Minimum length of anagram concatenation: " + solver.minAnagramLength(s2));

        // Test case 3: No anagram exists
        String s3 = "abcd";
        System.out.println("\nTest case 3:");
        System.out.println("Minimum length of anagram concatenation: " + solver.minAnagramLength(s3));

        // Test case 4: Empty string
        String s4 = "";
        System.out.println("\nTest case 4:");
        System.out.println("Minimum length of anagram concatenation: " + solver.minAnagramLength(s4));
    }
}
