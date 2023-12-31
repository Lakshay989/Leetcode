class ListNode_Q19 {
    int val;
    ListNode_Q19 next;

    ListNode_Q19() {}

    ListNode_Q19(int val) {
        this.val = val;
    }

    ListNode_Q19(int val, ListNode_Q19 next) {
        this.val = val;
        this.next = next;
    }
}

class RemoveNthNodeFromTheEndOfTheList_Q19 {
    public ListNode_Q19 removeNthFromEnd(ListNode_Q19 head, int n) {
        ListNode_Q19 fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        ListNode_Q19 head = new ListNode_Q19(1);
        head.next = new ListNode_Q19(2);
        head.next.next = new ListNode_Q19(3);
        head.next.next.next = new ListNode_Q19(4);
        head.next.next.next.next = new ListNode_Q19(5);

        RemoveNthNodeFromTheEndOfTheList_Q19 solution = new RemoveNthNodeFromTheEndOfTheList_Q19();
        int n = 2;
        ListNode_Q19 result = solution.removeNthFromEnd(head, n);

        // Printing the updated list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

