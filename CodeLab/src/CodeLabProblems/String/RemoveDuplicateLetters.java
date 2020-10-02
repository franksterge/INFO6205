package CodeLabProblems.String;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "bbcaacc";
        s = removeDuplicateLetters(s);
        System.out.println(s);
    }

    public static String removeDuplicateLetters(String s) {
    /*
    * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears
    * once and only once. You must make sure your result is the smallest in lexicographical order among all
    * possible results.
    *
    * White board:
    *   - how to ensure each unique character is inserted -
    *   - how to ensure only 1 of them is inserted - hashset (uniqueness)
    *
    * algo:
    *   - construct a queue
    *   - traverse through the string
    *   - if the first element in queue is greater than current character, remove top element from queue and add
    *     current character
    *
    * TODO: review this problem
    * */
        Queue<String> strQueue = new LinkedList<>();
        String result = "";
        if (s.equals("") || s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            String curr = s.substring(i, i + 1);
            String front = strQueue.peek();
            if (i != 0 && front.charAt(0) == curr.charAt(0)) {
                strQueue.remove();
            }
            if (!strQueue.contains(curr)) {
                strQueue.add(curr);
            }
        }
        while(!strQueue.isEmpty()) {
            result += strQueue.remove();
        }
        return result;
    }
}
