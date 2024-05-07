class ListNode_Q2816 {
    int val;
    ListNode_Q2816 next;
    ListNode_Q2816() {}
    ListNode_Q2816(int val) { this.val = val; }
    ListNode_Q2816(int val, ListNode_Q2816 next) { this.val = val; this.next = next; }
}

public class DoubleANumberRepresentedAsALinkedList_Q2816 {
    public ListNode_Q2816 doubleIt(ListNode_Q2816 head) {
        // If the value of the head node is greater than 4,
        // insert a new node at the beginning
        if (head.val > 4) {
            head = new ListNode_Q2816(0, head);
        }

        // Traverse the linked list
        for (ListNode_Q2816 node = head; node != null; node = node.next) {
            // Double the value of the current node
            // and update it with the units digit
            node.val = (node.val * 2) % 10;

            // If the current node has a next node
            // and the next node's value is greater than 4,
            // increment the current node's value to handle carry
            if (node.next != null && node.next.val > 4) {
                node.val++;
            }
        }

        return head;
    }
    public static void main(String[] args) {
        DoubleANumberRepresentedAsALinkedList_Q2816 doubler = new DoubleANumberRepresentedAsALinkedList_Q2816();

        // Test case 1: Empty list
//        ListNode_Q2816 head1 = null;
//        ListNode_Q2816 result1 = doubler.doubleIt(head1);
//        printList(result1); // Expected output: null

        // Test case 2: List with one node (value <= 4)
        ListNode_Q2816 head2 = new ListNode_Q2816(3);
        ListNode_Q2816 result2 = doubler.doubleIt(head2);
        printList(result2); // Expected output: 6 -> null

        // Test case 3: List with one node (value > 4)
        ListNode_Q2816 head3 = new ListNode_Q2816(6);
        ListNode_Q2816 result3 = doubler.doubleIt(head3);
        printList(result3); // Expected output: 2 -> 1 -> null

        // Test case 4: List with multiple nodes
        ListNode_Q2816 head4 = new ListNode_Q2816(1);
        head4.next = new ListNode_Q2816(3);
        head4.next.next = new ListNode_Q2816(7);
        head4.next.next.next = new ListNode_Q2816(9);
        ListNode_Q2816 result4 = doubler.doubleIt(head4);
        printList(result4); // Expected output: 2 -> 6 -> 5 -> 8 -> null
    }

    // Helper method to print the linked list
    private static void printList(ListNode_Q2816 head) {
        ListNode_Q2816 current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
