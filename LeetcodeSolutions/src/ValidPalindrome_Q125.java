public class ValidPalindrome_Q125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
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
        ValidPalindrome_Q125 palindromeChecker = new ValidPalindrome_Q125();

        // Test cases
        String test1 = "A man, a plan, a canal, Panama";
        System.out.println(palindromeChecker.isPalindrome(test1)); // Output should be true

        String test2 = "race a car";
        System.out.println(palindromeChecker.isPalindrome(test2)); // Output should be false

        String test3 = "level";
        System.out.println(palindromeChecker.isPalindrome(test3)); // Output should be true

        String test4 = "No 'x' in Nixon";
        System.out.println(palindromeChecker.isPalindrome(test4)); // Output should be true

        String test5 = "12321";
        System.out.println(palindromeChecker.isPalindrome(test5)); // Output should be true

        String test6 = "hello";
        System.out.println(palindromeChecker.isPalindrome(test6)); // Output should be false

        String test7 = "";
        System.out.println(palindromeChecker.isPalindrome(test7)); // Output should be true (empty string is considered a palindrome)
    }
}

