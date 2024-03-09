public class MinimumCommonValue_Q2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int pointer1 = 0 ;
        int pointer2 = 0 ;

        while(pointer1 < nums1.length && pointer2 < nums2.length){
            if(nums1[pointer1] == nums2[pointer2]){
                return nums1[pointer1];
            }

            if(nums1[pointer1] < nums2[pointer2]){
                pointer1++ ;
            }
            else{
                pointer2++ ;
            }
        }
        return -1 ;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {4, 5, 6, 7, 8};
        MinimumCommonValue_Q2540 solution = new MinimumCommonValue_Q2540();
        int result1 = solution.getCommon(nums1, nums2);
        System.out.println("Example 1 Result: " + (result1 == 4));

        // Example 2
        int[] nums3 = {2, 4, 6, 8};
        int[] nums4 = {1, 3, 5, 7, 9};
        int result2 = solution.getCommon(nums3, nums4);
        System.out.println("Example 2 Result: " + (result2 == -1));
    }
}
