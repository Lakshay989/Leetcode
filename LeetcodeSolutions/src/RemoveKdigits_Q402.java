import java.util.Stack;

public class RemoveKdigits_Q402
{

    public static void main(String[] args)
    {
        System.out.println("Test Case 1:");
        String num1 = "1432219";
        int k1 = 3;
        String result1 = removeKdigits(num1, k1);
        System.out.println("Input: num = " + num1 + ", k = " + k1);
        System.out.println("Output: " + result1);
        System.out.println("Expected Output: 1219");
        System.out.println("Test Passed: " + result1.equals("1219"));
        System.out.println();

        System.out.println("Test Case 2:");
        String num2 = "10200";
        int k2 = 1;
        String result2 = removeKdigits(num2, k2);
        System.out.println("Input: num = " + num2 + ", k = " + k2);
        System.out.println("Output: " + result2);
        System.out.println("Expected Output: 200");
        System.out.println("Test Passed: " + result2.equals("200"));
        System.out.println();

        System.out.println("Test Case 3:");
        String num3 = "10";
        int k3 = 2;
        String result3 = removeKdigits(num3, k3);
        System.out.println("Input: num = " + num3 + ", k = " + k3);
        System.out.println("Output: " + result3);
        System.out.println("Expected Output: 0");
        System.out.println("Test Passed: " + result3.equals("0"));
        System.out.println();
    }
    public static String removeKdigits(String num, int k)
    {
        int count = 0 ;
        String result = "" ;
        int len = num.length();

        if (num.length() == k)
        {
            return "0";
        }

        if (k == 0)
        {
            return num;
        }

        Stack<Character> stack = new Stack<>();
        int index = 0;

        while(index < len){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index++));
        }
        while(k-- > 0) stack.pop();

        while(!stack.isEmpty()) result = stack.pop() + result;

        // delete leading zeros
        while(result.length() > 1 && result.charAt(0) == '0')
            result = result.substring(1);

        return result;
    }


}

