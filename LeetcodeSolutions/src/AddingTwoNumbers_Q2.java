public class AddingTwoNumbers_Q2
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        // ListNode l1
        // ListNode l2
    }

    public class ListNode
    {
        //Definition for singly-linked list.
        int val; //
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode resultNode = new ListNode(0) ;

        ListNode current = resultNode ;

        int carryOn = 0 ;
        int x = 0 ;
        int y = 0 ;

        while(l1 != null || l2 != null || carryOn != 0)
        {
            if(l1 != null)
            {
                x = l1.val ;
            }
            else
            {
                x = 0 ;
            }

            if(l2 != null)
            {
                y = l2.val ;
            }
            else
            {
                y = 0 ;
            }

            int sum = carryOn + x + y ;

            carryOn = sum/10 ;

            current.next = new ListNode(sum % 10) ;

            current = current.next ;

            if (l1 != null)
            {
                l1 = l1.next ;
            }

            if( l2 != null)
            {
                l2 = l2.next ;
            }

        }

        return resultNode.next ;


    }
}
