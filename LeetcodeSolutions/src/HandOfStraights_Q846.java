import java.util.HashMap;

public class HandOfStraights_Q846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        // HashMap to store the count of each card value
        HashMap<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            int count = cardCount.getOrDefault(card, 0);
            cardCount.put(card, count + 1);
        }

        for (int card : hand) {
            int startCard = card;
            // Find the start of the potential straight sequence
            while (cardCount.getOrDefault(startCard - 1, 0) > 0) {
                startCard--;
            }

            // Process the sequence starting from startCard
            while (startCard <= card) {
                while (cardCount.getOrDefault(startCard, 0) > 0) {
                    // Check if we can form a consecutive sequence
                    // of groupSize cards
                    for (
                            int nextCard = startCard;
                            nextCard < startCard + groupSize;
                            nextCard++
                    ) {
                        if (cardCount.getOrDefault(nextCard, 0) == 0) {
                            return false;
                        }
                        cardCount.put(nextCard, cardCount.get(nextCard) - 1);
                    }
                }
                startCard++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        HandOfStraights_Q846 solution = new HandOfStraights_Q846();

        // Test case 1: Example case
        int[] hand1 = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize1 = 3;
        System.out.println(solution.isNStraightHand(hand1, groupSize1)); // Expected: true

        // Test case 2: Cannot form groups of the given size
        int[] hand2 = {1, 2, 3, 4, 5};
        int groupSize2 = 4;
        System.out.println(solution.isNStraightHand(hand2, groupSize2)); // Expected: false

        // Test case 3: All cards are the same
        int[] hand3 = {1, 1, 1, 1};
        int groupSize3 = 1;
        System.out.println(solution.isNStraightHand(hand3, groupSize3)); // Expected: true

        // Test case 4: Consecutive groups with multiple occurrences
        int[] hand4 = {1, 2, 3, 4, 5, 6};
        int groupSize4 = 2;
        System.out.println(solution.isNStraightHand(hand4, groupSize4)); // Expected: true

        // Test case 5: Empty hand
        int[] hand5 = {};
        int groupSize5 = 1;
        System.out.println(solution.isNStraightHand(hand5, groupSize5)); // Expected: true

        // Test case 6: Single card, group size 1
        int[] hand6 = {5};
        int groupSize6 = 1;
        System.out.println(solution.isNStraightHand(hand6, groupSize6)); // Expected: true

        // Test case 7: Single card, group size greater than 1
        int[] hand7 = {5};
        int groupSize7 = 2;
        System.out.println(solution.isNStraightHand(hand7, groupSize7)); // Expected: false
    }
}
