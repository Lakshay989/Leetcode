import java.util.HashMap;

class ListNode_Q1836 {
    int val;
    ListNode_Q1836 next;

    ListNode_Q1836() {
    }

    ListNode_Q1836(int val) {
        this.val = val;
    }

    ListNode_Q1836(int val, ListNode_Q1836 next) {
        this.val = val;
        this.next = next;
    }
}

class RemoveDuplicatesFromAnUnSortedLinkedList_Q1836 {
    public ListNode_Q1836 deleteDuplicatesUnsorted(ListNode_Q1836 head) {
        HashMap<Integer, Integer> table = new HashMap<>();

        ListNode_Q1836 n = head;

        while (n != null) {
            table.put(n.val, table.getOrDefault(n.val, 0) + 1);
            n = n.next;
        }

        ListNode_Q1836 dummy = new ListNode_Q1836(0);

        dummy.next = head;

        n = dummy;

        while (n.next != null) {
            if (table.get(n.next.val) > 1) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }

        head = dummy.next;
        return head;
    }

    public static void main(String[] args) {
        // Test Cases
        ListNode_Q1836 node1 = new ListNode_Q1836(1);
        ListNode_Q1836 node2 = new ListNode_Q1836(2);
        ListNode_Q1836 node3 = new ListNode_Q1836(3);
        ListNode_Q1836 node4 = new ListNode_Q1836(3);
        ListNode_Q1836 node5 = new ListNode_Q1836(4);
        ListNode_Q1836 node6 = new ListNode_Q1836(4);
        ListNode_Q1836 node7 = new ListNode_Q1836(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        RemoveDuplicatesFromAnUnSortedLinkedList_Q1836 solution = new RemoveDuplicatesFromAnUnSortedLinkedList_Q1836();

        System.out.println("Original List:");
        printList(node1);

        ListNode_Q1836 result = solution.deleteDuplicatesUnsorted(node1);

        System.out.println("\nList after removing duplicates:");
        printList(result);
    }

    private static void printList(ListNode_Q1836 node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}

