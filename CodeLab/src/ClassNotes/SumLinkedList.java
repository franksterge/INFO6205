package ClassNotes;
import DataStructure.CustomListNode;

public class SumLinkedList {
    public static void main(String[] args) {
        int list1[] = {3, 4, 2};
        int list2[] = {4, 6, 5};

        CustomListNode front1 = new CustomListNode(3);
        front1.next = new CustomListNode(4);
        front1.next.next = new CustomListNode(2);

        CustomListNode front2 = new CustomListNode(4);
        front2.next = new CustomListNode(6);
        front2.next.next = new CustomListNode(5);

        CustomListNode result = sumLinkedList(front1, front2);
        while(result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }

    public static CustomListNode sumLinkedList(CustomListNode list1, CustomListNode list2) {
        CustomListNode result = privateSum(list1, list2, null);
        return result;
    }

    public static CustomListNode privateSum(CustomListNode list1, CustomListNode list2, CustomListNode result) {
        /*
        * recursive to get the sum for each digit;
        * if there is carry, result.next.data += 1;
        * */
        if (list1 == null && list2 == null) {
            return result;
        } else{
            if (list1 == null) {
                list1 = new CustomListNode(0);
            }
            if (list2 == null) {
                list2 = new CustomListNode(0);
            }
            int digit = list1.data + list2.data;
            if (result == null) {
                result = new CustomListNode(digit % 10);
            } else {
                digit += result.data;
                int currDigit = digit % 10;
                result.data = currDigit;
            }
            if (digit >= 10) {
                result.next = new CustomListNode(1);
            }
            result.next = privateSum(list1.next, list2.next, result.next);
            return result;
        }
    }
}
