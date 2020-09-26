package CodeLabProblems.LinkedList;

import DataStructure.CustomLinkList;
import DataStructure.CustomListNode;

public class ReorderList {
    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5, 6, 7};
        CustomLinkList<Integer> list = new CustomLinkList<>(nums, false);
        System.out.println(list.toString());
        list.front = reorderList(list.front);
        System.out.println(list.toString());
    }

    public static CustomListNode<Integer> reorderList(CustomListNode<Integer> head) {
        /*
        * Given 1->2->3->4, reorder it to 1->4->2->3.
        *
        * White board:
        *   Edge cases:
        *       - head is null
        *       - there is 1 element
        *
        * Solution 1:
        *   - traverse through the list to get the length
        *   - if length is odd, target length += 1
        *   - traverse through the list till the half way point
        *   - move to the next half of nodes into a stack
        *   - set a counter
        *   - traverse the first half, after one node processed, pop a node from the stack
        *   - set node in the previous step connected to the next node in the first half
        * Space complexity is O(n/2)
        *
        * Solution 2:
        *   - step 1 - 5 same
        *   - break off the list and reverse the second half
        *   - step 6 but remove first node of hte list
        * Space complexity is O(1)
        * */
        CustomListNode<Integer> current = head;
        int listLength = 0;
        while (current != null) {
            listLength += 1;
            current = current.next;
        }
        if (listLength <= 2) {
            return head;
        }
        int halfWayIndex = listLength / 2 - 1;
        if (listLength % 2 == 1) {
            halfWayIndex += 1;
        }
        current = head;
        for (int i = 0; i < halfWayIndex; i++) {
            current = current.next;
        }
        CustomListNode<Integer> halfWay = current;
        halfWay.next = reverseSubNode(halfWay.next);
        halfWay = halfWay.next;
        current.next = null;
        current = head;
        while(halfWay != null) {
            CustomListNode<Integer> temp = current.next;
            current.next = halfWay;
            halfWay = halfWay.next;
            current = current.next;
            current.next = temp;
            current = temp;
        }
        return head;
    }

    public static CustomListNode<Integer> reverseSubNode(CustomListNode<Integer> head) {
        if (head.next == null) {
            return head;
        }
        CustomListNode<Integer> front = head;
        CustomListNode<Integer> back = head;
        CustomListNode<Integer> curr = head.next;

        while(curr != null) {
            CustomListNode<Integer> temp = curr.next;
            back.next = temp;
            curr.next = front;
            front = curr;
            curr = temp;
        }
        return front;
    }
}
