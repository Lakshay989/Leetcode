import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter_Q2942 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>() ;

        for(int i = 0 ; i < words.length ; i++){
            for(int j = 0 ; j < words[i].length() ; j++){
                if(words[i].charAt(j) == x ){
                    result.add(i);
                    break ;
                }
            }
        }
        return result ;
    }
    public static void main(String[] args) {
        FindWordsContainingCharacter_Q2942 wordFinder = new FindWordsContainingCharacter_Q2942();

        // Test Case 1: Words containing 'a'
        String[] words1 = {"apple", "banana", "orange"};
        char char1 = 'a';
        List<Integer> result1 = wordFinder.findWordsContaining(words1, char1);
        System.out.println("Words containing '" + char1 + "': " + result1); // Expected output: [0, 1, 2]

        // Test Case 2: Words containing 'o'
        String[] words2 = {"cat", "dog", "fish"};
        char char2 = 'o';
        List<Integer> result2 = wordFinder.findWordsContaining(words2, char2);
        System.out.println("Words containing '" + char2 + "': " + result2); // Expected output: [1]

        // Test Case 3: Words containing 'z' (no words contain 'z')
        String[] words3 = {"java", "python", "ruby"};
        char char3 = 'z';
        List<Integer> result3 = wordFinder.findWordsContaining(words3, char3);
        System.out.println("Words containing '" + char3 + "': " + result3); // Expected output: []

        // Add more test cases as needed
    }
}
