import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement_Q169 {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            int currentCount = hashMap.getOrDefault(nums[i], 0);
            hashMap.put(nums[i], currentCount+1) ;
            // if(!hashMap.containsKey(nums[i]) )
            // {
            //     hashMap.put(nums[i], 1) ;

            // }
            // else{
            //     hashMap.put(nums[i], hashMap.get(nums[i] + 1))  ;

            // }
        }

        for (Integer key : hashMap.keySet()){
            if (hashMap.get(key) > nums.length/2) return key ;
        }
        return 0;
    }

    public static void main(String[] args) {
        MajorityElement_Q169 finder = new MajorityElement_Q169();

        // Test case 1: Single majority element
        int[] nums1 = {3, 2, 3};
        int expected1 = 3;
        int result1 = finder.majorityElement(nums1);
        assert expected1 == result1 : "Test Case 1 Failed";

        // Test case 2: Multiple elements with a majority
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int expected2 = 2;
        int result2 = finder.majorityElement(nums2);
        assert expected2 == result2 : "Test Case 2 Failed";

        // Test case 3: Single element array
        int[] nums3 = {5};
        int expected3 = 5;
        int result3 = finder.majorityElement(nums3);
        assert expected3 == result3 : "Test Case 3 Failed";

        // Test case 4: Array with negative numbers
        int[] nums4 = {-3, -3, -4, -5, -3};
        int expected4 = -3;
        int result4 = finder.majorityElement(nums4);
        assert expected4 == result4 : "Test Case 4 Failed";

        // Test case 5: Large array
        int[] nums5 = new int[50000];
        Arrays.fill(nums5, 7);
        int expected5 = 7;
        int result5 = finder.majorityElement(nums5);
        assert expected5 == result5 : "Test Case 5 Failed";

        System.out.println("All test cases passed successfully!");
    }
}
