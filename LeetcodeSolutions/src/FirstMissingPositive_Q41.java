public class FirstMissingPositive_Q41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Use cycle sort to place positive elements smaller than n
        // at the correct index
        int i = 0;
        while (i < n) {
            int correctIdx = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            } else {
                i++;
            }
        }

        // Iterate through nums
        // return smallest missing positive integer
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all elements are at the correct index
        // the smallest missing positive number is n + 1
        return n + 1;
    }

    // Swaps two elements in nums
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive_Q41 solution = new FirstMissingPositive_Q41();

        // Test case 1: Missing positive integer is 3
        int[] nums1 = {1, 2, 0};
        System.out.println("Test Case 1: " + solution.firstMissingPositive(nums1)); // Expected output: 3

        // Test case 2: Missing positive integer is 2
        int[] nums2 = {3, 4, -1, 1};
        System.out.println("Test Case 2: " + solution.firstMissingPositive(nums2)); // Expected output: 2

        // Test case 3: Missing positive integer is 1
        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("Test Case 3: " + solution.firstMissingPositive(nums3)); // Expected output: 1

        // Test case 4: All positive integers present
        int[] nums4 = {1, 2, 3};
        System.out.println("Test Case 4: " + solution.firstMissingPositive(nums4)); // Expected output: 4
    }
}
