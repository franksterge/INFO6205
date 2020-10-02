package CodeLabProblems.Stack;

import java.util.LinkedList;
import java.util.Stack;

public class OneThreeTwoPattern {


    public static boolean find132Pattern(int[] nums) {
        /*
        * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j]
        * and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j]. Return true if there is
        * a 132 pattern in nums, otherwise return false.
        *
        * algo:
        *   - put elements into a stack in reverse order
        *   - initialize a int mid
        *   - initialize a int high and low
        *   - traverse stack.
        *       - assign the popped element to be mid.
        *       - set high to be the peeked element
        *       - if high < mid,
        *           continue
        *       - other wise, set high to be peeked element and pop()
        *           - peek the next element. if it is smaller than mid, return true
        *           - put high back.
        * */
        Stack<Integer> intStack = new Stack<Integer>();
        for (int i = 0; i < nums.length; i++) {
            intStack.push(i);
        }
        int high;
        int mid;
        int low;
        while(!intStack.isEmpty()) {
            mid = intStack.pop();
            if (!intStack.isEmpty()) {
                high = intStack.peek();
                if (high <= mid) {
                    continue;
                } else {
                    high = intStack.pop();
                    low = intStack.peek();
                    if (low < mid) {
                        return true;
                    }
                    intStack.push(high);
                }
            }
        }
        return false;
    }
}
