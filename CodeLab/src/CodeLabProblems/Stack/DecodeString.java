package CodeLabProblems.Stack;
import java.util.*;

public class DecodeString {
    public static void main(String[] args) {
        String a = "3[a]2[bc]";
        System.out.println(decodeString(a));
    }

    public static String decodeString(String s) {
        /*
         *  White board:
         *   - a sequence is "int[int*char]"
         *   Algo:
         *       - Set a String num
         *       - Set a String sequence
         *       - Set a string result
         *       - traverse s
         *           - if it's a number,
         *               if number is "",
         *                   num = "1",
         *                   push sequence into stack,
         *                   push num into stack,
         *                   clear sequence
         *               num += charString
         *           - if it's a string, sequence += charString
         *           - if it's a bracket,
         *               - push sequence and then push num if num is not "" or "1"
         *               - clear the two variable,
         *               - cumulate until get closing bracket
         *
         * TODO: review this problem
         * */
        Stack<Character> charStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                charStack.push(c);
            } else {
                ArrayList<Character> currentSequence = new ArrayList<>();
                while (charStack.peek() != '[') {
                        currentSequence.add(charStack.pop());
                }
                charStack.pop();
                int repeat = 0;
                String repeatStr = "";
                while (!charStack.isEmpty() && charStack.peek() >= '0' && charStack.peek() <= '9') {
                    repeatStr  = charStack.pop() + repeatStr;
                }
                repeat = Integer.parseInt(repeatStr);
                for (int i = 0; i < repeat; i++) {
                    for (int j = currentSequence.size() - 1; j >= 0; j --) {
                        charStack.push(currentSequence.get(j));
                    }
                }
            }
        }

        char[] charArr = new char[charStack.size()];
        int i = charArr.length - 1;
        while (!charStack.isEmpty()) {
            charArr[i] = charStack.pop();
            i --;
        }
        return new String(charArr);
    }
}
