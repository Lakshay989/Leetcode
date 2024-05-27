public class SpecialArrayWithXElementsGreaterThanOrEqualX_Q1608 {
    public int specialArray(int[] nums) {
        int N = nums.length;
        int[] freq = new int[N + 1];

        for (int i = 0; i < N; i++) {
            freq[Math.min(N, nums[i])]++;
        }

        int numGreaterThanOrEqual = 0;
        for (int i = N; i >= 1; i--) {
            numGreaterThanOrEqual += freq[i];
            if (i == numGreaterThanOrEqual) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SpecialArrayWithXElementsGreaterThanOrEqualX_Q1608 solution = new SpecialArrayWithXElementsGreaterThanOrEqualX_Q1608();

        // Test Case 1: Basic test case
        int[] nums1 = {3, 5, 0, 1, 2, 3, 4, 5};
        int result1 = solution.specialArray(nums1);
        System.out.println("Test Case 1: " + result1); // Expected Output: 4

        // Test Case 2: No special value exists
        int[] nums2 = {0, 0, 3, 4};
        int result2 = solution.specialArray(nums2);
        System.out.println("Test Case 2: " + result2); // Expected Output: -1

        // Test Case 3: Special value at the boundary
        int[] nums3 = {0, 4, 3, 0, 4};
        int result3 = solution.specialArray(nums3);
        System.out.println("Test Case 3: " + result3); // Expected Output: 3

        // Test Case 4: All elements greater than the length of the array
        int[] nums4 = {7, 7, 7, 7, 7};
        int result4 = solution.specialArray(nums4);
        System.out.println("Test Case 4: " + result4); // Expected Output: 5

        // Test Case 5: Array with all zeros
        int[] nums5 = {0, 0, 0, 0, 0};
        int result5 = solution.specialArray(nums5);
        System.out.println("Test Case 5: " + result5); // Expected Output: -1

        // Test Case 6: Array with one element being the special value
        int[] nums6 = {1};
        int result6 = solution.specialArray(nums6);
        System.out.println("Test Case 6: " + result6); // Expected Output: 1

        // Test Case 7: Array with increasing sequence
        int[] nums7 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result7 = solution.specialArray(nums7);
        System.out.println("Test Case 7: " + result7); // Expected Output: 5

        // Test Case 8: Large array with random values
        int[] nums8 = {10, 3, 5, 7, 2, 8, 10, 6, 1, 4, 9, 2, 3};
        int result8 = solution.specialArray(nums8);
        System.out.println("Test Case 8: " + result8); // Expected Output: 5
    }
}
