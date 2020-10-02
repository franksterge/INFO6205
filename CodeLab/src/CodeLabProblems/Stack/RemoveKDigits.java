package CodeLabProblems.Stack;
import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "12345264";
        int k = 4;
        System.out.println(removeKDigits(num, k));
    }

    public static String removeKDigits(String num, int k) {
        /*
        * Given a non-negative integer num represented as a string,
        * remove k digits from the number so that the new number is the smallest possible.
        *
        * White board:
        *   - digits follows original order
        *   - leading 0 is deleted automatically without spending a digit
        *
        * Algo:
        *   - initialize a stack of string for all numbers
        *   - initialize a stack of string to assemble result
        *   - push each number in num into the stack
        *   - pop the stack to form a string of the target length
        *   - continue pop the stack and compare if each time extra number formed is smaller than the existing one
        *   - result
        * */

        if (num.length() == k) {
            return "0";
        }
        String result = "";
        Stack<String> allNumbers = new Stack<>();
        Stack<String> selected = new Stack<> ();
        for (int i = 0; i < num.length(); i++) {
            String number = num.substring(i, i+1);
            allNumbers.push(number);
        }

        int targetLength = num.length() - k;
        for (int i = 0; i < targetLength; i++) {
            selected.push(allNumbers.pop());
        }
        while(!selected.isEmpty()) {
            result += selected.pop();
        }
        while(!allNumbers.isEmpty()){
            String number = allNumbers.pop();
            String temp1 = number + result.substring(1);
            String temp2 = number + result.substring(0, result.length() - 1);
            int localMin = Math.min(Integer.parseInt(temp1), Integer.parseInt(temp2));
            int resultNum = Integer.parseInt(result);
            if (localMin < resultNum) {
                result = "" + localMin;
            }
        }
        return "" + Integer.parseInt(result);


    }
}
