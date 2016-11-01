package graphs;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class RouteBetweenNodes {

    /*
       Given a src and target node, find out if there is a route between src and target in a given graph.
       Solution below implements BFS --> O(|V| + |E|)
     */
    public static boolean solution(Node src, Node dest) {
        if(src == null || dest == null) return false;

        if(src == dest) return true;

        Deque<Node> q = new ArrayDeque<>();
        q.addFirst(src);
        Node tmp;

        while(!q.isEmpty()) {
            tmp = q.removeFirst();

            for(Node neighbor : tmp.neighbors) {
                if(!neighbor.visited) {
                    if(neighbor == dest) return true;
                    else {
                        q.addLast(neighbor);
                    }
                }
            }
            tmp.visited = true;
        }

        return false;
    }

    public static void test() {
        Node v1 = new Node(1);
        Node v2 = new Node(2);
        Node v3 = new Node(3);
        v1.neighbors.add(v2);
        v2.neighbors.add(v3);
        System.out.println("v1 has path to v3: " + solution(v1, v3));

        v1.visited = false;
        v2.visited = false;
        v3.visited = false;
        Node v4 = new Node(4);
        v1.neighbors.add(v4);
        v4.neighbors.add(v1);
        System.out.println("v4 has path to v3: " + solution(v4, v3));

        v4.neighbors.remove(v1);
        v2.visited = false;
        v3.visited = false;
        v4.visited = false;
        System.out.println("v4 does not have path to v3: " + !solution(v4, v3));
    }
}
