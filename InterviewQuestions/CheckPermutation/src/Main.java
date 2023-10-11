
// 1.2 Given two strings, Write a method to decide if one is a permutation of the other

public class Main {

    static boolean checkPermutation(String s1, String s2)
    {

        // Is it case-sensitive ? whitespaces ??
        // 2 strings to be permutations of eac other mean that all chars in s1 should be in s2


        //sort both the strings and equate --- O(N logN)

        //O(N) --- Extra space
        // We can have a hash map and iterate over s1 to fill it and then compare the pairs with s2
        // calculate the ascii value of both the strings, if they are equal or if the difference is 0
        // check one char from s1 in whole of s2 and remove and repeat


        if (s1.length() != s2.length())
        {
            return false;
        }

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int s1_ac = 0 ;
        int s2_ac = 0 ;

        for (int i = 0 ; i < s1.length() ; i ++)
        {
            s1_ac += (s1.charAt(i) -'a') ;
            s2_ac += (s2.charAt(i) -'a') ;
        }

        if(s1_ac == s2_ac) {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {

        System.out.println(checkPermutation("budge", "debug")); // true
        System.out.println(checkPermutation("budge   ", " d e bug")); // true
        System.out.println(checkPermutation("budGE", "debuG")); // False ? True ?
        System.out.println(checkPermutation("buqge", "debug")); // false
    }
}