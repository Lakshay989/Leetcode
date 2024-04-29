import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithAtMostTwoDistinctCharacters_Q159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Set<Character> set = new HashSet();
        int len = 0, left = 0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            set.add(c);
            if(set.size()>2){
                left = i - 1;
                while(left>=0 && s.charAt(left)==s.charAt(left-1)){
                    --left;
                }
                set.remove(s.charAt(left-1));
            }
            len = Math.max(len, i-left+1);
        }

        return len;
    }
    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctCharacters_Q159 solver = new LongestSubstringWithAtMostTwoDistinctCharacters_Q159();

        // Test case 1: String with all distinct characters
        String s1 = "abc";
        int result1 = solver.lengthOfLongestSubstringTwoDistinct(s1);
        System.out.println("Result for s1: " + result1); // Expected output: 3

        // Test case 2: String with two distinct characters
        String s2 = "ccaabbb";
        int result2 = solver.lengthOfLongestSubstringTwoDistinct(s2);
        System.out.println("Result for s2: " + result2); // Expected output: 5

        // Test case 3: String with more than two distinct characters
        String s3 = "eceba";
        int result3 = solver.lengthOfLongestSubstringTwoDistinct(s3);
        System.out.println("Result for s3: " + result3); // Expected output: 3
    }
}
