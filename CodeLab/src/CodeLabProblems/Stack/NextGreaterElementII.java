package CodeLabProblems.Stack;
import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElementII {
    public static void main(String[] args) {

    }

    public static int[] nextGreaterElementII(int[] nums) {
        /*
        * Cyclical array so find the nGE for the last element by traversing the array again
        * since there is duplicates in the array, we want to store indices into the stack instead
        * reference NGE by indices.
        * TODO: REVIEW THIS PROBLEM
        * */
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length * 2; i ++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                result[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return result;
    }
}
