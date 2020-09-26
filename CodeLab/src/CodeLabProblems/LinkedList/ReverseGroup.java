package CodeLabProblems.LinkedList;

import DataStructure.CustomLinkList;
import DataStructure.CustomListNode;

public class ReverseGroup {
    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5};
        int x = 3;
        CustomLinkList list = new CustomLinkList<>(nums, false);
        System.out.println(list.toString());
        list.front = reverseGroup(list.front, x);
        System.out.println(list.toString());
    }

    public static CustomListNode<Integer> reverseGroup(CustomListNode<Integer> head, int k) {
        /*
        * Given a linked list, reverse the nodes of a linked list k at a time
        * and return its modified list.
        *
        *
        * White board:
        *   - k <= length of the list
        *   - write a helper function to reverse a given list node
        *       - take in number of nodes to be reversed to stop
        *       - initialize a back set to node
        *       - step current node by 1
        *       - set back.next = null
        *       - loop sub list
        *           - set temp = current.next
        *           - set current.next = back
        *           - set back = current
        *           - set current = temp
        *   - edge cases:
        *       - when there is 1 or 0 node: return node
        *       - when there is not enough nodes in total: go through loop 0 time and return node
        *
        * solution 1:
        *  - get a counter for the length of the list
        *  - initialize a sublist counter that resets after each reversal
        *  - reverse in a while loop
        *  - use flag each time a sublist is reversed
        *
        * solution 2:
        *  - get a counter for the length of the list
        *  - get how many groups we need to reverse g
        *  - set current node = head
        *  - loop g times, each time call reverse helper and catch it with the current node
        *  - loop k times, each time traverse node by 1
        *  - return head
        *   runtime: O(n) + O(n) -> O(n)
        * */
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        int listLength = 0;
        CustomListNode<Integer> current = head;
        while(current != null) {
            listLength += 1;
            current = current.next;
        }
        int totalGroups = listLength/k;
        current = head;
        for (int i = 0; i < totalGroups; i++) {
            if (i == 0) {
                head = reverseSubNodes(head, k);
            } else {
                current.next = reverseSubNodes(current.next, k);
                for (int j = 0; j < k; j ++) {
                    current = current.next;
                }
            }
        }
        return head;
    }

    public static CustomListNode<Integer> reverseSubNodes(CustomListNode<Integer> head, int k) {
        CustomListNode<Integer> current = head.next;
        CustomListNode<Integer> back = head;
        CustomListNode<Integer> front = head;
        CustomListNode<Integer> temp = current.next;
//        front.next = temp;
//        back = current;
//        current = temp;
        for (int i = 0; i < k - 1; i++) {
//            if (current != null) {
            temp = current.next;
//            }
            current.next = back;
            front.next = temp;
            back = current;
            current = temp;
        }
        return back;

    }
}
