package CodeLabProblems.Stack;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        /*
        * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
        * determine if the input string is valid.
        *
        * An input string is valid if:
        *   Open brackets must be closed by the same type of brackets.
        *   Open brackets must be closed in the correct order.
        *
        * White board:
        *   - brute force: traverse the string and search for open/close brackets (n^2)
        * algo:
        *   - initializes value of each bracket characters and get difference between bracket characters
        *   - make a stack and traverse the string.
        *       - if current character matches any starting bracket, push character into stack
        *       - if current character matches any returning bracket, peek stack and see the last bracket character
        *         test if the difference between the two is d and return false if not
        *   - check if the stack is empty, return false if it is not
        *   - return true
        * */
        Stack<Character> bracketStack = new Stack<>();
        for (char curr: s.toCharArray()) {
            if (isStart(curr)) {
                bracketStack.push(curr);
            }
            if (isEnd(curr)) {
                if (bracketStack.isEmpty()) {
                    return false;
                }
                char top = bracketStack.peek();
                if (isPair(top, curr)) {
                    bracketStack.pop();
                } else {
                    return false;
                }
            }
        }
        return bracketStack.isEmpty();
    }

    public static boolean isStart(char curr) {
        return (curr == '(' || curr == '[' || curr == '{');
    }

    public static boolean isEnd(char curr) {
        return (curr == ')' || curr == ']' || curr == '}');
    }

    public static boolean isPair(char top, char curr) {
        return ((top == '(' && curr == ')') ||
                (top == '[' && curr == ']') ||
                (top == '{' && curr == '}'));
    }
}
