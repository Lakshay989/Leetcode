class MaximumSubArray_Q53 {

    public static void main(String[] args) {
        //MaximumSubArray_Q53 obj ;

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println();
        System.out.println(maxSubArray(nums));

    }

    // Kadane's Algorithm

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    }
