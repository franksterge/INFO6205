package DataStructure;

public class CustomLinkedStack<T> {
    public CustomListNode<T> front;
    private int size;

    public CustomLinkedStack() {
        this.size = 0;
    }

    public void push(T val) {
        CustomListNode<T> current = new CustomListNode<T>(val);
        if (this.front == null) {
            this.front = current;
        } else {
            current.next = this.front;
            this.front = current;
        }
        this.size += 1;
    }

    public T pop() {
        T result = front.data;
        this.front = this.front.next;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
