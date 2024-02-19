public class PowerOfTwo_Q231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }
    public static void main(String[] args) {
        PowerOfTwo_Q231 solution = new PowerOfTwo_Q231();

        // Test Case 1: Power of Two
        int num1 = 16;
        boolean expected1 = true;
        boolean result1 = solution.isPowerOfTwo(num1);
        System.out.println("Test Case 1 Result: " + (result1 == expected1 ? "Check" : "Error"));

        // Test Case 2: Not a Power of Two
        int num2 = 5;
        boolean expected2 = false;
        boolean result2 = solution.isPowerOfTwo(num2);
        System.out.println("Test Case 2 Result: " + (result2 == expected2 ? "Check" : "Error"));

        // Test Case 3: Edge case: 0
        int num3 = 0;
        boolean expected3 = false; // 0 is not a power of two
        boolean result3 = solution.isPowerOfTwo(num3);
        System.out.println("Test Case 3 Result: " + (result3 == expected3 ? "Check" : "Error"));

        // Test Case 4: Edge case: Negative number
        int num4 = -8;
        boolean expected4 = false; // Negative numbers cannot be powers of two
        boolean result4 = solution.isPowerOfTwo(num4);
        System.out.println("Test Case 4 Result: " + (result4 == expected4 ? "Check" : "Error"));
    }
}
