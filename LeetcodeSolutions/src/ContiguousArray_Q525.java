import java.util.Arrays;

public class ContiguousArray_Q525 {
    public int findMaxLength(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
    }
    public static void main(String[] args) {
        ContiguousArray_Q525 solution = new ContiguousArray_Q525();

        // Test Case 1
        int[] nums1 = {0, 1, 0};
        System.out.println("Test Case 1: " + solution.findMaxLength(nums1)); // Expected output: 2

        // Test Case 2
        int[] nums2 = {0, 1, 0, 1, 0};
        System.out.println("Test Case 2: " + solution.findMaxLength(nums2)); // Expected output: 4

        // Test Case 3
        int[] nums3 = {1, 1, 0, 1, 0, 0, 1};
        System.out.println("Test Case 3: " + solution.findMaxLength(nums3)); // Expected output: 6

        // Test Case 4
        int[] nums4 = {0, 0, 0, 0, 1, 1, 0, 0, 1};
        System.out.println("Test Case 4: " + solution.findMaxLength(nums4)); // Expected output: 6

        // Test Case 5
        int[] nums5 = {1, 0, 0, 1, 1, 1, 0, 1};
        System.out.println("Test Case 5: " + solution.findMaxLength(nums5)); // Expected output: 6
    }
}
