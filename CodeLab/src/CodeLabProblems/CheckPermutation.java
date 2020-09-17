package CodeLabProblems;
import java.util.HashMap;

public class CheckPermutation {
    public static void main(String[] args){

    }

    public static boolean checkPermutation(String a, String b) {
        /*
        * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other
        *
        * Whiteboard
        *   is anagram if:
        *      - same group of characters
        *      - same number of each characters
        *   traverse first string, store character value into array
        *   traverse second string, if not contained in the array, return false
        *  */

        if (a.length() != b.length()) {
            return false;
        }
        char charArray[] = a.toCharArray();
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char charr: charArray) {
            if (charMap.containsKey(charr)) {
                charMap.put(charr, charMap.get(charr) + 1);
            } else {
                charMap.put(charr, 1);
            }
        }
        boolean is_anagram = true;
        for (char strChar: b.toCharArray()) {
            if (!charMap.containsKey(strChar) || charMap.get(strChar) < 0) {
                return false;
            } else if (charMap.get(strChar) == 0) {
                is_anagram &= true;
            }
            int charCount = charMap.get(strChar);
            charCount -= 1;
            charMap.put(strChar, charCount);
        }

        for (char charr: charMap.keySet()) {
            if (charMap.get(charr) != 0) {
                is_anagram &= false;
            }
        }

        return is_anagram;
    }
}
