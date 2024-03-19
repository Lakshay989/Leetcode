public class TaskScheduler_Q621 {
    public int leastInterval(char[] tasks, int n) {
        // freq array to store the frequency of each task
        int[] freq = new int[26];
        int maxCount = 0;

        // Count the frequency of each task and find the maximum frequency
        for (char task : tasks) {
            freq[task - 'A']++;
            maxCount = Math.max(maxCount, freq[task - 'A']);
        }

        // Calculate the total time needed for execution
        int time = (maxCount - 1) * (n + 1);
        for (int f : freq) {
            if (f == maxCount) {
                time++;
            }
        }

        // Return the maximum of total time needed and the length of the task list
        return Math.max(tasks.length, time);
    }
    public static void main(String[] args) {
        TaskScheduler_Q621 scheduler = new TaskScheduler_Q621();

        // Test cases
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n1 = 2;
        int result1 = scheduler.leastInterval(tasks1, n1);
        System.out.println("Test Case 1: " + result1); // Expected output: 8

        char[] tasks2 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n2 = 0;
        int result2 = scheduler.leastInterval(tasks2, n2);
        System.out.println("Test Case 2: " + result2); // Expected output: 6

        char[] tasks3 = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n3 = 2;
        int result3 = scheduler.leastInterval(tasks3, n3);
        System.out.println("Test Case 3: " + result3); // Expected output: 16
    }
}
