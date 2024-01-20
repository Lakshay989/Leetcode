public class FindTheDuplicateNumber_Q287 {
    public int findDuplicate(int[] nums) {

        int hare = nums[0] ;
        int tortoise = nums[0] ;

        do
        {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]] ;
        }while(tortoise != hare) ;

        tortoise = nums[0] ;

        while(tortoise != hare){
            tortoise = nums[tortoise] ;
            hare = nums[hare] ;
        }

        return hare ;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber_Q287 solution = new FindTheDuplicateNumber_Q287();

        // Test Case 1: Duplicate is in the middle of the array
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate in nums1: " + solution.findDuplicate(nums1)); // Output: 2

        // Test Case 2: Duplicate is at the beginning of the array
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate in nums2: " + solution.findDuplicate(nums2)); // Output: 3

        // Test Case 3: Duplicate is at the end of the array
        int[] nums3 = {2, 1, 3, 4, 4};
        System.out.println("Duplicate in nums3: " + solution.findDuplicate(nums3)); // Output: 4

        // Test Case 4: Duplicate is the only element in the array
        int[] nums5 = {2, 2, 2, 2, 2};
        System.out.println("Duplicate in nums5: " + solution.findDuplicate(nums5)); // Output: 2
    }
}
