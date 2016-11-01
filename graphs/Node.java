package graphs;

import java.util.List;
import java.util.ArrayList;

public class Node {

    List<Node> neighbors;
    int data;
    boolean visited;

    public Node(int data) {
        this.data = data;
        visited = false;
        neighbors = new ArrayList<>();
    }
}
