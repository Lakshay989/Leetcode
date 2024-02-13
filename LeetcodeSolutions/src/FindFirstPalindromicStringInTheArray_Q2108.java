public class FindFirstPalindromicStringInTheArray_Q2108 {
    public String firstPalindrome(String[] words) {

        for(String word : words){
            if(isPalindrome(word)){
                return word;
            }
        }
        return "" ;
    }

    public boolean isPalindrome(String s){

        int len = s.length();
        if(len <= 1){
            return true ;
        }

        if(len % 2 == 0){
            if(s.charAt(len/2 - 1) != s.charAt(len/2)){
                return false;
            }
            else{
                int right = len/2 + 1 ;
                int left = len/2 - 2;
                while(right - left < len){
                    if(s.charAt(left) != s.charAt(right)){
                        return false ;
                    }
                    else{
                        left-- ;
                        right++ ;
                    }
                }
                return true ;
            }
        }
        else{
            int right = len/2 + 1 ;
            int left = len/2 - 1;
            while(right - left <= len){
                if(s.charAt(left) != s.charAt(right)){
                    return false ;
                }
                else{
                    left-- ;
                    right++ ;
                }
            }
            return true ;
        }
    }

    public static void main(String[] args) {
        FindFirstPalindromicStringInTheArray_Q2108 solution = new FindFirstPalindromicStringInTheArray_Q2108();

        // Test Case 1: Palindrome exists
        String[] words1 = {"hello", "level", "world"};
        String result1 = solution.firstPalindrome(words1);
        System.out.println("Test Case 1: " + (result1.equals("level") ? "Correct" : "Error - Expected: 'level', Actual: " + result1));

        // Test Case 2: No palindrome
        String[] words2 = {"apple", "banana", "orange"};
        String result2 = solution.firstPalindrome(words2);
        System.out.println("Test Case 2: " + (result2.equals("") ? "Correct" : "Error - Expected: '', Actual: " + result2));

        // Test Case 3: Empty array
        String[] words3 = {};
        String result3 = solution.firstPalindrome(words3);
        System.out.println("Test Case 3: " + (result3.equals("") ? "Correct" : "Error - Expected: '', Actual: " + result3));
    }
}
