import java.util.ArrayList;
import java.util.List;

public class InsertInterval_Q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> res = new ArrayList<>();

        // Case 1: No overlapping before merging intervals
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Case 2: Overlapping and merging intervals
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // Case 3: No overlapping after merging newInterval
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // Convert List to array
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval_Q57 solution = new InsertInterval_Q57();

        // Test Case 1
        int[][] intervals1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};
        int[][] result1 = solution.insert(intervals1, newInterval1);
        printResult(result1); // Expected output: [[1,5],[6,9]]

        // Test Case 2
        int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval2 = {4,8};
        int[][] result2 = solution.insert(intervals2, newInterval2);
        printResult(result2); // Expected output: [[1,2],[3,10],[12,16]]

        // Test Case 3
        int[][] intervals3 = {{1,5}};
        int[] newInterval3 = {0,3};
        int[][] result3 = solution.insert(intervals3, newInterval3);
        printResult(result3); // Expected output: [[0,5]]

        // Test Case 4
        int[][] intervals4 = {};
        int[] newInterval4 = {5,7};
        int[][] result4 = solution.insert(intervals4, newInterval4);
        printResult(result4); // Expected output: [[5,7]]
    }

    // Helper method to print the 2D array
    private static void printResult(int[][] result) {
        for (int[] interval : result) {
            System.out.print("[");
            for (int i = 0; i < interval.length; i++) {
                System.out.print(interval[i]);
                if (i < interval.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.print(" ");
        }
        System.out.println();
    }
}
