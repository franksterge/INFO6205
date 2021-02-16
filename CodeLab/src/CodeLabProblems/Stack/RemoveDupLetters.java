package CodeLabProblems.Stack;

import java.util.Stack;

public class RemoveDupLetters {
    public static void main(String[] args) {

    }

    public static String RemoveDuplicatedLetters(String s, int k) {
    /*
    *  set up a counter for repeating letters
    *  push all letters into stack
    *  while stack is not empty:
    *   get next letter, increment counter if it is the same as stack.peek()
    *   append letter to string result
    *   if counter == k
    *       set result to be the substring(3) or ""
    *       push remaining letters into stack
    *  return result
    * */
        if (s.length() < k) {
            return s;
        }
        String result = "";
        int counter = 1;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.substring(i, i + 1));
        }
        result += stack.pop();

        while (!stack.isEmpty()) {
            if (stack.peek().equals(result.charAt(0) + "")) {
                counter += 1;
            } else {
                counter = 1;
            }
            result = stack.pop() + result;
            if (counter == k) {
                result = result.length() == k ? "" : result.substring(k);
                for (int i = 0; i < s.length(); i++) {
                    stack.push(s.substring(i, i + 1));
                }
                counter = 0;
            }
        }
        return result;
    }


}
