import java.util.Arrays;

public class BuildArrayFromPermutation
{
    public static int[] buildArray(int[] nums)
    {
        int[] answer = new int[nums.length];

        for (int i = 0 ; i < nums.length ; i++)
        {
            answer[i] = nums[nums[i]] ;
        }

        return answer ;
    }

    public static void main(String[] args)
    {
        testPermutationArray();
    }

    public static void testPermutationArray() {
        int[] nums1 = {0, 2, 1, 5, 3, 4};
        int[] result1 = buildArray(nums1);
        int[] expected1 = {0, 1, 2, 4, 5, 3};
        System.out.println("Test Case 1:");
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(result1));
        System.out.println("Expected: " + Arrays.toString(expected1));
        System.out.println("Result: " + Arrays.equals(result1, expected1));
        System.out.println();

        int[] nums2 = {5, 0, 1, 2, 3, 4};
        int[] result2 = buildArray(nums2);
        int[] expected2 = {4, 5, 0, 1, 2, 3};
        System.out.println("Test Case 2:");
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(result2));
        System.out.println("Expected: " + Arrays.toString(expected2));
        System.out.println("Result: " + Arrays.equals(result2, expected2));
        System.out.println();
    }
}

