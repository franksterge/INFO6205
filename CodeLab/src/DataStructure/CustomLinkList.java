package DataStructure;
import DataStructure.CustomListNode;

public class CustomLinkList {
    public CustomListNode front;

    public CustomLinkList() {

    }

    public CustomLinkList(int[] nums) {
        this.front = new CustomListNode(nums[0]);
        CustomListNode curr = this.front;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new CustomListNode(nums[i]);
            curr = curr.next;
        }
    }

    public String toString() {
        CustomListNode curr = this.front;
        String listString = "" + curr.data;
        while (curr.next != null) {
            curr = curr.next;
            listString = listString + " -> " + curr.data;
        }
        return listString;
    }
}
