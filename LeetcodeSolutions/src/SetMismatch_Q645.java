import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SetMismatch_Q645 {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length ;
        int[] result = new int[2] ;
        int[] helper = new int[n + 1] ;

        for(int i = 0 ; i < n ; i++){
            helper[nums[i]]++ ;
        }

        for(int i = 1 ; i< helper.length ; i++){
            if(helper[i] == 0){
                result[1] = i ;
            }
            if(helper[i] == 2){
                result[0] = i ;
            }
        }
        return result ;
    }
    public void testFindErrorNums() {
        SetMismatch_Q645 setMismatchQ645 = new SetMismatch_Q645();

        // Test Case 1
        int[] nums1 = {1, 2, 2, 4};
        int[] result1 = setMismatchQ645.findErrorNums(nums1);
        assertArrayEquals(new int[]{2, 3}, result1);

        // Test Case 2
        int[] nums2 = {3, 2, 3, 4, 6, 5};
        int[] result2 = setMismatchQ645.findErrorNums(nums2);
        assertArrayEquals(new int[]{3, 1}, result2);

        // Add more test cases as needed
    }

    public static void main(String[] args) {
        SetMismatch_Q645 test = new SetMismatch_Q645();
        test.testFindErrorNums();
    }
}
