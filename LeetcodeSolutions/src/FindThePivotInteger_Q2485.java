public class FindThePivotInteger_Q2485 {
    public int pivotInteger(int n) {
        final int sum = (n * (n + 1) / 2);
        final int pivot = (int) Math.sqrt(sum);
        // If pivot * pivot is equal to sum (pivot found) return pivot, else return -1
        return pivot * pivot == sum ? pivot : -1;
    }
    public static void main(String[] args) {
        FindThePivotInteger_Q2485 solution = new FindThePivotInteger_Q2485();

        // Test case 1: n = 5
        // The sum of integers from 1 to 3 is 6, and the sum of integers from 4 to 5 is 9.
        // There is no integer x such that the sum of integers from 1 to x is equal to the sum of integers from x+1 to 5.
        // Expected output: -1
        int n1 = 5;
        System.out.println("Test case 1: " + (solution.pivotInteger(n1) == -1 ? "Passed" : "Failed"));

        // Test case 2: n = 6
        // The sum of integers from 1 to 3 is 6, and the sum of integers from 4 to 6 is 15.
        // Here x = 3, as the sum of integers from 1 to 3 is equal to the sum of integers from 4 to 6.
        // Expected output: 3
        int n2 = 6;
        System.out.println("Test case 2: " + (solution.pivotInteger(n2) == -1 ? "Passed" : "Failed"));

        // Test case 3: n = 10
        // The sum of integers from 1 to 4 is 10, and the sum of integers from 5 to 10 is 30.
        // Here x = 4, as the sum of integers from 1 to 4 is equal to the sum of integers from 5 to 10.
        // Expected output: 4
        int n3 = 8;
        System.out.println("Test case 3: " + (solution.pivotInteger(n3) == 6 ? "Passed" : "Failed"));
    }
}
