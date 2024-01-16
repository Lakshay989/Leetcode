public class DivisibleAndNonDivisibleSumsDifference_Q2894 {
    public int differenceOfSums(int n, int m) {
        int num1 = 0 ;
        int num2 = 0;

        for(int i = 1 ; i <=n ; i++){
            if(i % m == 0){
                num2 += i ;
            }
            else{
                num1+= i ;
            }
        }
        return num1 - num2 ;
    }
    public static void main(String[] args) {
        DivisibleAndNonDivisibleSumsDifference_Q2894 calculator = new DivisibleAndNonDivisibleSumsDifference_Q2894();

        // Test case 1
        int result1 = calculator.differenceOfSums(5, 2);
        System.out.println("Test Case 1: " + result1); // Expected output: 3

        // Test case 2
        int result2 = calculator.differenceOfSums(10, 3);
        System.out.println("Test Case 2: " + result2); // Expected output: 19

        // Test case 3
        int result3 = calculator.differenceOfSums(7, 1);
        System.out.println("Test Case 3: " + result3); // Expected output: -28

        // Test case 4
        int result4 = calculator.differenceOfSums(8, 4);
        System.out.println("Test Case 4: " + result4); // Expected output: -12
    }
}
