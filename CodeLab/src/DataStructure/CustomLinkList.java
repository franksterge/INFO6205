package DataStructure;

public class CustomLinkList<T> {
    public CustomListNode<T> front;
    private CustomListNode<T> back;
    private int size;

    public CustomLinkList() {

    }

    public CustomLinkList(T[] nums) {
        this.front = new CustomListNode<>(nums[0]);
        CustomListNode<T> curr = this.front;
        this.back = this.front;
        this.size = nums.length;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new CustomListNode<>(nums[i]);
            curr = curr.next;
            this.back = this.back.next;
        }
    }

    public String toString() {
        CustomListNode<T> curr = this.front;
        String listString = "";
        for (int i = 0; i < this.size; i++) {
            listString = listString + curr.data + " -> ";
            curr = curr.next;
        }
        if (curr.next != null) {
            String dashes = "";
            for (int i = 0; i < this.size; i++) {
                dashes += "----";
            }
            listString += "\n" + "|" + dashes;
        }
        return listString;
    }

    public CustomListNode<T> getBack(){
        return this.back;
    }

    public int getSize() {
        return this.size;
    }

    public void updateSize(int i) { this.size += 1; }
}
