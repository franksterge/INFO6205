package datastructure;

public class ListNode {
    public int data;
    public Node next;
    public Node prev;

    private Node(){}

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
