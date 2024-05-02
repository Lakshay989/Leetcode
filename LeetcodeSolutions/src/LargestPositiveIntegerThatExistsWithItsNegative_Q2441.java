import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative_Q2441 {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        int right = nums.length - 1;
        int left = 0 ;

        while(left < right){
            if(nums[left] + nums[right] == 0){
                return nums[right];
            }
            else if(Math.abs(nums[left]) < Math.abs(nums[right])){
                right -- ;
            }
            else{
                left ++ ;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LargestPositiveIntegerThatExistsWithItsNegative_Q2441 solver = new LargestPositiveIntegerThatExistsWithItsNegative_Q2441();

        // Test case 1: Example provided where the largest positive integer with its negative exists
        int[] nums1 = {-1, 2, 4, 5, -5};
        System.out.println("Test case 1:");
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solver.findMaxK(nums1)); // Expected output: 5

        // Test case 2: Example provided where the largest positive integer with its negative does not exist
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println("\nTest case 2:");
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solver.findMaxK(nums2)); // Expected output: -1

        // Test case 3: Empty array
        int[] nums3 = {};
        System.out.println("\nTest case 3:");
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + solver.findMaxK(nums3)); // Expected output: -1

        // Test case 4: Array with one element
        int[] nums4 = {5};
        System.out.println("\nTest case 4:");
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Output: " + solver.findMaxK(nums4)); // Expected output: -1

        // Test case 5: Array with only positive elements
        int[] nums5 = {1, 2, 3, 4, 5};
        System.out.println("\nTest case 5:");
        System.out.println("Input: " + Arrays.toString(nums5));
        System.out.println("Output: " + solver.findMaxK(nums5)); // Expected output: -1

        // Test case 6: Array with only negative elements
        int[] nums6 = {-5, -4, -3, -2, -1};
        System.out.println("\nTest case 6:");
        System.out.println("Input: " + Arrays.toString(nums6));
        System.out.println("Output: " + solver.findMaxK(nums6)); // Expected output: -1
    }
}
