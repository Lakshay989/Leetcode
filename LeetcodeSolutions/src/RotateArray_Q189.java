import java.util.Arrays;

public class RotateArray_Q189 {
    public void rotate(int[] nums, int k) {

            int[] result = new int[nums.length] ;
            int pointer = 0;

            for (int i = 0 ; i < nums.length ; i++){
                result[(i+k) % nums.length] = nums[i] ;
            }

            for (int i=0 ; i < nums.length ; i++){
                nums[i] = result[i] ;
            }
    }

    public static void main(String[] args) {
        RotateArray_Q189 solution = new RotateArray_Q189();

// Test Case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Input: " + Arrays.toString(nums1) + ", k = " + k1);
        solution.rotate(nums1, k1);
        System.out.println("Output: " + Arrays.toString(nums1));

        // Test Case 2
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        System.out.println("\nInput: " + Arrays.toString(nums2) + ", k = " + k2);
        solution.rotate(nums2, k2);
        System.out.println("Output: " + Arrays.toString(nums2));

        // Additional Test Cases
        int[] nums3 = {4, 5, 6, 7, 8, 9};
        int k3 = 1;
        System.out.println("\nInput: " + Arrays.toString(nums3) + ", k = " + k3);
        solution.rotate(nums3, k3);
        System.out.println("Output: " + Arrays.toString(nums3));

        int[] nums4 = {1, 2, 3};
        int k4 = 4;
        System.out.println("\nInput: " + Arrays.toString(nums4) + ", k = " + k4);
        solution.rotate(nums4, k4);
        System.out.println("Output: " + Arrays.toString(nums4));
    }
    }

