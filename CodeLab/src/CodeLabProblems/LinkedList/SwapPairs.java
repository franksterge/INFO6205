package CodeLabProblems.LinkedList;

import DataStructure.CustomLinkList;
import DataStructure.CustomListNode;

public class SwapPairs {
    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5};
        CustomLinkList<Integer> list = new CustomLinkList<>(nums, false);
        System.out.println(list.toString());
        list.front = swapPairs(list.front);
        System.out.println(list);
    }

    public static CustomListNode<Integer> swapPairs(CustomListNode<Integer> head) {
    /*
    * Given a linked list, swap every two adjacent nodes and return its head.
    *
    * White board:
    *   - no restrictions on the length of the list
    *       - length is 0 or 1: return node
    *   - when there are odd number of nodes, leave out the last one
    *   - indexing issue
    *   - manipulate nodes with current.next to keep track of previous nodes
    *
    * solution:
    *   - set current to be head
    *   - make helper function to swap 2 nodes
    *   - traverse with current:
    *       - current.next = helperFunction()
    *   - indexing!!!!!
    *
    * */
        CustomListNode<Integer> current = head;
        int count = 0;
        if (current.next == null) {
            return head;
        }
        while (current.next != null) {
            if (count == 0) {
                head = swap(head);
                current = head.next;
            } else if (count % 2 == 1) {
                current.next = swap(current.next);
                current = current.next;
            } else if (count % 2 == 0) {
                current = current.next;
            }

            count += 1;
        }
        return head;
    }

    private static CustomListNode<Integer> swap(CustomListNode<Integer> curr) {
        if (curr.next != null) {
            CustomListNode<Integer> next = curr.next;
            CustomListNode<Integer> temp = next.next;
            next.next = curr;
            curr.next = temp;
            curr = next;
        }
        return curr;

    }
}
