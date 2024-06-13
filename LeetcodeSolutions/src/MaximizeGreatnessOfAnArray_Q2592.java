import java.util.Arrays;

public class MaximizeGreatnessOfAnArray_Q2592 {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int j = 0 ;
        for(int num : nums){
            if(num > nums[j]){
                j++ ;
            }
        }
        return j ;
    }
    public static void main(String[] args) {
        MaximizeGreatnessOfAnArray_Q2592 solution = new MaximizeGreatnessOfAnArray_Q2592();

        // Test cases
        int[] nums1 = {1, 3, 2, 4, 5};
        int[] nums2 = {4, 4, 4, 4};
        int[] nums3 = {10, 8, 5, 4, 3};

        System.out.println("Maximized greatness for nums1: " + solution.maximizeGreatness(nums1)); // Expected output: 4
        System.out.println("Maximized greatness for nums2: " + solution.maximizeGreatness(nums2)); // Expected output: 0
        System.out.println("Maximized greatness for nums3: " + solution.maximizeGreatness(nums3)); // Expected output: 4
    }

    // Alt O(n) -- Highest freq - size of Hash Map
}
