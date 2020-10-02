package CodeLabProblems.Stack;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        path = simplifyPath(path);
        System.out.println(path);
    }

    public static String simplifyPath(String path) {
        /*
        * Given an absolute path for a file (Unix-style), simplify it.
        * Or in other words, convert it to the canonical path.
        *
        *
        * White board:
        *   - /../ -> /
        *   - .. means to go back 1 directory level
        *   - 2 slashes consecutively, do thing
        *   - absolute path -> always start with a '/'
        *
        * algo:
        *   - Initialize a string result to build upon that is initially ""
        *   = Initialize a stack of string to keep track of the last level of directory
        *   - traverse the direcotry pass
        *       - get the substring of the current string for a complete level (start with a /, end before the next /)
        *         and push it into the stack
        *       - if current sequence is "/..", "/." or "/", pop the element
        *       - otherwise append the substring to the result
        *   - return
        * */

        String result = "";
        path += "/";
        int subSequenceStart = 0;
        int subSequenceEnd = 0;
        Stack<String> strStack = new Stack<>();
        for (int i = 0; i < path.length(); i++) {
            if ( i == path.length() - 1 || (path.charAt(i) == '/' && subSequenceEnd != 0)) {
                String subSequence = path.substring(subSequenceStart, subSequenceEnd + 1);
                if (needToPop(subSequence)) {
                    if (!strStack.isEmpty()) {
                        strStack.pop();
                    }
                } else if (!stayAtCurrent(subSequence)) {
                    strStack.push(subSequence);
                }
                subSequenceStart = i;
            }
            if (path.charAt(i) != '/') {

                subSequenceEnd = i;
            }
        }
        if (strStack.isEmpty()) {
            strStack.push("/");
        }
        strStack = reverseStack(strStack);
        while(!strStack.isEmpty()) {
            result += strStack.pop();
        }
        return result;
    }

    public static boolean stayAtCurrent(String subSequence) {
        return subSequence.equals("/.") || subSequence.equals("/");
    }

    public static boolean needToPop(String subSequence) {
        return subSequence.equals("/..") || subSequence.equals("..");
    }

    public static Stack<String> reverseStack(Stack<String> stack) {
        Stack<String> result = new Stack<>();
        while (!stack.isEmpty()) {
            result.push(stack.pop());
        }
        return result;
    }
}
