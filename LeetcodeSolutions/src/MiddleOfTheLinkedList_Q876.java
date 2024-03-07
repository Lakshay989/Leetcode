class ListNodeQ876 {
      int val;
    ListNodeQ876 next;
    ListNodeQ876() {}
    ListNodeQ876(int val) { this.val = val; }
    ListNodeQ876(int val, ListNodeQ876 next) { this.val = val; this.next = next; }
 }

public class MiddleOfTheLinkedList_Q876 {
    public ListNodeQ876 middleNode(ListNodeQ876 head) {
        ListNodeQ876 fast = head ;
        ListNodeQ876 slow = head ;

        while(fast.next !=null && fast.next.next != null){
            fast = fast.next.next ;
            slow = slow.next;
        }

        if(fast.next !=null){
            return slow.next ;
        }

        return slow ;
    }

    public static void main(String[] args) {
        MiddleOfTheLinkedList_Q876 solution = new MiddleOfTheLinkedList_Q876();

        // Test case 1: Odd-length linked list
        ListNodeQ876 head1 = new ListNodeQ876(1);
        head1.next = new ListNodeQ876(2);
        head1.next.next = new ListNodeQ876(3);
        head1.next.next.next = new ListNodeQ876(4);
        head1.next.next.next.next = new ListNodeQ876(5);
        ListNodeQ876 result1 = solution.middleNode(head1);
        System.out.println("Test Case 1: " + (result1.val == 3));

        // Test case 2: Even-length linked list
        ListNodeQ876 head2 = new ListNodeQ876(1);
        head2.next = new ListNodeQ876(2);
        head2.next.next = new ListNodeQ876(3);
        head2.next.next.next = new ListNodeQ876(4);
        ListNodeQ876 result2 = solution.middleNode(head2);
        System.out.println("Test Case 2: " + (result2.val == 3 || result2.val == 4));
    }
}
