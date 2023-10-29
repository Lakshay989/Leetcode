public class FinalValuePostOperations_Q2011
{
    public static int finalValueAfterOperations(String[] operations) {

        int result = 0 ;

        for(int i = 0 ; i< operations.length ; i++)
        {
            if(operations[i].contains("++"))
            {
                result += 1;
            }
            else
            {
                result -= 1 ;
            }

        }

        return result ;
    }

    // Test Case 1: Basic test case
    public static void main(String[] args) {

        String[] operations1 = {"--X", "X++", "X++"};
        int result1 = finalValueAfterOperations(operations1);
        System.out.println("Test Case 1: " + result1);  // Expected output: 1

        // Test Case 2: All operations increment X
        String[] operations2 = {"++X", "++X", "X++"};
        int result2 = finalValueAfterOperations(operations2);
        System.out.println("Test Case 2: " + result2);  // Expected output: 3

        // Test Case 3: A mix of operations
        String[] operations3 = {"X++", "++X", "--X", "X--"};
        int result3 = finalValueAfterOperations(operations3);
        System.out.println("Test Case 3: " + result3);  // Expected output: 0

        // Test Case 4: All operations decrement X
        String[] operations4 = {"--X", "X--", "--X"};
        int result4 = finalValueAfterOperations(operations4);
        System.out.println("Test Case 4: " + result4);  // Expected output: -3

        // Test Case 5: No operations
        String[] operations5 = {};
        int result5 = finalValueAfterOperations(operations5);
        System.out.println("Test Case 5: " + result5);
    }
}
