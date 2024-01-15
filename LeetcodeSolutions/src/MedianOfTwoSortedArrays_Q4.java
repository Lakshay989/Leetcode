public class MedianOfTwoSortedArrays_Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int start1 = 0 ;
        int start2 = 0 ;
        int end1 = nums1.length ;
        int end2 = nums2.length ;
        int left = 0 ;
        int right = 0 ;
        int[] result = new int[nums1.length + nums2.length];
        int resC = 0 ;

        while(start1 < end1 && start2 < end2){
            left = nums1[start1] ;
            right = nums2[start2] ;
            if(left <= right){
                result[resC] = left ;
                start1 ++ ;
            }
            else{
                result[resC] = right ;
                start2++ ;
            }
            resC++ ;
        }

        if(start1 == end1){
            int constant = end2 -start2 ;
            for(int i = resC ; i < resC + constant ; i++){
                result[i]= nums2[start2];
                start2++ ;
            }
        }
        else{
            int constant = end1 -start1 ;
            for(int i = resC ; i < resC + constant ; i++){
                result[i]= nums1[start1];
                start1++ ;
            }
        }

        if(result.length % 2 == 0){
            return (result[result.length/2] + result[(result.length/2) - 1])/2.0;
        }
        else{
            return (result[result.length/2])/1.0 ;
        }

    }
    public static void main(String[] args) {
        MedianOfTwoSortedArrays_Q4 solution = new MedianOfTwoSortedArrays_Q4();

        // Test 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result1 = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Test 1 Result: " + result1);

        // Test 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        double result2 = solution.findMedianSortedArrays(nums3, nums4);
        System.out.println("Test 2 Result: " + result2);
    }
}
