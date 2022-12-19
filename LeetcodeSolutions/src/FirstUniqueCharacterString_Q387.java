import java.util.Arrays;

public class FirstUniqueCharacterString_Q387
{
    public static void main(String[] args)
    {
       String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
    public static int firstUniqChar(String s)
    {
        int[] alphabets = new int[26] ;
        Arrays.fill(alphabets,-1) ;

        for(int i = 0 ; i < s.length() ; i++)
        {
            if(alphabets[s.charAt(i) -97] == -1)
            {
                alphabets[s.charAt(i) - 97] = i ;
            }
            else
            {
                alphabets[s.charAt(i) - 97] = -2 ; // -2 for repetition
            }
        }

        int min = s.length();
        for(int i = 0 ; i <alphabets.length ; i++)
        {
            if(alphabets[i] >= 0)
            {
                if(min > alphabets[i])
                {
                    min = alphabets[i] ;
                }
            }
        }

        if(min != s.length())
        {
            return min ;
        }
        else
        {
            return -1 ;
        }

    }
}
