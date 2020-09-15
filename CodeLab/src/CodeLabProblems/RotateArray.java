package CodeLabProblems;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 8;
        arr = rotateArray(arr, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static int[] rotateArray(int[] arr, int k) {
        /*
        *  Given an array, rotate the array to the right by k steps, where k is non-negative.
        *  Whiteboard:
        *       steps   firstIndex to be wrapped                    last index moved to
        *       k       k from the last index -> arr.length - k     k - 1
         * */
        if (k > arr.length) {
            k = k % arr.length;
        }
        int[] wrapped = new int[k];
        for (int i = 0; i < k; i ++) {
            wrapped[i] = arr[arr.length - k + i];
        }
        for (int i = arr.length - k - 1; i >= 0 ; i --) {
            arr[i + k] = arr[i];
        }
        for (int i = 0; i < wrapped.length; i++) {
            arr[i] = wrapped[i];
        }
        return arr;
    }
}
