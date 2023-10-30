public class Main {

    // 1.5 One Away - 3 types of edits  -- Add/ Remove / Replace

    public static boolean OneAway(String a, String b)
    {

        int diff = a.length() - b.length() ;

        if(diff > 1 || diff < -1)
        {
            return false ;
        }

        if(a.equals(b))
        {
            return true ;
        }

        // Replace
        if(diff == 0){
            boolean foundDiff =  false ;
            for( int  i = 0 ; i <a.length() ; i++)
            {
                if(a.charAt(i) != b.charAt(i))
                {
                    if(foundDiff) {
                        return false ;
                    }
                    foundDiff = true ;
                }
            }
            return true ;
        }
        else if(diff == -1)
        {
            return oneEditReplace(a , b) ;
        }
        else if(diff == 1)
        {
            return oneEditReplace(b, a) ;
        }

        return false;
    }

    static boolean oneEditReplace(String s1, String s2)
    {
        int index1 = 0 ;
        int index2 = 0 ;
        while (index2 < s2.length() && index1 < s1.length())
        {
            if (s1.charAt(index1) != s2.charAt(index2))
            {
                if (index1 != index2)
                {
                    return false;
                }
                index2++ ;
            }
            else{
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(OneAway("pale", "ple"));    // true
        System.out.println(OneAway("pales", "pale"));   // true
        System.out.println(OneAway("pale", "bale"));    // true
        System.out.println(OneAway("pale", "bae"));     // false
        System.out.println(OneAway("apple", "aple"));   // true
        System.out.println("");
        System.out.println(OneAway("cat", "car"));       // true (replace 't' with 'r')
        System.out.println(OneAway("book", "books"));    // true (add 's' at the end)
        System.out.println(OneAway("hello", "helo"));    // true (remove 'l')
        System.out.println(OneAway("world", "sword"));   // false (more than one edit needed)
        System.out.println(OneAway("open", "opener"));   // false (more than one edit needed)
        System.out.println(OneAway("test", "tset"));     // false (more than one edit needed)
        System.out.println(OneAway("", "a"));            // true (add 'a' to an empty string)
        System.out.println(OneAway("a", "abc"));         // false (more than one edit needed)
        System.out.println(OneAway("abcd", "abcde"));    // true (add 'e' at the end)

    }
}