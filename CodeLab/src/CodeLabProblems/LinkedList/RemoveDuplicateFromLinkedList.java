package CodeLabProblems.LinkedList;
import DataStructure.CustomListNode;

public class RemoveDuplicateFromLinkedList {
    public static void main(String[] args) {
        int list[] = {1, 2, 3, 3};
        CustomListNode front1 = new CustomListNode(1);
        CustomListNode curr = front1;
        for (int a: list) {
            curr.next = new CustomListNode(a);
            curr = curr.next;
        }

        front1 = removeDuplicate(front1);
        curr = front1;
        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static CustomListNode<Integer> removeDuplicate(CustomListNode<Integer> list) {
        if (list == null || list.next == null) {
            return list;
        }
        CustomListNode<Integer> curr = list;
        Integer currVal = curr.data;
        while (curr.next != null) {
            if (currVal == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                currVal = curr.next.data;
                curr = curr.next;
            }
        }
        return list;
    }
}

