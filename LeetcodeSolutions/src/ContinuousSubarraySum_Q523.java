import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum_Q523 {
    public boolean checkSubarraySum(int[] nums, int k) {

        int prefixSumMod = 0 ;
        Map<Integer, Integer> modHash = new HashMap<>() ;
        modHash.put(0, -1) ;

        for(int i = 0 ; i < nums.length ; i++){
            prefixSumMod = (prefixSumMod + nums[i]) % k ;

            if(modHash.containsKey(prefixSumMod)){
                if(i - modHash.get(prefixSumMod) > 1){
                    return true ;
                }
            }
            else{
                modHash.put(prefixSumMod, i) ;
            }
        }
        return false ;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum_Q523 solution = new ContinuousSubarraySum_Q523();

        // Test case 1
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println(solution.checkSubarraySum(nums1, k1)); // Expected: true

        // Test case 2
        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println(solution.checkSubarraySum(nums2, k2)); // Expected: true

        // Test case 3
        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 13;
        System.out.println(solution.checkSubarraySum(nums3, k3)); // Expected: false

        // Additional test case
        int[] nums4 = {5, 0, 0, 0};
        int k4 = 3;
        System.out.println(solution.checkSubarraySum(nums4, k4)); // Expected: true
    }
}
