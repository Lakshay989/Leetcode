import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures_Q739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currDay = 0; currDay < n; currDay++) {
            int currentTemp = temperatures[currDay];
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }

        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures_Q739 solution = new DailyTemperatures_Q739();

        // Test case 1
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = solution.dailyTemperatures(temperatures1);
        System.out.println("Test Case 1:");
        printArray(result1); // Helper method to print the result array

        // Test case 2
        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = solution.dailyTemperatures(temperatures2);
        System.out.println("\nTest Case 2:");
        printArray(result2);

        // Test case 3
        int[] temperatures3 = {30, 30, 30, 30};
        int[] result3 = solution.dailyTemperatures(temperatures3);
        System.out.println("\nTest Case 3:");
        printArray(result3);
    }

    // Helper method to print an array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
