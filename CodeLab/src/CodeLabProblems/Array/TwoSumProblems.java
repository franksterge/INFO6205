package CodeLabProblems.Array;

import java.util.HashMap;
import java.util.Map;

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
         *
         * Algo:
         *  - 2 indeces, one at beginning of array, one at the end, move if either side is
         *    over the target
         *      runtime O(n)
         * use map. put the current element as key and index as value
         * if there is a match, return result
         * */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
    }
}
