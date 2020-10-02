package CodeLabProblems.Stack;

import DataStructure.NestedInteger;
import java.util.Stack;

public class NestedIntegerParser {
    public static void main(String[] args) {
        String s = "[123, [456, [789]]]";
        NestedInteger n = deserialize(s);
        System.out.println(n.toString());
    }

    public static NestedInteger deserialize(String s) {
//        TODO: review this problem
        Stack<String> strStack = new Stack<>();
        String currentNum = "";
        for (int i = 0; i < s.length(); i++) {
            String currentChar = s.substring(i, i + 1);
            if (isNumber(currentChar)) {
                currentNum += currentChar;
            } else if (currentChar.equals(",")) {
                strStack.push(currentNum);
                currentNum = "";
            } else if (currentChar.equals("[")) {
                strStack.push(currentChar);
            } else if (currentChar.equals("]")) {
                if (!currentNum.equals("")) {
                    strStack.push(currentNum);
                }
                currentNum = "";
                strStack.push(currentChar);
            }
        }
        strStack = reverseStack(strStack);

        NestedInteger result = buildNestedInteger(strStack, new NestedInteger());

        return result;
    }

    public static int stringToInt(String str) {
        return Integer.parseInt(str);
    }

    public static boolean isNumber(String str) {
        return !str.contains("[") && !str.contains("]") && !str.contains(",") && !str.equals("");
    }

    public static Stack<String> reverseStack(Stack<String> st) {
        Stack<String> temp = new Stack<>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        return temp;
    }

    public static NestedInteger buildNestedInteger(Stack<String> strStack, NestedInteger n) {
        if (!strStack.isEmpty()) {
            String current = strStack.pop();
            if (current.equals("[")) {
                n.add(new NestedInteger());
            } else if (isNumber(current)) {
                n.setInteger(Integer.parseInt(current));
            }
            for (NestedInteger ni: n.getList()) {
                ni = buildNestedInteger(strStack, ni);
            }
        }
        return n;


    }
}
