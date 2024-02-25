import java.util.HashMap;

public class SplitTheArray_Q3046 {
    public boolean isPossibleToSplit(int[] nums) {

        if(nums.length % 2 != 0){
            return false ;
        }

        HashMap<Integer, Integer> map = new HashMap<>() ;
        for(int i = 0 ;i < nums.length ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > 2){
                return false ;
            }
        }

        return true ;
    }
    public static void main(String[] args) {
        SplitTheArray_Q3046 solution = new SplitTheArray_Q3046();

        // Test Case 1: General case with even length and valid split
        int[] nums1 = {1, 2, 1, 2};
        System.out.println("Test Case 1: " + (solution.isPossibleToSplit(nums1) ? "Check" : "Error"));

        // Test Case 2: General case with even length but invalid split due to frequency
        int[] nums2 = {1, 2, 1, 2, 1};
        System.out.println("Test Case 2: " + (!solution.isPossibleToSplit(nums2) ? "Check" : "Error"));

        // Test Case 3: General case with odd length
        int[] nums3 = {1, 2, 1};
        System.out.println("Test Case 3: " + (!solution.isPossibleToSplit(nums3) ? "Check" : "Error"));

        // Test Case 4: General case with even length but invalid split due to frequency
        int[] nums4 = {1, 2, 2, 2};
        System.out.println("Test Case 4: " + (!solution.isPossibleToSplit(nums4) ? "Check" : "Error"));

        // Test Case 5: General case with even length and valid split but with negative numbers
        int[] nums5 = {-1, -1, 2, 2};
        System.out.println("Test Case 5: " + (solution.isPossibleToSplit(nums5) ? "Check" : "Error"));
    }
}
