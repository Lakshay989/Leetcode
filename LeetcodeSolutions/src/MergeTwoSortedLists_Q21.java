public class MergeTwoSortedLists_Q21
{

      //Definition for singly-linked list.
      public class ListNode
      {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public ListNode mergeTwoLists(ListNode list1, ListNode list2)
      {
            //ArrayList<ListNode> mergedList;

            ListNode dummyhead = new ListNode(-1) ;

            ListNode mergedList = dummyhead ;
            while(list1 != null && list2 != null )
            {
                if(list1.val <= list2.val)
                {
                    mergedList.next = list1;
                    list1 = list1.next ;
                }
                else
                {
                    mergedList.next = list2;
                    list2 = list2.next ;
                }
                mergedList = mergedList.next ;
            }

            if(list1 == null)
            {
                mergedList.next = list2 ;
            }
            else
            {
                mergedList.next = list1 ;
            }
            return dummyhead.next ;

      }
}
