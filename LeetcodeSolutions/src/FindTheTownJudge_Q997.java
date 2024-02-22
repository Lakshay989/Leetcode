public class FindTheTownJudge_Q997 {
    public int findJudge(int n, int[][] trust) {
        if (n == 1)
            return 1 ;
        if (trust.length < n - 1) {
            return -1;
        }

        int[] trustScores = new int[n + 1];

        for (int[] relation : trust) {
            trustScores[relation[0]]--;
            trustScores[relation[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FindTheTownJudge_Q997 solution = new FindTheTownJudge_Q997();

        // Test Case 1: General case
        int n1 = 4;
        int[][] trust1 = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        int expected1 = 3;
        System.out.println("Test Case 1: " + (solution.findJudge(n1, trust1) == expected1 ? "Check" : "Error"));

        // Test Case 2: Judge doesn't exist
        int n2 = 3;
        int[][] trust2 = {{1, 3}, {2, 3}, {3, 1}};
        int expected2 = -1;
        System.out.println("Test Case 2: " + (solution.findJudge(n2, trust2) == expected2 ? "Check" : "Error"));

        // Test Case 3: Only one person exists
        int n3 = 1;
        int[][] trust3 = {};
        int expected3 = 1;
        System.out.println("Test Case 3: " + (solution.findJudge(n3, trust3) == expected3 ? "Check" : "Error"));

        // Test Case 4: Multiple people but no trust relations
        int n4 = 2;
        int[][] trust4 = {};
        int expected4 = -1;
        System.out.println("Test Case 4: " + (solution.findJudge(n4, trust4) == expected4 ? "Check" : "Error"));

        // Test Case 5: Single trust relation and judge found
        int n5 = 2;
        int[][] trust5 = {{1, 2}};
        int expected5 = 2;
        System.out.println("Test Case 5: " + (solution.findJudge(n5, trust5) == expected5 ? "Check" : "Error"));
    }
}
