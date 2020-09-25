package CodeLabProblems.Array;

public class TwoSumProblems {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumProblems(nums, 9);
    }

    public static int[] twoSumProblems(int[] nums, int target) {
        /*
         *  Leetcode 1
         *  Given an array of integers nums and an integer target, return indices of the two numbers such that they
         * add up to target.
         *
         * brute force
         * TODO: OPTIMIZE
         * Algo:
         *  - 2 indeces, one at beginning of array, one at the end, move if either side is
         *    over the target
         *      runtime O(n)
         * */
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
