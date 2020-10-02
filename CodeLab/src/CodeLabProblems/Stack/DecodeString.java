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
        ArrayList<Character> resultList = new ArrayList<>();
        String result = "";
        char[] resultChar = new char[s.length()];
        for (char c : s.toCharArray()) {
            if (c != ']') {
                charStack.push(c);
            } else {
                int repeat = getRepeat(resultList, charStack);
                int listSize = resultList.size();
                for (int i = 0; i < repeat - 1; i++) {
                    for (int j = 0; j < listSize; j++) {
                        resultList.add(resultList.get(j));
                    }
                }

            }
        }
        char[] charArr = new char[resultList.size()];
        for (int i = resultList.size() - 1; i >= 0; i--) {
            charArr[resultList.size() - 1 - i] = resultList.get(i);
        }
        result = new String(charArr);
        return result;
    }

    public static int getRepeat(ArrayList<Character> resultStack, Stack<Character> charStack) {
        while (charStack.peek() != '[') {
            resultStack.add(charStack.pop());
        }
//        pop the [
        charStack.pop();
        int repeat = 0;
        while (!charStack.isEmpty() && isNumber(charStack.peek())) {
            repeat = repeat * 10 + charStack.pop() - '0';
        }
        if (repeat == 0) {
            repeat = 1;
        }
        return repeat;
    }

    public static boolean isNumber (char c) {
        return '0' <= c && '9' >= c;
    }

    public static Stack<String> reverseStack(Stack<String> st) {
        Stack<String> temp = new Stack<String>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        return temp;
    }
}
