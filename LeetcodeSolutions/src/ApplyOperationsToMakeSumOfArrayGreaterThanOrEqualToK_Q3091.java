public class ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK_Q3091 {
    public int minOperations(int k) {

        int result = Integer.MAX_VALUE;
        int baseVal = 1;
        int sum = 1;
        int operations = 0;

        while (true) {
            int temp = operations;
            temp += k / baseVal;
            if (k % baseVal != 0) {
                temp += 1;
            }
            if (temp > result) {
                break;
            }
            result = Math.min(result, temp);
            baseVal++;
            operations++;
        }

        return result - 1;
    }

    public static void main(String[] args) {
        ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK_Q3091 solution = new ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK_Q3091();

        // Test cases
        int k1 = 3;
        System.out.println("Minimum operations for k = " + k1 + ": " + solution.minOperations(k1));

        int k2 = 8;
        System.out.println("Minimum operations for k = " + k2 + ": " + solution.minOperations(k2));

        int k3 = 20;
        System.out.println("Minimum operations for k = " + k3 + ": " + solution.minOperations(k3));
    }

}
