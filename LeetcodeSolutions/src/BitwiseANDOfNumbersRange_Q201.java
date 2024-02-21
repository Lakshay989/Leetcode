public class BitwiseANDOfNumbersRange_Q201 {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0 ;
        while(left != right){
            left >>= 1;
            right >>=1 ;
            count ++ ;
        }
        return left << count ;
    }
    public static void main(String[] args) {
        BitwiseANDOfNumbersRange_Q201 solution = new BitwiseANDOfNumbersRange_Q201();

        // Test Case 1: General case
        int left1 = 5, right1 = 7;
        int expected1 = 4;
        System.out.println("Test Case 1: " + (solution.rangeBitwiseAnd(left1, right1) == expected1 ? "Check" : "Error"));

        // Test Case 2: Another general case
        int left2 = 0, right2 = 1;
        int expected2 = 0;
        System.out.println("Test Case 2: " + (solution.rangeBitwiseAnd(left2, right2) == expected2 ? "Check" : "Error"));

        // Test Case 3: Large range with no common high order bits
        int left3 = 100, right3 = 200;
        int expected3 = 0;
        System.out.println("Test Case 3: " + (solution.rangeBitwiseAnd(left3, right3) == expected3 ? "Check" : "Error"));

        // Test Case 4: Range within same power of 2
        int left4 = 16, right4 = 31;
        int expected4 = 16;
        System.out.println("Test Case 4: " + (solution.rangeBitwiseAnd(left4, right4) == expected4 ? "Check" : "Error"));

        // Test Case 5: Single element range
        int left5 = 4, right5 = 4;
        int expected5 = 4;
        System.out.println("Test Case 5: " + (solution.rangeBitwiseAnd(left5, right5) == expected5 ? "Check" : "Error"));
    }
}
