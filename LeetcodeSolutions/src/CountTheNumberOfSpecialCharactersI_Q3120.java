public class CountTheNumberOfSpecialCharactersI_Q3120 {
    public int numberOfSpecialChars(String word) {

        int count = 0 ;
        int[] trackerU = new int[26] ;
        int[] trackerL = new int[26] ;
        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i) ;
            if(Character.isUpperCase(c)){
                trackerU[c - 'A'] ++ ;
            }
            else{
                trackerL[c - 97] ++ ;
            }
        }

        for(int i = 0; i < 26 ; i++){
            if(trackerU[i] > 0 && trackerL[i] > 0){
                count ++ ;
            }
        }
        return count ;
    }

    public static void main(String[] args) {
        CountTheNumberOfSpecialCharactersI_Q3120 counter = new CountTheNumberOfSpecialCharactersI_Q3120();

        // Test case 1: Word with mixed upper and lower case letters
        String word1 = "AbCdEfGhIjKlMnOpQrStUvWxYz";
        int specialChars1 = counter.numberOfSpecialChars(word1);
        System.out.println("Special characters in \"" + word1 + "\": " + specialChars1); // Expected output: 0

        // Test case 2: Word with only lowercase letters
        String word2 = "abcdefghijklmnopqrstuvwxyz";
        int specialChars2 = counter.numberOfSpecialChars(word2);
        System.out.println("Special characters in \"" + word2 + "\": " + specialChars2); // Expected output: 0

        // Test case 3: Word with only uppercase letters
        String word3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int specialChars3 = counter.numberOfSpecialChars(word3);
        System.out.println("Special characters in \"" + word3 + "\": " + specialChars3); // Expected output: 0

        // Test case 4: Word with both upper and lower case letters, some of which are the same
        String word4 = "aAbBcCdDeEfFgGhHiIjJkK";
        int specialChars4 = counter.numberOfSpecialChars(word4);
        System.out.println("Special characters in \"" + word4 + "\": " + specialChars4); // Expected output: 11
    }
}
