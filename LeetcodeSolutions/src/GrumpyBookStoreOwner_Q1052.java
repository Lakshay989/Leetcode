public class GrumpyBookStoreOwner_Q1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max = 0;
        int bestUseOfMins = 0;
        int curr = 0;

        // Calculate initial satisfaction without using the minutes window
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                max += customers[i];
            }
        }

        // Find the best use of the minutes window
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                curr += customers[i];
            }

            if (i >= minutes) {
                if (grumpy[i - minutes] == 1) {
                    curr -= customers[i - minutes];
                }
            }

            if (curr > bestUseOfMins) {
                bestUseOfMins = curr;
            }
        }

        // Add the maximum additional satisfied customers
        max += bestUseOfMins;

        return max;
    }
    public static void main(String[] args) {
        GrumpyBookStoreOwner_Q1052 obj = new GrumpyBookStoreOwner_Q1052();

        // Test case 1
        int[] customers1 = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy1 = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes1 = 3;
        System.out.println(obj.maxSatisfied(customers1, grumpy1, minutes1)); // Expected output: 16

        // Test case 2
        int[] customers2 = {4, 10, 10};
        int[] grumpy2 = {1, 1, 0};
        int minutes2 = 2;
        System.out.println(obj.maxSatisfied(customers2, grumpy2, minutes2)); // Expected output: 24

        // Test case 3
        int[] customers3 = {1, 2, 3, 4, 5};
        int[] grumpy3 = {1, 0, 1, 0, 1};
        int minutes3 = 2;
        System.out.println(obj.maxSatisfied(customers3, grumpy3, minutes3)); // Expected output: 11

        // Test case 4
        int[] customers4 = {1, 2, 3, 4, 5, 6};
        int[] grumpy4 = {1, 1, 1, 1, 1, 1};
        int minutes4 = 3;
        System.out.println(obj.maxSatisfied(customers4, grumpy4, minutes4)); // Expected output: 15

        // Test case 5
        int[] customers5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] grumpy5 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int minutes5 = 5;
        System.out.println(obj.maxSatisfied(customers5, grumpy5, minutes5)); // Expected output: 40

        // Test case 6
        int[] customers6 = {10, 1, 7, 5, 9};
        int[] grumpy6 = {0, 0, 0, 0, 0};
        int minutes6 = 2;
        System.out.println(obj.maxSatisfied(customers6, grumpy6, minutes6)); // Expected output: 32

        // Test case 7
        int[] customers7 = {2, 3, 5, 2, 1, 2, 5, 2};
        int[] grumpy7 = {0, 1, 1, 1, 0, 1, 1, 0};
        int minutes7 = 4;
        System.out.println(obj.maxSatisfied(customers7, grumpy7, minutes7)); // Expected output: 15
    }
}
