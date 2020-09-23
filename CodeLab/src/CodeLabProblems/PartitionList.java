package CodeLabProblems;
import DataStructure.*;

public class PartitionList {
    public static void main(String[] args) {
        Integer nums[] = {1, 4, 3, 2, 5, 2};
        int x = 3;
        CustomLinkList<Integer> list = new CustomLinkList<>(nums);
        System.out.println(list.toString());
        list.front = partiontionList(list.front, x);
        System.out.println(list.toString());
    }

    public static CustomListNode<Integer> partiontionList(CustomListNode<Integer> head, int x) {
        /*
        * Given a linked list and a value x, partition it such that all nodes less than x come before
        * nodes greater than or equal to x. You should preserve the original relative order of the
        * nodes in each of the two partitions.
        *
        * Solution 1:
        * - have 2 pointers pointed to the already parted index, 1 indicating parted side, 1 traverse the list
        * - when found one node, parted.next = curr
        * - end loop when traversed through whole list
        * - O(n)
        * */

        CustomListNode<Integer> parted = head;
        CustomListNode<Integer> curr = head;
        if (head == null) {
            return head;
        }

        // look for the first element that is less than x
        while (parted.next != null && parted.data >= x) {
            parted = parted.next;
        }

        while (curr.next != null) {
            if (curr.next.data < x) {
                CustomListNode<Integer> back = curr.next.next;
                CustomListNode<Integer> mid = parted.next;
                parted.next = curr.next;
                parted = parted.next;
                if (mid != parted) {
                    parted.next = mid;
                }
                curr.next = back;
            }

            if (curr.next != null) {
                curr = curr.next;
            }
        }
        return head;


    }
}
