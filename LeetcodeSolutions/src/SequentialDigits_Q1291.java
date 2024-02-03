import java.util.ArrayList;
import java.util.List;

public class SequentialDigits_Q1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        String sample = "123456789";
        int n = 10;
        List<Integer> nums = new ArrayList();

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for (int length = lowLen; length < highLen + 1; ++length) {
            for (int start = 0; start < n - length; ++start) {
                int num = Integer.parseInt(sample.substring(start, start + length));
                if (num >= low && num <= high) nums.add(num);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SequentialDigits_Q1291 solution = new SequentialDigits_Q1291();

        // Test Case 1
        int low1 = 100;
        int high1 = 300;
        List<Integer> result1 = solution.sequentialDigits(low1, high1);
        System.out.println("Test Case 1: " + (result1.equals(List.of(123, 234)) ? "Passed" : "Failed"));

        // Test Case 2
        int low2 = 1000;
        int high2 = 13000;
        List<Integer> result2 = solution.sequentialDigits(low2, high2);
        System.out.println("Test Case 2: " + (result2.equals(List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345)) ? "Passed" : "Failed"));

        // Test Case 3
        int low3 = 10;
        int high3 = 15;
        List<Integer> result3 = solution.sequentialDigits(low3, high3);
        System.out.println("Test Case 3: " + (result3.equals(List.of(12)) ? "Passed" : "Failed"));

        // Additional Test Case 4
        int low4 = 50;
        int high4 = 100;
        List<Integer> result4 = solution.sequentialDigits(low4, high4);
        System.out.println("Test Case 4: " + (result4.equals(List.of(56, 67, 78, 89)) ? "Passed" : "Failed"));
    }
}
