public class ReverseNodesInKGroup_Q25 {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
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

    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode new_head = null;
        ListNode ptr = head;

        while (k > 0) {
            ListNode next_node = ptr.next;
            ptr.next = new_head;
            new_head = ptr;
            ptr = next_node;
            k--;
        }

        return new_head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode ktail = null;
        ListNode new_head = null;

        while (ptr != null) {
            int count = 0;
            ptr = head;

            while (count < k && ptr != null) {
                ptr = ptr.next;
                count += 1;
            }

            if (count == k) {
                ListNode revHead = this.reverseLinkedList(head, k);

                if (new_head == null)
                    new_head = revHead;

                if (ktail != null)
                    ktail.next = revHead;

                ktail = head;
                head = ptr;
            }
        }

        if (ktail != null)
            ktail.next = head;

        return new_head == null ? head : new_head;
    }

    public static void main(String[] args) {
        // Test case 1
        ReverseNodesInKGroup_Q25.ListNode list1 = new ReverseNodesInKGroup_Q25.ListNode(1);
        list1.next = new ReverseNodesInKGroup_Q25.ListNode(2);
        list1.next.next = new ReverseNodesInKGroup_Q25.ListNode(3);
        list1.next.next.next = new ReverseNodesInKGroup_Q25.ListNode(4);
        list1.next.next.next.next = new ReverseNodesInKGroup_Q25.ListNode(5);

        ReverseNodesInKGroup_Q25 solution1 = new ReverseNodesInKGroup_Q25();
        ReverseNodesInKGroup_Q25.ListNode result1 = solution1.reverseKGroup(list1, 2);

        while(result1 != null){
            System.out.println(result1.val);
            result1 = result1.next ;
        }
        System.out.println("-----------------------------------________------___-----__--");

        // Test case 2
        ReverseNodesInKGroup_Q25.ListNode list2 = new ReverseNodesInKGroup_Q25.ListNode(1);
        list2.next = new ReverseNodesInKGroup_Q25.ListNode(2);
        list2.next.next = new ReverseNodesInKGroup_Q25.ListNode(3);
        list2.next.next.next = new ReverseNodesInKGroup_Q25.ListNode(4);
        list2.next.next.next.next = new ReverseNodesInKGroup_Q25.ListNode(5);

        ReverseNodesInKGroup_Q25 solution2 = new ReverseNodesInKGroup_Q25();
        ReverseNodesInKGroup_Q25.ListNode result2 = solution2.reverseKGroup(list2, 3);

        while(result2 != null){
            System.out.println(result2.val);
            result2 = result2.next ;
        }    }
}
