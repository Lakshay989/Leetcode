public class CountBinarySubStrings_Q696
{
    public static int countBinarySubstrings(String s)
    {
        int current = 1 ;
        int result = 0 ;
        int previous = 0 ;

        for(int i =1 ; i < s.length() ; i++)
        {
            if(s.charAt(i) == s.charAt(i-1))
            {
                current ++;
            }
            else{
                result += Math.min(current, previous);
                previous = current;
                current = 1;
            }
        }

        return result + Math.min(current, previous)  ;
    }

    public static void main(String[] args) {
        String s = "00110011";
        String s1 = "10101" ;

        System.out.println( "Expected : " + (countBinarySubstrings(s)) +  "\n Actual : 6");
        System.out.println( "Expected : " + (countBinarySubstrings(s1)) + "\n Actual : 4");
    }
}
