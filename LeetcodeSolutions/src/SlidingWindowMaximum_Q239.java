import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum_Q239 {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum_Q239 solution = new SlidingWindowMaximum_Q239();

        // Test cases
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = solution.maxSlidingWindow(nums1, k1);
        System.out.println("Test Case 1 Result:");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int k2 = 3;
        int[] result2 = solution.maxSlidingWindow(nums2, k2);
        System.out.println("Test Case 2 Result:");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Add more test cases as needed...
    }
}
