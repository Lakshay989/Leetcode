class ListNodeQ234 {
    int val;
    ListNodeQ234 next ;
    ListNodeQ234() {}
    ListNodeQ234(int val) { this.val = val; }
    ListNodeQ234(int val, ListNodeQ234 next) { this.val = val; this.next = next; }
}
public class PalindromeLinkedList_Q234 {
    private static final int[] array = new int[100_000];
    public boolean isPalindrome(ListNodeQ234 head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNodeQ234 h= head;
        final int[] array1 = array;
        int size =0;

        while(h!=null){
            array1[size++] = h.val;
            h=h.next;
        }

        int m = size/2;
        for(int i=0;i<m;i++){
            if(array[i] != array1[--size]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // Create a linked list for testing
        ListNodeQ234 list1 = new ListNodeQ234(1);
        list1.next = new ListNodeQ234(2);
        list1.next.next = new ListNodeQ234(3);
        list1.next.next.next = new ListNodeQ234(2);
        list1.next.next.next.next = new ListNodeQ234(1);

        // Test the isPalindrome method
        PalindromeLinkedList_Q234 palindromeChecker = new PalindromeLinkedList_Q234();
        boolean isPalindrome = palindromeChecker.isPalindrome(list1);

        // Display the result
        if (isPalindrome) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
