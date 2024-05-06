class ListNode_Q2487 {
    int val;
    ListNode_Q2487 next;
    ListNode_Q2487() {}
    ListNode_Q2487(int val) { this.val = val; }
    ListNode_Q2487(int val, ListNode_Q2487 next) { this.val = val; this.next = next; }
}

public class RemoveNodesFromLinkeList_Q2487 {
    public ListNode_Q2487 removeNodes(ListNode_Q2487 head) {
        ListNode_Q2487 prev = null, next;

        while (head != null) {
            next = head.next;
            head.next = prev;

            prev = head;
            head = next;
        }

        head = prev;
        prev = null;
        int max = head.val;

        while (head.next != null) {
            if (head.next.val >= max) {
                max = head.next.val;
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            } else {
                head.next = head.next.next;
            }
        }
        head.next = prev;

        return head;
    }

    public static void main(String[] args) {
        RemoveNodesFromLinkeList_Q2487 remover = new RemoveNodesFromLinkeList_Q2487();

        // Test case 2: List with one node
        ListNode_Q2487 head2 = new ListNode_Q2487(5);
        ListNode_Q2487 result2 = remover.removeNodes(head2);
        printList(result2); // Expected output: 5 -> null

        // Test case 3: List with multiple nodes
        ListNode_Q2487 head3 = new ListNode_Q2487(1);
        head3.next = new ListNode_Q2487(2);
        head3.next.next = new ListNode_Q2487(3);
        head3.next.next.next = new ListNode_Q2487(2);
        head3.next.next.next.next = new ListNode_Q2487(4);
        ListNode_Q2487 result3 = remover.removeNodes(head3);
        printList(result3); // Expected output: 4 -> null
    }

    // Helper method to print the linked list
    private static void printList(ListNode_Q2487 head) {
        ListNode_Q2487 current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
