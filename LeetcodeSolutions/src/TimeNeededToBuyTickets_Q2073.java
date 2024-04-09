public class TimeNeededToBuyTickets_Q2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;

        for (int i = 0; i < tickets.length; i++) {
            // If the current person is before or at the desired person 'k'
            if (i <= k) {
                // Buy the minimum of tickets available at person 'k' and the current person
                time += Math.min(tickets[k], tickets[i]);
            } else {
                // If the current person is after 'k', buy the minimum of
                // (tickets available at person 'k' - 1) and the current person
                time += Math.min(tickets[k] - 1, tickets[i]);
            }
        }

        return time;
    }

    public static void main(String[] args) {
        TimeNeededToBuyTickets_Q2073 solution = new TimeNeededToBuyTickets_Q2073();

        // Test case 1
        int[] tickets1 = {2, 3, 4, 5, 6};
        int k1 = 2;
        int result1 = solution.timeRequiredToBuy(tickets1, k1);
        System.out.println("Test case 1 result: " + result1); // Expected: 15

        // Test case 2
        int[] tickets2 = {5, 4, 3, 2, 1};
        int k2 = 1;
        int result2 = solution.timeRequiredToBuy(tickets2, k2);
        System.out.println("Test case 2 result: " + result2); // Expected: 14

        // Test case 3
        int[] tickets3 = {1, 2, 3, 4, 5};
        int k3 = 3;
        int result3 = solution.timeRequiredToBuy(tickets3, k3);
        System.out.println("Test case 3 result: " + result3); // Expected: 13
    }
}
