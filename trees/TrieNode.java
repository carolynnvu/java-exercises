package trees;

public class TrieNode {
    private char c;
    private int[] children = new int[26];
    boolean isALeaf;

    public TrieNode(){}

    public TrieNode(char c){
        this.c = c;
    }
}
