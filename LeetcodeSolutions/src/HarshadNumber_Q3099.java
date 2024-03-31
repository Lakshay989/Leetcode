public class HarshadNumber_Q3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int num = x ;
        int sum = 0 ;
        while(num > 0){
            sum += num % 10 ;
            num = num/10 ;
        }
        if(x % sum == 0){
            return sum;
        }
        else{
            return -1 ;
        }
    }

    public static void main(String[] args) {
        HarshadNumber_Q3099 solution = new HarshadNumber_Q3099();

        // Test case 1
        int x1 = 18;
        int result1 = solution.sumOfTheDigitsOfHarshadNumber(x1);
        System.out.println("Test case 1 result: " + result1); // Expected output: 9

        // Test case 2
        int x2 = 22;
        int result2 = solution.sumOfTheDigitsOfHarshadNumber(x2);
        System.out.println("Test case 2 result: " + result2); // Expected output: -1

        // Test case 3
        int x3 = 12;
        int result3 = solution.sumOfTheDigitsOfHarshadNumber(x3);
        System.out.println("Test case 3 result: " + result3); // Expected output: 3
    }
}
