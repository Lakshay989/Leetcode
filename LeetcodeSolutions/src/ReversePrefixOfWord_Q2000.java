public class ReversePrefixOfWord_Q2000 {
    public String reversePrefix(String word, char ch) {
        int firstOccurence = word.indexOf(ch);
        if(firstOccurence == -1){
            return word;
        }

        StringBuilder prefix = new StringBuilder(word.substring(0, firstOccurence+1));
        return prefix.reverse().toString() + word.substring(firstOccurence+1);
    }

    public static void main(String[] args) {
        ReversePrefixOfWord_Q2000 solver = new ReversePrefixOfWord_Q2000();

        // Test case 1: Word with prefix to reverse
        String word1 = "abcdef";
        char ch1 = 'd';
        String result1 = solver.reversePrefix(word1, ch1);
        System.out.println("Result for word1: " + result1); // Expected output: "dcbaef"

        // Test case 2: Word without prefix to reverse
        String word2 = "apple";
        char ch2 = 'b';
        String result2 = solver.reversePrefix(word2, ch2);
        System.out.println("Result for word2: " + result2); // Expected output: "apple"

        // Test case 3: Word with prefix to reverse (single character)
        String word3 = "hello";
        char ch3 = 'h';
        String result3 = solver.reversePrefix(word3, ch3);
        System.out.println("Result for word3: " + result3); // Expected output: "h"
    }
}
