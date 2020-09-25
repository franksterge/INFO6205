package CodeLabProblems.LinkedList;
import DataStructure.CustomLinkList;
import DataStructure.CustomListNode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        Integer nums[] = {2,1,3,5,6,4,7};
        CustomLinkList<Integer>list = new CustomLinkList<>(nums, false);
        System.out.println(list.toString());
        list.front = oddEvenList(list.front);
        System.out.println(list.toString());
    }

    public static CustomListNode<Integer> oddEvenList(CustomListNode<Integer> head) {
        /*
        * Given a singly linked list, group all odd nodes together followed by the even nodes.
        * Please note here we are talking about the node number and not the value in the nodes.
        *
        * initialize counter, current
        * traverse list, if counter % 2 == 1, move to the bottom
        *
        * brute force:
        *  - move one by one when has a even index hit
        *
        * better:
        *   - reverse list
        *   - when reversing, move even index to its own list with reverse order
        *   - reverse 1st list with a reference to the back of the list
        *   - reverse even index list
        *   - attach back of 1st to the even list
        *
        * Takeaway:
        *   - reversing list can be useful when we need to take out a sequence of sublist
        * */
        //when the list's length is between 0-2
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        //otherwise
        CustomListNode<Integer> back = head;
        CustomListNode<Integer> evenBack = head.next;
        head = head.next.next;
        back.next = null;
        evenBack.next = null;
        CustomListNode<Integer> current = head;
        //reverse list
        while (current != null) {
            CustomListNode<Integer> temp = current;
            temp = temp.next;
            current.next = back;
            back = current;
            current = temp;
        //set even index its own list
            if (temp != null) {
                temp = temp.next;
                current.next = evenBack;
                evenBack = current;
                current = temp;
            }
        }

        head = back;
        back = back.next;
        head.next = null;
        current = back;
        // reverse the reversed list and get to the last node
        while(current != null) {
            CustomListNode<Integer> temp = current;
            temp = temp.next;
            current.next = head;
            head = current;
            current = temp;
        }
        back = back.next;
        CustomListNode<Integer> even = evenBack;
        evenBack = evenBack.next;
        current = evenBack;
        // reverse the reversed even list
        int count = 1;
        while(current != null) {
            CustomListNode<Integer> temp = current.next;
            if (count == 1) {
                even.next = null;
                count += 1;
            }
            current.next = even;
            even = current;
            current = temp;
        }
        back.next = even;
        return head;
    }
}
