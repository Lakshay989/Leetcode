
 // Definition for singly-linked list.
  class ListNodeQ141 {
      int val;
      ListNodeQ141 next;
      ListNodeQ141(int x) {
          val = x;
          next = null;
      }
 }

public class LinkedListCycle_Q141
{
        public boolean hasCycle(ListNodeQ141 head)
        {
            if (head == null) {
                return false;
            }

            ListNodeQ141 slow = head;
            ListNodeQ141 fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;

        }
}
