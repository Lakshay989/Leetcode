import java.util.HashMap;

class Solution {
    public static int numIdenticalPairs(int[] nums) {

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int count = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i],0) + 1) ;
        }

        for(int value : hashmap.values()){

            count += value * (value-1)/2;
        }
        return count ;

    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 1, 1, 3};
        System.out.println("Test Case 1: " + numIdenticalPairs(nums1)); // Expected output: 4

        // Test Case 2
        int[] nums2 = {1, 1, 1, 1};
        System.out.println("Test Case 2: " + numIdenticalPairs(nums2)); // Expected output: 6

        // Test Case 3
        int[] nums3 = {1, 2, 3};
        System.out.println("Test Case 3: " + numIdenticalPairs(nums3)); // Expected output: 0

        // Test Case 4
        int[] nums4 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        System.out.println("Test Case 4: " + numIdenticalPairs(nums4)); // Expected output: 3
    }
}
