import java.util.PriorityQueue;

public class KthLargestElementInAStream_Q703 {
    final PriorityQueue<Integer> q;
    final int k;

    public KthLargestElementInAStream_Q703(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }
    public static void main(String[] args) {
        // Test case 1
        int k1 = 3;
        int[] arr1 = {4, 5, 8, 2};
        KthLargestElementInAStream_Q703 kth1 = new KthLargestElementInAStream_Q703(k1, arr1);
        System.out.println("Test Case 1:");
        System.out.println("After adding 3, kth largest: " + kth1.add(3)); // Output: 4
        System.out.println("After adding 5, kth largest: " + kth1.add(5)); // Output: 5
        System.out.println("After adding 10, kth largest: " + kth1.add(10)); // Output: 5
        System.out.println("After adding 9, kth largest: " + kth1.add(9)); // Output: 8
        System.out.println("After adding 4, kth largest: " + kth1.add(4)); // Output: 8

        // Test case 2
        int k2 = 1;
        int[] arr2 = {};
        KthLargestElementInAStream_Q703 kth2 = new KthLargestElementInAStream_Q703(k2, arr2);
        System.out.println("\nTest Case 2:");
        System.out.println("After adding 3, kth largest: " + kth2.add(3)); // Output: 3
        System.out.println("After adding 5, kth largest: " + kth2.add(5)); // Output: 5
        System.out.println("After adding 10, kth largest: " + kth2.add(10)); // Output: 10
        System.out.println("After adding 9, kth largest: " + kth2.add(9)); // Output: 10
        System.out.println("After adding 4, kth largest: " + kth2.add(4)); // Output: 10
    }
}
