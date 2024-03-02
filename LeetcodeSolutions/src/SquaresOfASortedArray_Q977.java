public class SquaresOfASortedArray_Q977 {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = nums[i] *nums[i] ;
        }
        int[] result = new int[nums.length] ;

        int left = 0 ;
        int right = nums.length -1 ;
        int pointer = nums.length -1 ;

        while(pointer >= 0){
            if(nums[right] >= nums[left]){
                result[pointer] = nums[right];
                right-- ;
            }
            else{
                result[pointer] = nums[left];
                left++ ;
            }
            pointer -- ;
        }
        return result ;
    }
    public static void main(String[] args) {
        SquaresOfASortedArray_Q977 solution = new SquaresOfASortedArray_Q977();

        // Test case 1
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] expected1 = {0, 1, 9, 16, 100};
        int[] result1 = solution.sortedSquares(nums1);
        System.out.println("Test Case 1: " + java.util.Arrays.equals(expected1, result1));

        // Test case 2
        int[] nums2 = {-7, -3, 2, 3, 11};
        int[] expected2 = {4, 9, 9, 49, 121};
        int[] result2 = solution.sortedSquares(nums2);
        System.out.println("Test Case 2: " + java.util.Arrays.equals(expected2, result2));

        // Test case 3
        int[] nums3 = {0, 1, 2, 3, 4};
        int[] expected3 = {0, 1, 4, 9, 16};
        int[] result3 = solution.sortedSquares(nums3);
        System.out.println("Test Case 3: " + java.util.Arrays.equals(expected3, result3));
    }
}
