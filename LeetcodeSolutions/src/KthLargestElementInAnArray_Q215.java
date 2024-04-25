public class KthLargestElementInAnArray_Q215 {
    public int findKthLargest(int[] nums, int k) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int num: nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }

        int[] count = new int[maxValue - minValue + 1];
        for (int num: nums) {
            count[num - minValue]++;
        }

        int remain = k;
        for (int num = count.length - 1; num >= 0; num--) {
            remain -= count[num];
            if (remain <= 0) {
                return num + minValue;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        KthLargestElementInAnArray_Q215 solution = new KthLargestElementInAnArray_Q215();

        // Test case 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        int result1 = solution.findKthLargest(nums1, k1);
        System.out.println("Test Case 1:");
        System.out.println("Expected Output: 5");
        System.out.println("Actual Output: " + result1);

        // Test case 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int result2 = solution.findKthLargest(nums2, k2);
        System.out.println("\nTest Case 2:");
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + result2);
    }
}
