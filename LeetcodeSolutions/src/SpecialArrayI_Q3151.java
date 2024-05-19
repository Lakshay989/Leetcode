public class SpecialArrayI_Q3151 {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1) return true ;

        for(int i = 0 ; i < nums.length - 1 ; i++){
            if(nums[i] %2 ==0 && nums[i + 1] % 2 == 0) return false ;
            if(nums[i] %2 == 1 && nums[i + 1] % 2 == 1) return false ;
        }
        return true ;
    }

    public static void main(String[] args) {
        SpecialArrayI_Q3151 specialArray = new SpecialArrayI_Q3151();

        // Test case 1: Odd and even numbers alternate
        int[] nums1 = {1, 2, 3, 4, 5};
        boolean expected1 = true;
        boolean result1 = specialArray.isArraySpecial(nums1);
        System.out.println("Test case 1 passed: " + (expected1 == result1));

        // Test case 2: All even numbers
        int[] nums2 = {2, 4, 6, 8, 10};
        boolean expected2 = false; // Not special because all are even
        boolean result2 = specialArray.isArraySpecial(nums2);
        System.out.println("Test case 2 passed: " + (expected2 == result2));

        // Test case 3: All odd numbers
        int[] nums3 = {1, 3, 5, 7, 9};
        boolean expected3 = false; // Not special because all are odd
        boolean result3 = specialArray.isArraySpecial(nums3);
        System.out.println("Test case 3 passed: " + (expected3 == result3));

        // Test case 4: Mixed odd and even numbers
        int[] nums4 = {1, 2, 3, 4, 5, 6};
        boolean expected4 = true;
        boolean result4 = specialArray.isArraySpecial(nums4);
        System.out.println("Test case 4 passed: " + (expected4 == result4));

        // Test case 5: Single element
        int[] nums5 = {7};
        boolean expected5 = true; // Single element array is considered special
        boolean result5 = specialArray.isArraySpecial(nums5);
        System.out.println("Test case 5 passed: " + (expected5 == result5));
    }
}
