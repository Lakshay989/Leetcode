import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialArrayII_Q3152 {
    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        List<Integer> special = new ArrayList<>();
        int[] prefixSum = new int[n];

        for (int i = 0; i < nums.length - 1; i++) {
            special.add((nums[i] + nums[i + 1]) % 2);
        }

        prefixSum[0] = 0;

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + special.get(i - 1);
        }

        int q = queries.length;
        boolean[] result = new boolean[q];

        int start = 0;
        int end = 0;
        for (int i = 0; i < q; i++) {
            start = queries[i][0];
            end = queries[i][1];

            result[i] = prefixSum[end] - prefixSum[start] == end - start ? true : false;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case 1: Basic test case
        int[] nums1 = {1, 2, 3, 4, 5};
        int[][] queries1 = {{0, 2}, {1, 3}, {2, 4}};
        boolean[] expected1 = {true, true, true};
        boolean[] result1 = SpecialArrayII_Q3152.isArraySpecial(nums1, queries1);
        System.out.println(Arrays.equals(expected1, result1) ? "Test case 1 passed" : "Test case 1 failed");

        // Test case 2: All even numbers
        int[] nums2 = {2, 4, 6, 8, 10};
        int[][] queries2 = {{0, 2}, {1, 3}, {2, 4}};
        boolean[] expected2 = {false, false, false};
        boolean[] result2 = SpecialArrayII_Q3152.isArraySpecial(nums2, queries2);
        System.out.println(Arrays.equals(expected2, result2) ? "Test case 2 passed" : "Test case 2 failed");

        // Test case 3: All odd numbers
        int[] nums3 = {1, 3, 5, 7, 9};
        int[][] queries3 = {{0, 2}, {1, 3}, {2, 4}};
        boolean[] expected3 = {false, false, false};
        boolean[] result3 = SpecialArrayII_Q3152.isArraySpecial(nums3, queries3);
        System.out.println(Arrays.equals(expected3, result3) ? "Test case 3 passed" : "Test case 3 failed");

        // Test case 4: Mixed odd and even numbers
        int[] nums4 = {1, 2, 3, 4, 5};
        int[][] queries4 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        boolean[] expected4 = {true, true, true, true};
        boolean[] result4 = SpecialArrayII_Q3152.isArraySpecial(nums4, queries4);
        System.out.println(Arrays.equals(expected4, result4) ? "Test case 4 passed" : "Test case 4 failed");
    }

}
