import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber_Q17 {
    private Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>() ;
        if(digits.length() == 0) return result ;

        String givenDigits = digits ;
        helper(0, result, new StringBuilder(), givenDigits);

        return result ;

    }

    void helper(int index, List<String> result, StringBuilder path, String givenDigits){

        if(path.length() == givenDigits.length()){
            result.add(path.toString());
            return ;
        }

        String alphabets = letters.get(givenDigits.charAt(index)) ;

        for(char alphabet : alphabets.toCharArray()){
            path.append(alphabet);
            helper(index + 1, result, path, givenDigits);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber_Q17 solution = new LetterCombinationsOfAPhoneNumber_Q17();

        // Test cases
        String digits1 = "23";
        System.out.println(solution.letterCombinations(digits1)); // Expected: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

        String digits2 = "7";
        System.out.println(solution.letterCombinations(digits2)); // Expected: ["p", "q", "r", "s"]

        String digits3 = "";
        System.out.println(solution.letterCombinations(digits3)); // Expected: []

        String digits4 = "234";
        System.out.println(solution.letterCombinations(digits4)); // Expected: ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
    }
}
