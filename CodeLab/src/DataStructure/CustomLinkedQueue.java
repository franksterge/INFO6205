package DataStructure;

public class CustomLinkedQueue<T> {
    private CustomListNode<T> front;
    private CustomListNode<T> back;
    private int size;

    public CustomLinkedQueue() {
        this.size = 0;
    }

    public void add(T data) {
        CustomListNode<T> temp = new CustomListNode(data);
        if (this.front == null) {
            this.front = temp;
        } else {
            this.back.next = temp;
        }
        this.back = temp;
        this.size += 1;
    }

    public T remove() {
        T result = this.front.data;
        front = front.next;
        return result;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}
