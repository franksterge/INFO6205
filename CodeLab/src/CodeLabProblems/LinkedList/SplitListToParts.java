package CodeLabProblems.LinkedList;
import DataStructure.CustomLinkList;
import DataStructure.CustomListNode;

public class SplitListToParts {
    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3};
        CustomLinkList<Integer>list = new CustomLinkList<>(nums, false);
        System.out.println(list.toString());
        CustomListNode[] result = splitListToParts(list.front, 5);
//        TODO: add custom toString() method
    }

    public static CustomListNode[] splitListToParts (CustomListNode<Integer> root, int k) {
        /*
        * leetcode 725
        * Given a (singly) linked list with head node root,
        * write a function to split the linked list into k consecutive linked list "parts".
        *
        * White board:
        *   - no cycle: traversing using 1 current
        *   - modular: decide how many sublists will have 1 extra node
        *       3 % 5 = 3
        *   - range of list is from 0 to int lim, no long assigned.
        *   - when it's null,
        * Solution 1:
        *   - set up a counter and find the length of the list l
        *   - get the number of longer sublists by l % k
        *   - have a counter for current index in the list of the retuning sublist.
        *   - traverse list again with a counter that updates each time an extra node is added
        *     to a sublist to the number in step 2.
        *   - once increment array's index, clear the counter in step 4
        *   - return list
        *   runtime:
        *
        * */

        int listLength = 0;
        CustomListNode<Integer> curr = root;
        CustomListNode[] result = new CustomListNode[k];
        if (root == null) {
            return result;
        }
        if (root.next == null) {
            result[0] = root;
            return result;
        }
        // get list's length
        while (curr != null) { // O(n)
            curr = curr.next;
            listLength += 1;
        }
        // get indexes that needs 1 extra node
        curr = root;
        int indexesWithExtra = listLength % k;
        int arrayIndex = 0;
        int subListLength = listLength / k;
        if (subListLength == 0) {
            for (int i = 0; i < listLength; i++) { // O(
                CustomListNode<Integer> temp = curr;
                result[i] = curr;
                curr = curr.next;
                temp.next = null;
            }
            return result;
        }
//
        while (curr != null) {
            CustomListNode<Integer> temp = curr;
            for (int i = 0; i < subListLength - 1; i++) {
                curr = curr.next;
            }
            if (arrayIndex < indexesWithExtra) {
                curr = curr.next;
            }
            CustomListNode<Integer> temp2 = curr.next;
            curr.next = null;
            result[arrayIndex] = temp;
            arrayIndex += 1;
            curr = temp2;
        }
        return result;

    }



}
