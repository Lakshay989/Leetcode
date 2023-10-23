import java.util.Enumeration;
import java.util.Hashtable;

// Q 1.4

public class Main {

    public static boolean PalindromePermutation(String sentence)
    {
        Hashtable<Character, Integer> tracker = new Hashtable<>() ;
        sentence = sentence.replaceAll("\\s+", "") ;

        for (int i = 0 ; i < sentence.length() ; i++)
        {

            if(!tracker.containsKey(sentence.charAt(i)))
            {
                tracker.put(sentence.charAt(i), 1);
            }
            else {
                int value = tracker.get(sentence.charAt(i));
                tracker.put(sentence.charAt(i), value+1);
            }
        }

        int countEven = 0, countOdd = 0 ; // If string length is even palindrome will have all alphabet counts as even

        Enumeration<Character> e = tracker.keys() ;

        while (e.hasMoreElements())
        {
            char key = e.nextElement();
            if (tracker.get(key) % 2 == 0 )
            {
                countEven++ ;
            }
            else countOdd++ ;
        }

        if (sentence.length() % 2 == 0 && countOdd == 0)
        {
            return true ;
        }

        else if(sentence.length() %2 !=0 && countOdd == 1)
        {
            return true ;
        }
        else return false ;

    }
    public static void main(String[] args)
    {

        String sentence1  = "Nurses run Nurses run" ;
        String sentence2  = "tcoa cat" ;
        String sentence3 = "Idiotic" ;
        String sentence4  = "racecarr";

        System.out.println(PalindromePermutation(sentence1)); // True
        System.out.println(PalindromePermutation(sentence2)); // True
        System.out.println(PalindromePermutation(sentence3)); // False
        System.out.println(PalindromePermutation(sentence4)); // False
    }
}