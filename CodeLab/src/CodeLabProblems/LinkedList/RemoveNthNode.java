package CodeLabProblems.LinkedList;
import DataStructure.CustomListNode;

public class RemoveNthNode {
    public static void main (String[] args) {
        CustomListNode front = new CustomListNode(1);
        front.next = new CustomListNode(2);
        front.next.next = new CustomListNode(3);
        front.next.next.next = new CustomListNode(4);
        front.next.next.next.next = new CustomListNode(5);
        front = removeNthFromEnd(front, 5);
        CustomListNode curr = front;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }

    }

    public static CustomListNode removeNthFromEnd(CustomListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        int counter = 1;
        CustomListNode curr = head;
        while (curr != null) {
            if (curr.next == null) {
                int steps = counter - n;
                if (steps == 0) {
                    return head.next;
                }
                CustomListNode newCurr = head;
                for (int i = 0; i < steps - 1; i++) {
                    newCurr = newCurr.next;
                }
                newCurr.next = newCurr.next.next;
            }
            counter += 1;
            curr = curr.next;
        }
        return head;
    }
}
