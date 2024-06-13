public class MinimumNumberOfMovesToSeatEveryone_Q2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        // Find the maximum position in the arrays
        int maxPosition = Math.max(findMax(seats), findMax(students));

        // Stores difference between number of seats and students at each position
        int[] differences = new int[maxPosition];

        // Count the available seats at each position
        for (int position : seats) {
            differences[position - 1]++;
        }

        // Remove a seat for each student at that position
        for (int position : students) {
            differences[position - 1]--;
        }

        // Calculate the number of moves needed to seat the students
        int moves = 0;
        int unmatched = 0;
        for (int difference : differences) {
            moves += Math.abs(unmatched);
            unmatched += difference;
        }

        return moves;
    }

    private int findMax(int[] array) {
        int maximum = 0;
        for (int num : array) {
            if (num > maximum) {
                maximum = num;
            }
        }
        return maximum;
    }

    public static void main(String[] args) {
        MinimumNumberOfMovesToSeatEveryone_Q2037 solution = new MinimumNumberOfMovesToSeatEveryone_Q2037();

        // Test case
        int[] seats = {3, 1, 5};
        int[] students = {2, 7, 4};
        int result = solution.minMovesToSeat(seats, students);

        System.out.println("Minimum number of moves: " + result);
        // Expected output: 4
        // Explanation:
        // - Move student from position 2 to 1 (1 move)
        // - Move student from position 7 to 5 (2 moves)
        // - Move student from position 4 to 3 (1 move)
        // Total moves = 1 + 2 + 1 = 4
    }
}
