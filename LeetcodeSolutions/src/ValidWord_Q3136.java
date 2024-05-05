public class ValidWord_Q3136 {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        word = word.toLowerCase();

        int[] arr = new int[3];

        String vowels = "aeiou";

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLetter(ch)) {
                if (vowels.indexOf(ch) != -1) {
                    arr[0]++;
                } else {
                    arr[1]++;
                }
            }
            else if(ch == '@' || ch == '#' || ch == '$'){
                arr[2] ++ ;
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < 1) {
                return false;
            }
        }

        if(arr[2] != 0) return false ;
        return true;
    }

    public static void main(String[] args) {
        ValidWord_Q3136 validator = new ValidWord_Q3136();

        // Test case 1: Valid word with all conditions satisfied
        String word1 = "aEj";
        System.out.println("Test case 1:");
        System.out.println("Is valid: " + validator.isValid(word1));

        // Test case 2: Valid word with all conditions satisfied but in uppercase
        String word2 = "Afi";
        System.out.println("\nTest case 2:");
        System.out.println("Is valid: " + validator.isValid(word2));

        // Test case 3: Invalid word with length less than 3
        String word3 = "a";
        System.out.println("\nTest case 3:");
        System.out.println("Is valid: " + validator.isValid(word3));

        // Test case 4: Invalid word with no vowels
        String word4 = "bcd";
        System.out.println("\nTest case 4:");
        System.out.println("Is valid: " + validator.isValid(word4));

        // Test case 5: Invalid word with no consonants
        String word5 = "aeiou";
        System.out.println("\nTest case 5:");
        System.out.println("Is valid: " + validator.isValid(word5));

        // Test case 6: Invalid word with special characters
        String word6 = "a@e";
        System.out.println("\nTest case 6:");
        System.out.println("Is valid: " + validator.isValid(word6));
    }
}
