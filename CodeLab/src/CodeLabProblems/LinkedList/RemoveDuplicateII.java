package CodeLabProblems.LinkedList;
import DataStructure.CustomListNode;
import DataStructure.CustomLinkList;

public class RemoveDuplicateII {
    public static void main(String[] args) {
        Integer nums[] = {2,2};
        CustomLinkList<Integer> list = new CustomLinkList<>(nums, false);
        System.out.println(list.toString());
        list.front = remove(list.front);
        System.out.println(list.toString());
    }

    public static CustomListNode<Integer> remove(CustomListNode<Integer> head) {
    /*
    * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
    *
    * Return the linked list sorted as well.
    *
    * Whiteboard
    * - sorted list = all elements that I need to delete are next to each other.
    * - list can have any number of nodes = edge cases
    *   - if there is 1 element in teh list -> return head
    *   - if first k elements are repeating, move front
    *
    * algo 1:
    *   - set up current pointing to front to traverse the list
    *   - set up a counter for the previous data `prev`
    *   - set up a counter for list length
    *   - traverse list from 1st element
    *       - if list length is 1 and matching at the 2nd element (current.next):
    *           - set front to be the next element, not update counter length
    *       - if matiching in the middle
    *           - skip the next node
    *       - otherwise go to the next element
    *
    * */
        if (head == null || head.next == null) {
            return head;
        }

        CustomListNode<Integer> current = head;
        CustomListNode<Integer> prev = head;
        int prevData = Integer.MAX_VALUE;
        int uniqueIndex = 0;

        while (current.next != null) {
            if (current.data == current.next.data || prevData == current.data) {
                if (uniqueIndex == 0) {
                    head = head.next;
                } else {
                    prev.next = current.next;
                }

            } else {
                uniqueIndex += 1;
                prev = current;
            }
            prevData = current.data;
            current = current.next;

        }
        if (current.data == prevData) {
            if (head != current) {
                prev.next = null;
            } else {
                head = head.next;
            }
        }
        prev = null;
        return head;
    }
}
