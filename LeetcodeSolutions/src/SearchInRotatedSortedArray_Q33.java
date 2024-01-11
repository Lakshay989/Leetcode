public class SearchInRotatedSortedArray_Q33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Case 1: find target
            if (nums[mid] == target) {
                return mid;
            }

            // Case 2: subarray on mid's left is sorted
            else if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Case 3: subarray on mid's right is sorted
            else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        SearchInRotatedSortedArray_Q33 searchInRotatedSortedArray = new SearchInRotatedSortedArray_Q33();

        // Example 1: Test with a rotated sorted array
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        int result1 = searchInRotatedSortedArray.search(nums1, target1);
        System.out.println("Index of " + target1 + ": " + result1); // Expected output: 4

        // Example 2: Test with a rotated sorted array
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        int result2 = searchInRotatedSortedArray.search(nums2, target2);
        System.out.println("Index of " + target2 + ": " + result2); // Expected output: -1

        // Example 3: Test with a sorted array (not rotated)
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        int target3 = 5;
        int result3 = searchInRotatedSortedArray.search(nums3, target3);
        System.out.println("Index of " + target3 + ": " + result3); // Expected output: 4
    }

}
