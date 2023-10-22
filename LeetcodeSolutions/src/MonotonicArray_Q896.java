public class MonotonicArray_Q896 {
    public static boolean isMonotonic(int[] nums) {
        int inc = 1, dec = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] >= 0)
                inc++;
            if (nums[i] - nums[i - 1] <= 0)
                dec++;
        }
        return inc == nums.length || dec == nums.length;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3};
        boolean result1 = isMonotonic(nums1);
        System.out.println("Test Example 1: " + result1); // Should be true

        // Test Example 2
        int[] nums2 = {6, 5, 4, 4};
        boolean result2 = isMonotonic(nums2);
        System.out.println("Test Example 2: " + result2); // Should be true

        // Test Example 3
        int[] nums3 = {1, 3, 2};
        boolean result3 = isMonotonic(nums3);
        System.out.println("Test Example 3: " + result3); // Should be false
    }

}

