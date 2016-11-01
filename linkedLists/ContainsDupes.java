package linkedLists;


import java.util.HashSet;
import java.util.Set;

public class ContainsDupes {

    public static boolean solution1(SinglyLinkedList s){
        if(s == null || s.head == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        Node tmp = s.head;

        while(tmp != null) {
            if(set.contains(tmp.data)) {
                return true;
            }
            set.add(tmp.data);
            tmp = tmp.next;
        }
        return false;
    }


    public static boolean solution2(SinglyLinkedList s) {
        if(s == null || s.head == null) {
            return false;
        }

        Node p1 = s.head; //Pointer 1 visits each node
        Node p2 = s.head.next; //Pointer 2 visits all the nodes after Pointer 1

        //Be careful...linked list may contain only one element so p2 could be NULL at this point.

        while(p1.next != null) {
            if(p2 == null) {
                return false;
            }

            int d1 = p1.data;
            while(p2 != null) {
                int d2 = p2.data;
                if(d1 == d2) {
                    return true;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
            p2 = p1.next;
        }
        return false;
    }

    public static void test() {
        Node head = new Node(1);
        SinglyLinkedList s = new SinglyLinkedList(head);
        s.appendToTail(2);
        s.appendToTail(3);
        s.appendToTail(4);

        System.out.println("Testing... ");
        System.out.println("Test case 1 - Should return false: " + ContainsDupes.solution1(s));
        System.out.println("Test case 2 - Should return false: " + ContainsDupes.solution2(s));

    }
}
