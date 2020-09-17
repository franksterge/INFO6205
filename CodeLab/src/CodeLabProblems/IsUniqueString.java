package CodeLabProblems;
import java.util.*;

public class IsUniqueString {
    public static void main(String[] args) {
        String testStr = "Hello, world";
        System.out.println(isUniqueString(testStr));
    }

    public static boolean isUniqueString(String str) {
         /*
         * Is Unique: Implement an algorithm to determine if a string has all unique characters.
         *
         *   Brute force:
         *       - nest 2 for loops to check for unique ness - O(n^2)
         *
         *   Improvement:
         *       - use hashset to store new character when traversing and if the next character is already in the set,
         *         return false; otherwise return true - O(n)
         *
         * */
        HashSet<Character> charSet = new HashSet<Character>();
        for (char charr : str.toCharArray()) {
            if (charSet.contains(charr)) {
                return false;
            }
            charSet.add(charr);
        }
        return true;
    }
}
