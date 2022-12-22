public class RemoveLinkedListElements_Q203
{
     //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public ListNode removeElements(ListNode head, int val)
      {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;

            ListNode prev = dummyHead, curr = head;
            while (curr != null) {
                if (curr.val == val) prev.next = curr.next;
                else prev = curr;
                curr = curr.next;
            }
            return dummyHead.next;
      }
}
