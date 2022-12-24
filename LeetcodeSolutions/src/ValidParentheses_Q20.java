import java.util.Stack;

public class ValidParentheses_Q20
{
    public static void main(String[] args) {
        //MaximumSubArray_Q53 obj ;

        String s = "()[]{}" ;
        System.out.println();
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>() ;

        for(int i = 0 ; i < s.length() ; i++)
        {
            if( s.charAt(i) == '(' || s.charAt(i) =='{' || s.charAt(i) == '[' )
            {
                stack.push(s.charAt(i)) ;
            }
            else if(! stack.isEmpty()){
                if( (s.charAt(i) == ')' && stack.peek() == '(' )
                        || s.charAt(i) =='}' && stack.peek() == '{'
                        || s.charAt(i) == ']' && stack.peek() == '[' )
                {
                    stack.pop() ;
                }
                else
                {
                    stack.push(s.charAt(i)) ;
                }
            }
            else
            {
                stack.push(s.charAt(i)) ;
            }
        }
        System.out.println(stack) ;
        return stack.isEmpty() ;

    }
}
