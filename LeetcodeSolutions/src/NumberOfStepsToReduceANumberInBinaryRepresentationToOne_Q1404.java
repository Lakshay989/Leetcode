public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne_Q1404 {
    public int numSteps(String s) {
        int res = 0, carry = 0;

        for(int i = s.length() - 1; i> 0; i--){
            res++;
            if(s.charAt(i) - '0' + carry == 1){
                carry = 1;
                res ++;
            }

        }

        return res + carry;
    }
    public static void main(String[] args) {
        NumberOfStepsToReduceANumberInBinaryRepresentationToOne_Q1404 solution = new NumberOfStepsToReduceANumberInBinaryRepresentationToOne_Q1404();

        // Test case 1: Simple binary number "1101"
        String binary1 = "1101";
        System.out.println("Test Case 1: " + solution.numSteps(binary1)); // Expected output: 6

        // Test case 2: Binary number "10"
        String binary2 = "10";
        System.out.println("Test Case 2: " + solution.numSteps(binary2)); // Expected output: 1

        // Test case 3: Binary number "1"
        String binary3 = "1";
        System.out.println("Test Case 3: " + solution.numSteps(binary3)); // Expected output: 0

        // Test case 4: Binary number "111"
        String binary4 = "111";
        System.out.println("Test Case 4: " + solution.numSteps(binary4)); // Expected output: 5

        // Test case 5: Larger binary number
        String binary5 = "1010101010";
        System.out.println("Test Case 5: " + solution.numSteps(binary5)); // Expected output: 17

        // Test case 6: Binary number with all 1's
        String binary6 = "1111111";
        System.out.println("Test Case 6: " + solution.numSteps(binary6)); // Expected output: 13

        // Test case 7: Binary number with single 1 at the end
        String binary7 = "1000000";
        System.out.println("Test Case 7: " + solution.numSteps(binary7)); // Expected output: 6
    }
}
