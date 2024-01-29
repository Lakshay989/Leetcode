public class AliceAndBobPlayingFlowerGame_Q3021 {
    public long flowerGame(int n, int m) {
        if (n % 2 == 0 || m % 2 == 0) {
            return (long)n * m / 2;
        } else {
            return (long)(n * m - 1) / 2;
        }
    }
    public static void main(String[] args) {
        AliceAndBobPlayingFlowerGame_Q3021 gameSolver = new AliceAndBobPlayingFlowerGame_Q3021();

        // Test Case 1
        int n1 = 3, m1 = 2;
        long output1 = gameSolver.flowerGame(n1, m1);
        System.out.println("Test Case 1: " + (output1 == 3 ? "Passed" : "Failed"));

        // Test Case 2
        int n2 = 1, m2 = 1;
        long output2 = gameSolver.flowerGame(n2, m2);
        System.out.println("Test Case 2: " + (output2 == 0 ? "Passed" : "Failed"));

        // Test Case 3 (Additional Test Case)
        int n3 = 5, m3 = 4;
        long output3 = gameSolver.flowerGame(n3, m3);
        System.out.println("Test Case 3: " + (output3 == 10 ? "Passed" : "Failed"));
    }
}
