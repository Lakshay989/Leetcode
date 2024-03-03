import java.util.ArrayList;
import java.util.List;

public class DistributeElementsIntoTwoArraysI_Q3069 {
    public int[] resultArray(int[] nums) {

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2 ; i< nums.length; i++ ){
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        List<Integer> result = new ArrayList<>(arr1);
        result.addAll(arr2);

        // Convert List<Integer> to int[]
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
    public static void main(String[] args) {
        DistributeElementsIntoTwoArraysI_Q3069 solution = new DistributeElementsIntoTwoArraysI_Q3069();

        // Test case 1
        int[] nums1 = {2, 1, 3};
        int[] expected1 = {2, 3, 1};
        int[] result1 = solution.resultArray(nums1);
        System.out.println("Test Case 1: " + java.util.Arrays.equals(expected1, result1));

        // Test case 2
        int[] nums2 = {5, 4, 3, 8};
        int[] expected2 = {5, 3, 4, 8};
        int[] result2 = solution.resultArray(nums2);
        System.out.println("Test Case 2: " + java.util.Arrays.equals(expected2, result2));
    }
}
