public class FindTheIndexOfTheFirstOccuranceInAString_Q28
{
    public  static int strStr(String haystack, String needle)
    {
        if (needle.length() > haystack.length())
        {
            return -1 ;
        }

        if (needle.equals(haystack))
        {
            return 0 ;
        }

        for (int i = 0 ; i <= haystack.length() - needle.length() ; i++)
        {
            if (haystack.charAt(i) == needle.charAt(0))
            {
                // if (haystack.substring(i, i+needle.length()).length() >= needle.length())
                // {
                if (haystack.substring(i, i+needle.length()).equals(needle))
                {
                    return i;
                }
                // }
            }
        }
        return -1 ;
    }

    public static void main(String[] args) {
        testExample1();
        testExample2();
        testEmptyNeedle();
        testNeedleNotInHaystack();
        testNeedleAtEndOfHaystack();
    }

    public static void testExample1() {
        String haystack = "sadbutsad";
        String needle = "sad";
        int result = strStr(haystack, needle);
        System.out.println("Test Example 1: Expected 0, Got " + result);
    }

    public static void testExample2() {
        String haystack = "leetcode";
        String needle = "leeto";
        int result = strStr(haystack, needle);
        System.out.println("Test Example 2: Expected -1, Got " + result);
    }

    public static void testEmptyNeedle() {
        String haystack = "a";
        String needle = "a";
        int result = strStr(haystack, needle);
        System.out.println("Test Empty Needle: Expected 0, Got " + result);
    }

    public static void testNeedleNotInHaystack() {
        String haystack = "hello world";
        String needle = "foo";
        int result = strStr(haystack, needle);
        System.out.println("Test Needle Not in Haystack: Expected -1, Got " + result);
    }

    public static void testNeedleAtEndOfHaystack() {
        String haystack = "abcdefg";
        String needle = "fg";
        int result = strStr(haystack, needle);
        System.out.println("Test Needle at End of Haystack: Expected 5, Got " + result);
    }
}
