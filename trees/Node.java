package trees;

public class Node {

    private int data;
    private Node leftChild;
    private Node rightChild;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setLeftChild(Node l) {
        leftChild = l;
    }

    public void setRightChild(Node r) {
        rightChild = r;
    }

    public Node getLeftChild(){
        return leftChild;
    }

    public Node getRightChild(){
        return rightChild;
    }
}
