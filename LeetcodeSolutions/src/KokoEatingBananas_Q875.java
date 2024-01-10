public class KokoEatingBananas_Q875 {
    public int minEatingSpeed(int[] piles, int h) {
        // Initalize the left and right boundaries
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int middle = (left + right) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }

    public static void main(String[] args) {
    KokoEatingBananas_Q875 solution = new KokoEatingBananas_Q875();

    // Test cases
    int[] piles1 = {3, 6, 7, 11};
    int h1 = 8;
        System.out.println("Piles: [3, 6, 7, 11], h = 8");
        System.out.println("Minimum Eating Speed: " + solution.minEatingSpeed(piles1, h1)); // Output: 4

    int[] piles2 = {30, 11, 23, 4, 20};
    int h2 = 5;
        System.out.println("Piles: [30, 11, 23, 4, 20], h = 5");
        System.out.println("Minimum Eating Speed: " + solution.minEatingSpeed(piles2, h2)); // Output: 30

    int[] piles3 = {30, 11, 23, 4, 20};
    int h3 = 6;
        System.out.println("Piles: [30, 11, 23, 4, 20], h = 6");
        System.out.println("Minimum Eating Speed: " + solution.minEatingSpeed(piles3, h3)); // Output: 23
    }
}
