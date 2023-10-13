public class Main {

    //Write a function that reverses a string. The input string is given as an array of characters s.
    //
    //You must do this by modifying the input array in-place with O(1) extra memory.
    //
    //
    //
    //Example 1:
    //
    //Input: s = ["h","e","l","l","o"]
    //Output: ["o","l","l","e","h"]
    //
    //Example 2:
    //
    //Input: s = ["H","a","n","n","a","h"]
    //Output: ["h","a","n","n","a","H"]

    public static void reverseString(char[] s)
    {
        for (int i = 0 ; i < s.length ; i++)
        {
            if (!((s.length - i - 1) >= i))
            {
                char temp = s[s.length - i - 1];
                s[s.length - i - 1] = s[i];
                s[i] = temp;
            }
        }
    }

    public static void main(String[] args)
    {
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s1);
        System.out.println(s1); // Expected output: "o,l,l,e,h"

        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s2);
        System.out.println(s2); // Expected output: "h,a,n,n,a,H"
    }
}