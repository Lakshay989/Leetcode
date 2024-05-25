import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII_Q140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>() ;
        List<String> current = new ArrayList<>() ;
        backtrack(0, result, current, s, wordDict);
        return result ;
    }

    public void backtrack(int index, List<String> result, List<String> current, String s, List<String> wordDict){
        if(index == s.length()){
            StringBuilder temp = new StringBuilder() ;
            for(int i = 0 ; i < current.size() - 1 ; i++){
                temp.append(current.get(i)) ;
                temp.append(" ");
            }
            temp.append(current.get(current.size() - 1));
            result.add(temp.toString());
            return ;
        }

        for(int i = index ; i< s.length() ; i ++){
            String word = s.substring(index, i+1) ;
            if(wordDict.contains(word)){
                current.add(word) ;
                backtrack(i + 1, result, current, s, wordDict);
                current.remove(current.size() - 1) ;
            }
        }
    }

    public static void main(String[] args) {
        WordBreakII_Q140 solution = new WordBreakII_Q140();

        // Test Case 1: Basic case with multiple word breaks
        String s1 = "catsanddog";
        List<String> wordDict1 = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> result1 = solution.wordBreak(s1, wordDict1);
        System.out.println("Test Case 1: " + result1); // Expected Output: ["cats and dog", "cat sand dog"]

        // Test Case 2: Single possible word break
        String s2 = "pineapplepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> result2 = solution.wordBreak(s2, wordDict2);
        System.out.println("Test Case 2: " + result2); // Expected Output: ["pine apple pen apple", "pineapple pen apple", "pine applepen apple"]

        // Test Case 3: No possible word break
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        List<String> result3 = solution.wordBreak(s3, wordDict3);
        System.out.println("Test Case 3: " + result3); // Expected Output: []

        // Test Case 4: Word break with repeated words
        String s4 = "aaaaaaa";
        List<String> wordDict4 = Arrays.asList("aaaa", "aa", "a");
        List<String> result4 = solution.wordBreak(s4, wordDict4);
        System.out.println("Test Case 4: " + result4); // Expected Output: Various combinations like ["a a a a a a a", "aa aa aa aa", ... ]

        // Test Case 5: Large input case
        String s5 = "ab" + "a".repeat(1000);
        List<String> wordDict5 = Arrays.asList("a", "b", "ab");
        List<String> result5 = solution.wordBreak(s5, wordDict5);
        System.out.println("Test Case 5: " + result5.size()); // Expected Output: Large number of combinations
    }
}
