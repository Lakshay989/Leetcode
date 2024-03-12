import java.util.HashMap;
import java.util.Map;


//Definition for singly-linked list.
class ListNodeQ1171 {
    int val;
    ListNodeQ1171 next;
    ListNodeQ1171() {}
    ListNodeQ1171(int val) { this.val = val; }
    ListNodeQ1171(int val, ListNodeQ1171 next) { this.val = val; this.next = next; }
}

public class RemoveZeroSumConsecutiveNodesFromLinkedList_Q1171 {
    public ListNodeQ1171 removeZeroSumSublists(ListNodeQ1171 head) {
        ListNodeQ1171 front = new ListNodeQ1171(0, head);
        ListNodeQ1171 current = front;
        int prefixSum = 0;
        Map<Integer, ListNodeQ1171> prefixSumToNode = new HashMap<>();
        while (current != null) {
            // Add current's value to the prefix sum
            prefixSum += current.val;

            // If prefixSum is already in  the hashmap,
            // we have found a zero-sum sequence:
            if (prefixSumToNode.containsKey(prefixSum)) {
                ListNodeQ1171 prev = prefixSumToNode.get(prefixSum);
                current = prev.next;

                // Delete zero sum nodes from hashmap
                // to prevent incorrect deletions from linked list
                int p =  prefixSum + current.val;
                while (p != prefixSum) {
                    prefixSumToNode.remove(p);
                    current = current.next;
                    p +=  current.val;
                }

                // Make connection from the node before
                // the zero sum sequence to the node after
                prev.next = current.next;
            } else {
                // Add new prefixSum to hashmap
                prefixSumToNode.put(prefixSum, current);
            }
            // Progress to next element in list
            current = current.next;
        }
        return front.next;
    }

    public static void main(String[] args) {
        RemoveZeroSumConsecutiveNodesFromLinkedList_Q1171 solution = new RemoveZeroSumConsecutiveNodesFromLinkedList_Q1171();

        // Test case 1
        ListNodeQ1171 head1 = new ListNodeQ1171(1);
        head1.next = new ListNodeQ1171(2);
        head1.next.next = new ListNodeQ1171(-3);
        head1.next.next.next = new ListNodeQ1171(3);
        head1.next.next.next.next = new ListNodeQ1171(1);
        ListNodeQ1171 result1 = solution.removeZeroSumSublists(head1);
        System.out.println("Test case 1: " + (toString(result1).equals("3 -> 1 -> ") ? "Passed" : "Failed"));

        // Test case 2
        ListNodeQ1171 head2 = new ListNodeQ1171(1);
        head2.next = new ListNodeQ1171(2);
        head2.next.next = new ListNodeQ1171(3);
        head2.next.next.next = new ListNodeQ1171(-3);
        head2.next.next.next.next = new ListNodeQ1171(-2);
        ListNodeQ1171 result2 = solution.removeZeroSumSublists(head2);
        System.out.println("Test case 2: " + (toString(result2).equals("1 -> ") ? "Passed" : "Failed"));

        // Test case 3
        ListNodeQ1171 head3 = new ListNodeQ1171(1);
        head3.next = new ListNodeQ1171(-1);
        ListNodeQ1171 result3 = solution.removeZeroSumSublists(head3);
        System.out.println("Test case 3: " + (toString(result3).equals("") ? "Passed" : "Failed"));
    }

    public static String toString(ListNodeQ1171 head) {
        StringBuilder sb = new StringBuilder();
        ListNodeQ1171 current = head;
        while (current != null) {
            sb.append(current.val).append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
}
