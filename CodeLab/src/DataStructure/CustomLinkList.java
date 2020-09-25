package DataStructure;

public class CustomLinkList<T> {
    public CustomListNode<T> front;
    private CustomListNode<T> back;
    private int size;
    private boolean hasCycle;

    public CustomLinkList() {

    }

    public CustomLinkList(T[] nums, boolean hasCycle) {
        this.front = new CustomListNode<>(nums[0]);
        CustomListNode<T> curr = this.front;
        this.back = this.front;
        this.size = nums.length;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new CustomListNode<>(nums[i]);
            curr = curr.next;
            this.back = this.back.next;
        }
        this.hasCycle = hasCycle;
    }

    public void append (CustomListNode<T> node, boolean hasCycle) {
        back.next = node;
        this.hasCycle = hasCycle;
    }

    public String toString() {
        CustomListNode<T> curr = this.front;
        String listString = "";
        if (hasCycle) {
            for (int i = 0; i < this.size; i++) {
                listString = listString + curr.data + " -> ";
                curr = curr.next;
            }
            if (curr != null) {
                String dashes = "";
                for (int i = 0; i < this.size; i++) {
                    dashes += "----";
                }
                listString += "\n" + "|" + dashes;
            }
        } else {
            while (curr != null) {
                listString = listString + curr.data + " -> ";
                curr = curr.next;
            }
        }
        return listString;
    }

    public CustomListNode<T> getBack(){
        return this.back;
    }

    public CustomListNode<T> get(T element) {
        CustomListNode<T> node= this.front;
        while (node.data != element && node != null) {
            node = node.next;
        }
        return node;
    }

    public int getSize() {
        return this.size;
    }

    public void updateSize(int i) { this.size += 1; }
}
