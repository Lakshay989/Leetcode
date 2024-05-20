public class AverageOfEvenNumbersThatAreDivisibleByThree_Q2455 {
    public int averageValue(int[] nums) {
        int count = 0 ;
        int sum = 0 ;

        for(int num : nums){
            if(num % 6 == 0){
                count++ ;
                sum+=num;
            }
        }
        if(count == 0) return 0 ;

        return sum/count ;
    }

    public static void main(String[] args) {
        AverageOfEvenNumbersThatAreDivisibleByThree_Q2455 solution = new AverageOfEvenNumbersThatAreDivisibleByThree_Q2455();

        // Test cases
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        System.out.println(solution.averageValue(nums1)); // Output: 6

        int[] nums2 = {6, 12, 18, 24};
        System.out.println(solution.averageValue(nums2)); // Output: 15

        int[] nums3 = {5, 7, 11, 13};
        System.out.println(solution.averageValue(nums3)); // Output: 0

        int[] nums4 = {0, 3, 6, 9, 12};
        System.out.println(solution.averageValue(nums4)); // Output: 6

        int[] nums5 = {2, 4, 6, 8, 10};
        System.out.println(solution.averageValue(nums5)); // Output: 6
    }
}
