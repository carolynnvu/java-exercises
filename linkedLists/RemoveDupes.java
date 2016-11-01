package linkedLists;

public class RemoveDupes {

    //Runtime: O(N^2)
    public static void solution(SinglyLinkedList s) {
        if(s == null || s.head == null) {
            return ;
        }

        //Start nodes at same node
        Node p1 = s.head;
        Node p2 = null;


        while(p1 != null) {
            p2 = p1.next;
            while(p2.next != null) {
                if(p1.data == p2.next.data) {
                    p2.next = p2.next.next;
                } else {
                    p2 = p2.next;
                }

            }
            p1 = p1.next;
        }
    }
}
