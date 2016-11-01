package trees;

import java.util.Arrays;

public class MinimalTree {

    /*
     * Given a sorted array of ints, produce a binary search tree with minimal height.
     */
    public static Node solution(int[] a) {
        if(a == null || a.length <= 0) {
            return null;
        }

        Node root = new Node(a[a.length/2]);
        root.setLeftChild(buildSubTree(a, 0, a.length/2 - 1));
        root.setRightChild(buildSubTree(a, a.length/2 + 1, a.length - 1));
        return root;
    }

    public static Node buildSubTree(int[] a, int lo, int hi) {
        if(lo > hi) return null;

        int mid = (hi + lo)/2; //Be careful! hi - lo messes up for the right subarray
        Node root = new Node(a[mid]);

        Node leftSubTree = buildSubTree(a, lo, mid - 1);
        root.setLeftChild(leftSubTree);
        Node rightSubTree = buildSubTree(a, mid + 1, hi); //We don't operate on mid because it's the new root
        root.setRightChild(rightSubTree);
        return root;
    }

    public static void test() {
        System.out.println("Test case 1");
        int[] test1 = { 100, 200, 300 };
        Node tree = solution(test1);
        preorderTraversal(tree);
        System.out.println();

        System.out.println("Test case 2");
        int[] test2 = { 11, 20, 45, 99 };
        tree = solution(test2);
        preorderTraversal(tree);
        System.out.println();
    }

    public static void preorderTraversal(Node n) {
        if(n != null) {
            System.out.println(n.getData());
            preorderTraversal(n.getLeftChild());
            preorderTraversal(n.getRightChild());
        }
    }
}
