package DataStructure;

public class CustomListNode<T> {
    public T data;
    public CustomListNode<T> next;

    public CustomListNode() {}

    public CustomListNode(T data) {
        this.data = data;
        this.next = null;
    }
}
