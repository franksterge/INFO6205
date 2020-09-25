package CodeLabProblems.LinkedList;
import DataStructure.CustomLinkList;
import DataStructure.CustomListNode;

public class DeleteNodeNoHead {
    public static void main(String[] args) {
        Integer nums[] = {4, 5, 1, 9};
        CustomLinkList list = new CustomLinkList<> (nums, false);
        System.out.println(list.toString());
        CustomListNode<Integer> nodeToDelete = list.get(5);
        CustomListNode<Integer> front = list.front;
        System.out.println(nodeToDelete.next.data);
        front.next = deleteNodeNoHead(nodeToDelete);
        System.out.println(list.toString());
    }

    public static CustomListNode<Integer> deleteNodeNoHead(CustomListNode<Integer>node) {
        /*
        * Write a function to delete a node in a singly-linked list. You will not be given access to the head
        * of the list, instead you will be given access to the node to be deleted directly.
        *
        * It is guaranteed that the node to be deleted is not a tail node in the list.
        *
        * Whiteboard:
        *   - given node cannot be the back, meaning node.next != null
        *   - always start more than 1 node
        *
        * Algo:
        *   - reverse the rest of the sub list from node
        *   - set node to be null
        *   - reverse the revered list and return it
        * */

        // reversing the sublist
        CustomListNode<Integer> current = node;
        current = current.next;
        node.next = null;
        CustomListNode<Integer> back = current;

        if (current.next != null) {
            current = current.next;
            back.next = null;
        }

        CustomListNode<Integer> temp = current.next;
        while (current != null) {
            temp = current.next;
            current.next = back;
            back = current;
            current = temp;
        }

        // reversing the undeleted sublist
        current = back;
        if (current.next != null) {
            current = current.next;
            back.next = null;
        }
        node = null;
        node = back; // also deleting the target
        while (current != null) {
            temp = current.next;
            current.next = node;
            node = current;
            current = temp;
        }
        return node;

    }

//    public static CustomListNode<Integer> reverseList(CustomListNode<Integer>)

    /*
    * This leetcode version of this problem cannot be done using the method above.
    * The problem involves changing the value in a node directly.
    * Solution to the leetcode version:
    * */
    public static void deleteNode(CustomListNode<Integer> node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
