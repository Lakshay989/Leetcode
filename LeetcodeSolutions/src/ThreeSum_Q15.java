import java.util.*;

public class ThreeSum_Q15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(nums);
            int target = 0 ;
            Set<List<Integer>> s = new HashSet<>();
            for(int i = 0 ; i < nums.length ; i ++){
                target = - nums[i] ;
                int start = i + 1;
                int end = nums.length - 1 ;

                while (start < end){
                    if(nums[start] + nums[end] == target){
                        s.add(new ArrayList<Integer>(List.of(nums[i], nums[start], nums[end])));
                        start ++ ;
                        end -- ;
                    }
                    else if(nums[start] + nums[end] < target){
                        start++;
                    }
                    else{
                        end -- ;
                    }
                }
            }
            result.addAll(s) ;
            return result ;
        }
    }

    public static void main(String[] args) {
        ThreeSum_Q15 threeSumQ15 = new ThreeSum_Q15();
        ThreeSum_Q15.Solution solution = threeSumQ15.new Solution();

        // Test case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = solution.threeSum(nums1);
        System.out.println("Result 1: " + result1);

        // Test case 2
        int[] nums2 = {0, 0, 0, 0};
        List<List<Integer>> result2 = solution.threeSum(nums2);
        System.out.println("Result 2: " + result2);

        // Add more test cases as needed
    }
}
