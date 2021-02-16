package CodeLabProblems.LinkedList;

import DataStructure.CustomListNode;

public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public static CustomListNode<Integer> mergeTwoLists (CustomListNode<Integer> l1, CustomListNode<Integer> l2) {
    /*
    *
    *
    * */
        CustomListNode<Integer> curr1 = l1;
        CustomListNode<Integer> curr2 = l2;
        if (curr1 == null) {
            return curr2;
        }
        if (curr2 == null) {
            return curr1;
        }
        CustomListNode<Integer> prev = new CustomListNode<>(-1);

        CustomListNode<Integer> result = prev;
        while (curr1 != null && curr2 != null) {
            if (curr1.data <= curr2.data) {
                 prev.next = curr1;
                 curr1 = curr1.next;
            } else {
                prev.next = curr2;
                curr2 = curr2.next;

            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return result.next;
    }
}
