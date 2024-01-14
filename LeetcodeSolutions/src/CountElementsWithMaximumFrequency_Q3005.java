import java.util.HashMap;

public class CountElementsWithMaximumFrequency_Q3005 {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>() ;

        for(int i = 0 ; i < nums.length ; i++){
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i],0) + 1);
        }

        int max = 0 ;

        for(int value : hashmap.values()){
            if (value > max){
                max = value ;
            }
        }
        int count = 0 ;

        for(int value : hashmap.values()){
            if ( value == max){
                count += value;
            }
        }
        return count ;

    }
    public static void main(String[] args) {
        CountElementsWithMaximumFrequency_Q3005 solution = new CountElementsWithMaximumFrequency_Q3005();

        // Test 1
        int[] nums1 = {1, 2, 2, 3, 1, 2, 4};
        int result1 = solution.maxFrequencyElements(nums1);
        System.out.println("Test 1 Result: " + result1);

        // Test 2
        int[] nums2 = {3, 1, 4, 4, 2, 2, 2};
        int result2 = solution.maxFrequencyElements(nums2);
        System.out.println("Test 2 Result: " + result2);

        // Add more tests as needed

    }

}
