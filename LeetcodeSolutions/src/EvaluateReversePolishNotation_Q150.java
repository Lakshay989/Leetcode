import java.util.Stack;

public class EvaluateReversePolishNotation_Q150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>() ;

        for (int i = 0 ; i < tokens.length ; i++){
            if(tokens[i].equals("+")){
                int a = Integer.parseInt(stack.pop()) ;
                int b = Integer.parseInt(stack.pop()) ;
                stack.push(String.valueOf(a + b));
            }
            else if(tokens[i].equals("-")){
                int a = Integer.parseInt(stack.pop()) ;
                int b = Integer.parseInt(stack.pop()) ;
                stack.push(String.valueOf(b - a));
            }
            else if(tokens[i].equals("*")){
                int a = Integer.parseInt(stack.pop()) ;
                int b = Integer.parseInt(stack.pop()) ;
                stack.push(String.valueOf(a * b));
            }
            else if(tokens[i].equals("/")){
                int a = Integer.parseInt(stack.pop()) ;
                int b = Integer.parseInt(stack.pop()) ;
                stack.push(String.valueOf(b/a));
            }
            else{
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.peek()) ;
    }
    public static void main(String[] args) {
        EvaluateReversePolishNotation_Q150 evaluator = new EvaluateReversePolishNotation_Q150();

        String[] test1 = {"2", "1", "+", "3", "*"};
        System.out.println("Result for Test 1: " + evaluator.evalRPN(test1)); // Expected output: 9

        String[] test2 = {"4", "13", "5", "/", "+"};
        System.out.println("Result for Test 2: " + evaluator.evalRPN(test2)); // Expected output: 6

        String[] test3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Result for Test 3: " + evaluator.evalRPN(test3)); // Expected output: 22
    }
}
