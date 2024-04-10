import java.util.Arrays;

public class RevealCardsInIncreasingOrder_Q950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        int[] result = new int[N];
        boolean skip = false;
        int indexInDeck = 0;
        int indexInResult = 0;

        Arrays.sort(deck);

        while (indexInDeck < N) {
            // There is an available gap in result
            if (result[indexInResult] == 0) {

                // Add a card to result
                if (!skip) {
                    result[indexInResult] = deck[indexInDeck];
                    indexInDeck++;
                }

                // Toggle skip to alternate between adding and skipping cards
                skip = !skip;
            }
            // Progress to next index of result array
            indexInResult = (indexInResult + 1) % N;
        }
        return result;
    }
    public static void main(String[] args) {
        RevealCardsInIncreasingOrder_Q950 solution = new RevealCardsInIncreasingOrder_Q950();

        // Test case 1
        int[] deck1 = {17, 13, 11, 2, 3, 5, 7};
        int[] result1 = solution.deckRevealedIncreasing(deck1);
        System.out.println("Test case 1 result: " + Arrays.toString(result1));
        // Expected output: [2, 13, 3, 11, 5, 17, 7]

        // Test case 2
        int[] deck2 = {1, 2, 3, 4, 5};
        int[] result2 = solution.deckRevealedIncreasing(deck2);
        System.out.println("Test case 2 result: " + Arrays.toString(result2));
        // Expected output: [1, 5, 2, 4, 3]

        // Test case 3
        int[] deck3 = {5, 7, 8, 10, 13, 15, 18, 20};
        int[] result3 = solution.deckRevealedIncreasing(deck3);
        System.out.println("Test case 3 result: " + Arrays.toString(result3));
        // Expected output: [5, 13, 7, 18, 8, 15, 10, 20]
    }
}
