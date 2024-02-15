import java.util.Arrays;

public class FindPolygonWithTheLargsestPerimeter_Q2971 {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long previousElementsSum = 0;
        long ans = -1;
        for (int num : nums) {
            if (num < previousElementsSum) {
                ans = num + previousElementsSum;
            }
            previousElementsSum += num;
        }
        return ans;
    }
    public static void main(String[] args) {
        FindPolygonWithTheLargsestPerimeter_Q2971 solution = new FindPolygonWithTheLargsestPerimeter_Q2971();

        // Test Case 1: Regular case with a valid triangle
        int[] nums1 = {2, 1, 2};
        long expected1 = 5;
        long result1 = solution.largestPerimeter(nums1);
        System.out.println("Test Case 1 Result: " + (result1 == expected1 ? "Check" : "Error"));

        // Test Case 2: Regular case with no valid triangle
        int[] nums2 = {1, 2, 1};
        long expected2 = -1;
        long result2 = solution.largestPerimeter(nums2);
        System.out.println("Test Case 2 Result: " + (result2 == expected2 ? "Check" : "Error"));

        // Test Case 3: Another regular case with a valid triangle
        int[] nums3 = {3, 2, 3, 4};
        long expected3 = 12;
        long result3 = solution.largestPerimeter(nums3);
        System.out.println("Test Case 3 Result: " + (result3 == expected3 ? "Check" : "Error"));
    }
}
