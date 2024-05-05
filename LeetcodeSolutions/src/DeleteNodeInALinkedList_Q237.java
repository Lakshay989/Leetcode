class ListNodeQ237 {
    int val;
    ListNodeQ237 next;
    ListNodeQ237(int x) { val = x; }
  }

public class DeleteNodeInALinkedList_Q237 {
    public void deleteNode(ListNodeQ237 node) {
        node.val = node.next.val ;
        node.next = node.next.next ;
    }

    public static void main(String[] args) {
        // Create nodes for testing
        ListNodeQ237 head = new ListNodeQ237(1);
        ListNodeQ237 nodeToDelete = new ListNodeQ237(2);
        ListNodeQ237 tail = new ListNodeQ237(3);
        head.next = nodeToDelete;
        nodeToDelete.next = tail;

        // Print original list
        System.out.println("Original list:");
        printLinkedList(head);

        // Delete the node
        DeleteNodeInALinkedList_Q237 deleter = new DeleteNodeInALinkedList_Q237();
        deleter.deleteNode(nodeToDelete);

        // Print modified list
        System.out.println("\nList after deleting the node with value 2:");
        printLinkedList(head);
    }

    // Helper method to print the linked list
    public static void printLinkedList(ListNodeQ237 head) {
        ListNodeQ237 current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
