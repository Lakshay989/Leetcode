public class NthTribonacciNumber_Q1137 {
    public int tribonacci(int n) {
        int[] lookup = new int[38];
        lookup[0] = 0 ;
        lookup[1] = 1 ;
        lookup[2] = 1 ;

        for(int i = 3 ; i < lookup.length ; i++){
            lookup[i] = lookup[i-1] + lookup[i-2] + lookup[i-3] ;
        }

        return lookup[n];
    }
    public static void main(String[] args) {
        NthTribonacciNumber_Q1137 solution = new NthTribonacciNumber_Q1137();

        // Test case 1
        int n1 = 4;
        System.out.println("Tribonacci number at position " + n1 + ": " + solution.tribonacci(n1)); // Output: 4

        // Test case 2
        int n2 = 25;
        System.out.println("Tribonacci number at position " + n2 + ": " + solution.tribonacci(n2)); // Output: 1389537

        // Test case 3
        int n3 = 1;
        System.out.println("Tribonacci number at position " + n3 + ": " + solution.tribonacci(n3)); // Output: 1

        // Test case 4
        int n4 = 0;
        System.out.println("Tribonacci number at position " + n4 + ": " + solution.tribonacci(n4)); // Output: 0

        // Test case 5
        int n5 = 10;
        System.out.println("Tribonacci number at position " + n5 + ": " + solution.tribonacci(n5)); // Output: 149
    }
}
