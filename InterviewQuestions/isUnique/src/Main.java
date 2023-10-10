import java.util.HashMap;

public class Main {

// IS Unique : Implement an algorithm to determine if a string has all unique characters,
// What if you cannot use additional data structures.

    static boolean isUnique(String s)
    {
        // Brute Force
//
//        for (int i = 0 ; i < s.length() ; i++)
//        {
//            for (int j = i+1 ; j < s.length() ; j++)
//            {
//                if(s.charAt(i) == s.charAt(j))
//                {
//                    return false ;
//                }
//            }
//        }
//        return  true ;

        // Hash Table

        HashMap<Character, Integer> alphapet_tracker= new HashMap<Character, Integer>(26) ;
        for (int i = 0 ; i < s.length() ; i++)
        {
            if (alphapet_tracker.containsKey(s.charAt(i)))
            {
               alphapet_tracker.put(s.charAt(i), alphapet_tracker.get(s.charAt(i)) + 1) ;
            }
            else
            {
                alphapet_tracker.put(s.charAt(i), 1);
            }
        }
        for (int i = 0 ; i < alphapet_tracker.size() ; i ++)
        {
            if(alphapet_tracker.get(s.charAt(i)) > 1)
            {
                return false ;
            }
        }
        return true ;


        // Bit vector -- 32 bit vector which has the 26 alphabets and other characters i.e. character - 'a' ;

        // O(N log N) ?? -- > Sort the string and check linearly
    }

    public static void main(String[] args)
    {
        System.out.println(isUnique("hello")); // false
        System.out.println(isUnique("hola")) ; // true
        System.out.println(isUnique("palisdob")); // true
        System.out.println(isUnique("abbcbcbcbcbc")); // false
    }
}