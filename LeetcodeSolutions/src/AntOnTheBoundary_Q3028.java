public class AntOnTheBoundary_Q3028 {
    public int returnToBoundaryCount(int[] nums) {
        int count = 0 ;
        int sum = 0 ;

        for (int i = 0 ; i < nums.length ; i++){
            sum += nums[i];

            if(sum == 0){
                count++;
            }
        }
        return count ;
    }
    public static void main(String[] args) {
        AntOnTheBoundary_Q3028 solution = new AntOnTheBoundary_Q3028();

        // Test Case 1
        int[] nums1 = {1, -1, 2, -2, 3, -3};
        int result1 = solution.returnToBoundaryCount(nums1);
        System.out.println("Test Case 1: " + (result1 == 3 ? "Passed" : "Failed"));

        // Test Case 2
        int[] nums2 = {1, -1, 2, 3, -3, -2};
        int result2 = solution.returnToBoundaryCount(nums2);
        System.out.println("Test Case 2: " + (result2 == 2 ? "Passed" : "Failed"));

        // Test Case 3
        int[] nums3 = {-1, -2, -3, 6, 5, 4};
        int result3 = solution.returnToBoundaryCount(nums3);
        System.out.println("Test Case 3: " + (result3 == 1 ? "Passed" : "Failed"));

        // Additional Test Case 4
        int[] nums4 = {1, 2, 3, -6, -5, -4};
        int result4 = solution.returnToBoundaryCount(nums4);
        System.out.println("Test Case 4: " + (result4 == 1 ? "Passed" : "Failed"));
    }
}
