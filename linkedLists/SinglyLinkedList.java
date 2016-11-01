package linkedLists;
/*
  Search: O(N)
  Insertion: O(1)
  Deletion: O(1)
  Space Complexity: O(N)
 */

public class SinglyLinkedList {

    Node head = null;

    public SinglyLinkedList(Node h) {
        head = h;
    }

    public void appendToTail(int d) {
        head.appendToTail(d);
    }

    public Node deleteNode(int d) {
        Node n = head;

        if(n.data == d) {
            return head.next;
        }


        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}
