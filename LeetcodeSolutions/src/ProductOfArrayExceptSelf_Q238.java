import java.util.Arrays;

public class ProductOfArrayExceptSelf_Q238 {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length ;
        int[] result = new int[n] ;

        int mult = 1 ;
        for (int i = 0 ; i < n ; i++){
            result[i] = mult ;
            mult *= nums[i] ;
        }
        mult = 1 ;
        for (int i = n-1 ; i>=0 ; i--){
            result[i] *= mult ;
            mult *= nums[i] ;
        }
        return result ;
    }
    public static void main(String[] args) {
        ProductOfArrayExceptSelf_Q238 tester = new ProductOfArrayExceptSelf_Q238();

        int[][] testCases = {
                {1, 2, 3, 4},
                {0, 2, 3, 4},
                {-1, 2, 3, 4},
                {5},
                {30, 30, 30},
                {}
        };

        for (int[] testCase : testCases) {
            int[] result = tester.productExceptSelf(testCase);
            System.out.println("Input: " + Arrays.toString(testCase));
            System.out.println("Output: " + Arrays.toString(result));
            System.out.println();
        }
    }
}
