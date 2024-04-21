import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfSpecialCharactersII_Q3121 {
    public int numberOfSpecialChars(String word) {

        Map<Integer, Integer> upper = new HashMap<>() ;
        Map<Integer, Integer> lower = new HashMap<>() ;

        for(int i = 0 ; i< word.length() ; i++){
            char c = word.charAt(i) ;

            if(Character.isUpperCase(c)){
                if(upper.containsKey(c - 'A')){
                    continue ;
                }
                else{
                    upper.put(c - 'A', i);
                }
            }
            else{
                lower.put(c - 'a', i) ;
            }
        }

        int count = 0;

        for( int key : upper.keySet()){
            if(lower.containsKey(key) && lower.get(key) < upper.get(key)) count ++ ;
        }

        return count ;
    }

    public static void main(String[] args) {
        CountTheNumberOfSpecialCharactersII_Q3121 solution = new CountTheNumberOfSpecialCharactersII_Q3121();
        String[] testCases = {"aaAbcBC", "abc", "AbBCab", "cCceDC"};
        for (String word : testCases) {
            System.out.println("Input: " + word);
            System.out.println("Output: " + solution.numberOfSpecialChars(word));
            System.out.println();
        }
    }

}
