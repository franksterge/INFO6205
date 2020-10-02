package CodeLabProblems.LinkedList;

import DataStructure.CustomLinkList;
import DataStructure.CustomListNode;

public class RemoveElements {
    public static void main(String[] args) {
        Integer nums[] = {1, 1, 6, 3, 4, 6, 6};
        int x = 6;
        CustomLinkList<Integer> list = new CustomLinkList<>(nums, false);
        System.out.println(list.toString());
        list.front = removeElements(list.front, x);
        System.out.println(list.toString());
    }

    public static CustomListNode<Integer> removeElements(CustomListNode<Integer> head, int val) {
        /*
        * Remove all elements from a linked list of integers that have value val.
        *
        * White board:
        *   - no specification on what the list looks like.
        *       - empty list
        *       - first item
        *           - same scenario as 1 item list
        *           - check for head.data
        *       - last item
        * Algo:
        *   - traverse through the entire list and check for matches
        *   - when checking use current.next.data to preserve previous nodes
        *   - set temp to be current.next.next to preserve following nodes
        * */

        if (head == null) {
            return head;
        }

        CustomListNode<Integer> current = head;
        while (head.data == val) {
            head = head.next;
            if (head == null) {
                return head;
            }
        }
        current = head;
        while (current.next != null) {
            if (current.next.data == val) {
                current.next = current.next.next;
            } else {
                    current = current.next;
            }
        }
        return head;



    }
}
