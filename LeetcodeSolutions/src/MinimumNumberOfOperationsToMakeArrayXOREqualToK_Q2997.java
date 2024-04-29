public class MinimumNumberOfOperationsToMakeArrayXOREqualToK_Q2997 {
    public int minOperations(int[] nums, int k) {
        int finalXor = 0;
        for (int n : nums) {
            finalXor = finalXor ^ n;
        }

        return Integer.bitCount(finalXor ^ k);
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToMakeArrayXOREqualToK_Q2997 solver = new MinimumNumberOfOperationsToMakeArrayXOREqualToK_Q2997();

        // Test case 1: Array with single element
        int[] nums1 = {5};
        int k1 = 7;
        int operations1 = solver.minOperations(nums1, k1);
        System.out.println("Minimum number of operations for nums1: " + operations1); // Expected output: 1

        // Test case 2: Array with multiple elements
        int[] nums2 = {1, 2, 3};
        int k2 = 6;
        int operations2 = solver.minOperations(nums2, k2);
        System.out.println("Minimum number of operations for nums2: " + operations2); // Expected output: 1

        // Test case 3: Array with repeated elements
        int[] nums3 = {4, 4, 4, 4};
        int k3 = 5;
        int operations3 = solver.minOperations(nums3, k3);
        System.out.println("Minimum number of operations for nums3: " + operations3); // Expected output: 4
    }
}
