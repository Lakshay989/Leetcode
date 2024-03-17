public class CountSubstringsStartingAndEndingWithGivenCharacter_Q3084 {
    public long countSubstrings(String s, char c) {
        long charCount = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == c){
                charCount++;
            }
        }
        return charCount * (charCount + 1)/2 ;
    }
}
