package CodeLabProblems.LinkedList;
import DataStructure.*;

public class InsertCircular {
    public static void main(String[] args) {
        Integer nums[] = {1 ,3, 5};
        int insertVal = 4;
        CustomLinkList list = new CustomLinkList(nums, true);
        CustomListNode back = list.getBack();
        back.next = list.front;
        System.out.println(list.toString());
        list.front = insertCircular(list.front, insertVal);
        list.updateSize(1);
        System.out.println(list.toString());
    }

    public static CustomListNode<Integer> insertCircular(CustomListNode<Integer> head, int insertVal) {
        /*
        * Insert into a Sorted Circular Linked List
        *
        * Traverse through the list and find the best place to insert node
        * exit condition: when node is inserted
        * */
        CustomListNode<Integer> newNode = new CustomListNode<>(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        CustomListNode<Integer> curr = head;
        while(newNode.next == null) {
            if (insertVal >= curr.data && insertVal <= curr.next.data) {
                CustomListNode<Integer> temp = curr.next;
                curr.next = newNode;
                newNode.next = temp;
            }
            curr = curr.next;

        }
        return head;
    }
}
