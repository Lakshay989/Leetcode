public class ReverseLinkedList_Q206
{

     //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

        public ListNode reverseList(ListNode head) {
            //System.out.println("Head value - "+ head.val);
            ListNode prev = null;
            ListNode curr = head ;
            while(curr !=null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
}
