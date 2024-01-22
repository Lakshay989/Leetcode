import java.util.PriorityQueue;

public class MergeKSortedLists_Q23 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Function to merge k sorted linked lists
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        PriorityQueue<ListNode> minPQ = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode list : lists) {
            if (list != null) {
                minPQ.offer(list);
            }
        }

        while (!minPQ.isEmpty()) {
            ListNode curr = minPQ.poll();
            prev.next = curr;
            prev = prev.next;

            if (curr.next != null) {
                minPQ.offer(curr.next);
            }
        }

        return dummy.next;
    }

    // Helper function to print a linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main function with test cases
    public static void main(String[] args) {
        // Test Case 1
        ListNode[] lists1 = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };
        ListNode result1 = mergeKLists(lists1);
        System.out.print("Merged List 1: ");
        printList(result1);

        // Test Case 2
        ListNode[] lists2 = new ListNode[]{
                new ListNode(1, new ListNode(2, new ListNode(3))),
                new ListNode(4, new ListNode(5, new ListNode(6))),
                new ListNode(7, new ListNode(8, new ListNode(9)))
        };
        ListNode result2 = mergeKLists(lists2);
        System.out.print("Merged List 2: ");
        printList(result2);
    }
}
