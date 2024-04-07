import java.util.Arrays;

public class MinimumOperationsToMakeMedianOfArrayEqualToK_Q3107 {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int medianIndex = n / 2;
        if (nums[medianIndex] == k) return 0;
        else if (nums[medianIndex] > k) {
            long operations = 0;
            for (int i = medianIndex; i >= 0; i--) {
                if (nums[i] >= k)
                    operations += nums[i] - k;
                else
                    break;
            }
            return operations;
        }
        else {
            long operations = 0;
            for (int i = medianIndex; i < n; i++) {
                if (nums[i] <= k)
                    operations += k - nums[i];
                else
                    break;
            }
            return operations;

        }
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeMedianOfArrayEqualToK_Q3107 solution = new MinimumOperationsToMakeMedianOfArrayEqualToK_Q3107();

        // Test case 1
        int[] nums1 = {1, 3, 5};
        int k1 = 2;
        long result1 = solution.minOperationsToMakeMedianK(nums1, k1);
        System.out.println("Test case 1 result: " + result1); // Expected output: 1

        // Test case 2
        int[] nums2 = {2, 4, 6};
        int k2 = 5;
        long result2 = solution.minOperationsToMakeMedianK(nums2, k2);
        System.out.println("Test case 2 result: " + result2); // Expected output: 1

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 3;
        long result3 = solution.minOperationsToMakeMedianK(nums3, k3);
        System.out.println("Test case 3 result: " + result3); // Expected output: 0

        // Test case 4
        int[] nums4 = {2, 4, 6, 8};
        int k4 = 5;
        long result4 = solution.minOperationsToMakeMedianK(nums4, k4);
        System.out.println("Test case 4 result: " + result4); // Expected output: 2

        // Test case 5
        int[] nums5 = {1, 2, 3, 4, 5, 6};
        int k5 = 4;
        long result5 = solution.minOperationsToMakeMedianK(nums5, k5);
        System.out.println("Test case 5 result: " + result5); // Expected output: 1
    }
}
