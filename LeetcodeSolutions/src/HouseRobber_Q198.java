public class HouseRobber_Q198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
    public static void main(String[] args) {
        // Test SetMismatch_Q645
        HouseRobber_Q198 houseRobberQ198 = new HouseRobber_Q198();

        int[] nums3 = {1, 2, 3, 1};
        int result3 = houseRobberQ198.rob(nums3);
        printTestResult("Test HouseRobber_Q198 Case 1", result3, 4);

        int[] nums4 = {2, 7, 9, 3, 1};
        int result4 = houseRobberQ198.rob(nums4);
        printTestResult("Test HouseRobber_Q198 Case 2", result4, 12);
    }

    private static void printTestResult(String testName, Object actual, Object expected) {
        System.out.println(testName + ": " + (actual.equals(expected) ? "Passed" : "Failed"));
        System.out.println("  Actual: " + actual);
        System.out.println("  Expected: " + expected);
        System.out.println();
    }
}
