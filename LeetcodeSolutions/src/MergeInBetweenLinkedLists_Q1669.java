//Definition for singly-linked list.
class ListNodeQ1669 {
    int val;
    ListNodeQ1669 next;
    ListNodeQ1669() {}
    ListNodeQ1669(int val) { this.val = val; }
    ListNodeQ1669(int val, ListNodeQ1669 next) { this.val = val; this.next = next; }
}

public class MergeInBetweenLinkedLists_Q1669 {
    public ListNodeQ1669 mergeInBetween(ListNodeQ1669 list1, int a, int b, ListNodeQ1669 list2) {
        ListNodeQ1669 first=list1;
        ListNodeQ1669 second=list1;
        ListNodeQ1669 ans=first;
        int i=1;int j=0;
        while(i<a){
            first=first.next;
            i++;
        }
        while(j<b){
            second=second.next;j++;
        }
        first.next=list2;
        ListNodeQ1669 cont=list2;

        while(cont.next!=null){
            cont=cont.next;
        }
        cont.next=second.next;
        return ans;
    }
    public static void main(String[] args) {
        // Create two linked lists for testing
        ListNodeQ1669 list1 = new ListNodeQ1669(1);
        list1.next = new ListNodeQ1669(2);
        list1.next.next = new ListNodeQ1669(3);
        list1.next.next.next = new ListNodeQ1669(4);
        list1.next.next.next.next = new ListNodeQ1669(5);

        ListNodeQ1669 list2 = new ListNodeQ1669(1000);
        list2.next = new ListNodeQ1669(2000);
        list2.next.next = new ListNodeQ1669(3000);

        // Display list1 before merging
        System.out.println("List 1 before merging:");
        printList(list1);

        // Test the mergeInBetween method
        MergeInBetweenLinkedLists_Q1669 merger = new MergeInBetweenLinkedLists_Q1669();
        ListNodeQ1669 mergedList = merger.mergeInBetween(list1, 2, 4, list2);

        // Display the merged list
        System.out.println("\nMerged list:");
        printList(mergedList);
    }

    // Helper method to print a linked list
    private static void printList(ListNodeQ1669 head) {
        ListNodeQ1669 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
