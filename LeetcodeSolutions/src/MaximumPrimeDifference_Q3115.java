public class MaximumPrimeDifference_Q3115 {
    public int maximumPrimeDifference(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for(int i = 0 ; i < nums.length ; i++){
            if(isPrime(nums[i])){
                left = i;
                break;
            }
        }

        for(int i = nums.length - 1; i>=0 ; i--){
            if(isPrime(nums[i])){
                right = i ;
                break ;
            }
        }
        return right - left ;
    }

    public boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        if(n <= 3){
            return true;
        }
        if(n % 2 == 0 || n % 3 == 0){
            return false;
        }
        for(int i = 5; i * i <= n; i += 6){
            if(n % i == 0 || n % (i + 2) == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MaximumPrimeDifference_Q3115 solution = new MaximumPrimeDifference_Q3115();

        // Test cases
        int[] nums1 = {10, 20, 30, 40, 50};
        System.out.println(solution.maximumPrimeDifference(nums1)); // Expected: 4

        int[] nums2 = {2, 3, 5, 7, 11, 13};
        System.out.println(solution.maximumPrimeDifference(nums2)); // Expected: 5

        int[] nums3 = {1, 4, 6, 8, 9};
        System.out.println(solution.maximumPrimeDifference(nums3)); // Expected: 4

        int[] nums4 = {17, 21, 23, 29, 31};
        System.out.println(solution.maximumPrimeDifference(nums4)); // Expected: 4
    }
}
