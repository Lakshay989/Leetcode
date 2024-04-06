import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MinimumRemoveToMakeValidParentheses_Q1249 {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        // Put any indexes remaining on stack into the set.
        while (!stack.isEmpty()) indexesToRemove.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        MinimumRemoveToMakeValidParentheses_Q1249 solution = new MinimumRemoveToMakeValidParentheses_Q1249();

        // Test case 1
        String s1 = "lee(t(c)o)de)";
        String result1 = solution.minRemoveToMakeValid(s1);
        System.out.println("Test case 1 result: " + result1); // Expected output: "lee(t(c)o)de"

        // Test case 2
        String s2 = "a)b(c)d";
        String result2 = solution.minRemoveToMakeValid(s2);
        System.out.println("Test case 2 result: " + result2); // Expected output: "ab(c)d"

        // Test case 3
        String s3 = "))((";
        String result3 = solution.minRemoveToMakeValid(s3);
        System.out.println("Test case 3 result: " + result3); // Expected output: ""

        // Test case 4
        String s4 = "(a(b(c)d)";
        String result4 = solution.minRemoveToMakeValid(s4);
        System.out.println("Test case 4 result: " + result4); // Expected output: "a(b(c)d)"
    }
}
