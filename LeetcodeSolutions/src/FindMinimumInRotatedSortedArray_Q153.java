public class FindMinimumInRotatedSortedArray_Q153 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0 ;
        int right = nums.length - 1 ;

        if(nums[left] < nums[right]){
            return nums[left] ;
        }
        while (left < right){
            int mid = (left + right)/2 ;
            if(nums[mid] > nums[mid + 1]){
                return nums[mid + 1] ;
            }
            if(nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if(nums[mid] > nums[left]){
                left = mid + 1 ;
            }
            else{
                right = mid-1;
            }
        }
        return 5000;
    }

    public static void main(String[] args) {
        // Example 1: Rotated sorted array [4, 5, 6, 7, 0, 1, 2]
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        FindMinimumInRotatedSortedArray_Q153 finder1 = new FindMinimumInRotatedSortedArray_Q153();
        int result1 = finder1.findMin(nums1);
        System.out.println("Minimum element in rotated array 1: " + result1);

        // Example 2: Rotated sorted array [3, 4, 5, 1, 2]
        int[] nums2 = {3, 4, 5, 1, 2};
        FindMinimumInRotatedSortedArray_Q153 finder2 = new FindMinimumInRotatedSortedArray_Q153();
        int result2 = finder2.findMin(nums2);
        System.out.println("Minimum element in rotated array 2: " + result2);

        // Example 3: Sorted array [1, 2, 3, 4, 5]
        int[] nums3 = {1, 2, 3, 4, 5};
        FindMinimumInRotatedSortedArray_Q153 finder3 = new FindMinimumInRotatedSortedArray_Q153();
        int result3 = finder3.findMin(nums3);
        System.out.println("Minimum element in rotated array 3: " + result3);
    }
}
