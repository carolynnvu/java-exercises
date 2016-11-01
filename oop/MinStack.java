package oop;

import java.util.PriorityQueue;

public class MinStack {

    private StackNode top = null;
    private int minValue;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MinStack() {}

    public void push(int x) { // O(log N)
        if(top == null) top = new StackNode(x);
        StackNode temp = top;
        top = new StackNode(x);
        top.setPreviousNode(temp);
        minHeap.add(x);
    }

    public void pop() { // O(log N)
        int data = top.getData();
        minHeap.remove(data);
        top = top.getPreviousNode();
    }

    public int top() { // O(1)
        return top.getData();
    }

    public int getMin() { // O(1)
        return minHeap.peek();
    }
}

class StackNode {
    private StackNode previous = null;
    private int data;

    public StackNode(int d) {
        data = d;
    }

    public void setPreviousNode(StackNode n) {
        if(n == null) throw new RuntimeException("Invalid node!!!!");
        previous = n;
    }

    public StackNode getPreviousNode() {
        return previous;
    }

    public int getData() {
        return data;
    }
}

