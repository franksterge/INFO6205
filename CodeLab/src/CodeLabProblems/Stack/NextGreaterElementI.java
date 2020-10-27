package CodeLabProblems.Stack;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

    public static void main(String[] args) {


    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    /*
    * white board:
    *
    * brute force:
    *   - traverse through the first list and for each element in nums1, traverse through nums2 to find bigger element
    *
    * stack:
    *   - initialize a stack, and a map to keep track of the next greater number
    *   - iterate through num2
    *       pop stack until seeing an element that is smaller or equal to the current element or when it's empty
    *       push the current element into the stack
    *   - pop any left over elements in the stack and record -1 in the map
    *   - traverse through num1
    *       get the mapped value
    *
    *   TODO: REVIEW THIS PROBLEM
    * */
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
