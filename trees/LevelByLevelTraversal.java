package trees;

import java.util.*;

public class LevelByLevelTraversal {

    public static void solution(Node root) {
        if(root == null) return ;

        Deque<Node> q = new ArrayDeque<Node>();
        q.addFirst(root);
        Node currNode = null;

        while(!q.isEmpty()) {
            currNode = q.peekFirst();

            if(currNode.getLeftChild() != null) {
                q.addLast(currNode.getLeftChild());
            }

            if(currNode.getRightChild() != null) {
                q.addLast(currNode.getRightChild());
            }

            System.out.printf("%4d ", currNode.getData());
            q.removeFirst();
        }
        System.out.println();
    }

    public static void test() {
        Node tree = new Node(1);
        tree.setLeftChild(new Node(2));
        tree.setRightChild(new Node(3));
        tree.getLeftChild().setLeftChild(new Node(4));
        tree.getLeftChild().setRightChild(new Node(5));
        tree.getRightChild().setLeftChild(new Node(6));
        tree.getRightChild().setRightChild(new Node(7));
        solution(tree);

    }
}
