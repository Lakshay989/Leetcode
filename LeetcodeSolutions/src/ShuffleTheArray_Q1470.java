public class ShuffleTheArray_Q1470 {
    public int[] shuffle(int[] nums, int n) {

        int[] res = new int[2*n] ;
        for (int i = 0 ; i < n; i++){
            res[2*i] = nums[i] ;
            res[2*i + 1] = nums[i + n] ;
        }
        return res ;
    }

    public static void main(String[] args) {
        ShuffleTheArray_Q1470 solution = new ShuffleTheArray_Q1470();

        // Test case 1
        int[] nums1 = {2, 5, 1, 3, 4, 7};
        int n1 = 3;
        int[] result1 = solution.shuffle(nums1, n1);
        System.out.println("Test Case 1:");
        printArray(result1); // Helper method to print the result array

        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
        int n2 = 4;
        int[] result2 = solution.shuffle(nums2, n2);
        System.out.println("\nTest Case 2:");
        printArray(result2);

        // Test case 3
        int[] nums3 = {1, 1, 2, 2};
        int n3 = 2;
        int[] result3 = solution.shuffle(nums3, n3);
        System.out.println("\nTest Case 3:");
        printArray(result3);
    }

    // Helper method to print an array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
