import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram_Q84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            while ((stack.peek() != -1)
                    && (heights[stack.peek()] >= heights[i])) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram_Q84 histogram = new LargestRectangleInHistogram_Q84();

        // Test Case 1
        int[] heights1 = { 2, 1, 5, 6, 2, 3 };
        int result1 = histogram.largestRectangleArea(heights1);
        System.out.println("Test Case 1: " + result1); // Expected output: 10

        // Test Case 2
        int[] heights2 = { 2, 4, 2, 1 };
        int result2 = histogram.largestRectangleArea(heights2);
        System.out.println("Test Case 2: " + result2); // Expected output: 6

        // Test Case 3
        int[] heights3 = {  };
        int result3 = histogram.largestRectangleArea(heights3);
        System.out.println("Test Case 3: " + result3); // Expected output: 0 (empty histogram)

        // Add more test cases as needed to cover various scenarios
    }
}
