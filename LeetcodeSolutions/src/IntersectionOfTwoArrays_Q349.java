import java.util.*;

public class IntersectionOfTwoArrays_Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numbs = new HashSet<>();
        for(int num : nums1){
            numbs.add(num);
        }

        List<Integer> result = new ArrayList<>() ;
        for(int num: nums2){
            if(numbs.contains(num) && !result.contains(num)){
                result.add(num);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays_Q349 solution = new IntersectionOfTwoArrays_Q349();

        // Example 1
        int[] nums11 = {1, 2, 2, 1};
        int[] nums12 = {2, 2};
        int[] result1 = solution.intersection(nums11, nums12);
        int[] expected1 = {2};
        System.out.println("Example 1 Result: " + Arrays.equals(result1, expected1));

        // Example 2
        int[] nums21 = {4, 9, 5};
        int[] nums22 = {9, 4, 9, 8, 4};
        int[] result2 = solution.intersection(nums21, nums22);
        int[] expected2 = {9, 4};
        System.out.println("Example 2 Result: " + Arrays.equals(result2, expected2));

        // Example 3
        int[] nums31 = {1, 2, 3, 4};
        int[] nums32 = {5, 6, 7, 8};
        int[] result3 = solution.intersection(nums31, nums32);
        int[] expected3 = {};
        System.out.println("Example 3 Result: " + Arrays.equals(result3, expected3));
    }
}
