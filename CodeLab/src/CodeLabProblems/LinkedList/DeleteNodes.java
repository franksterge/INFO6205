package CodeLabProblems.LinkedList;
import DataStructure.*;

public class DeleteNodes {
    public static void main(String[] args) {
        Integer nums[] = {9, 3, 7, 7, 9, 10, 8, 2};
        CustomLinkList<Integer> list = new CustomLinkList<>(nums, false);
        System.out.println(list.toString());
        list.front = deleteNodes(list.front, 1, 2);
        System.out.println(list.toString());
    }

    public static CustomListNode<Integer> deleteNodes(CustomListNode<Integer> head, int m, int n) {
        /*
        * Given the head of a linked list and two integers m and n.
        * Traverse the linked list and remove some nodes in the following way:
            Start with the head as the current node.
            Keep the first m nodes starting with the current node.
            Remove the next n nodes
            Keep repeating steps 2 and 3 until you reach the end of the list.
            Return the head of the modified list after removing the mentioned nodes.
        *
        * traverse list with 2 counters
        *
        * */

        if (head.next == null) {
            return head;
        }

        CustomListNode<Integer> curr = head;
        while (curr != null) {
            CustomListNode<Integer> temp = curr;
            for (int i = 0;i < (m + n); i++) {
                if (curr.next != null && i < m - 1) {
                    curr = curr.next;
                }
                if (temp != null) {
                    temp = temp.next;
                }
            }
            curr.next = temp;
            curr = temp;
        }
        return head;
    }
}
