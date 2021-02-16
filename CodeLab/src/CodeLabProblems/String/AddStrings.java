package CodeLabProblems.String;

import java.util.Random;
import java.util.Stack;

public class AddStrings {

    public static void main(String[] args) {
        String num1 = "";
        Random r = new Random();
        for (int i = 0; i < 5098; i++) {
            num1 += r.nextInt(10);
        }

        String num2 = "";

        for (int i=0; i < 5098; i ++) {
            num2 += r.nextInt(10);
        }
        String sum = addStrings(num1, num2);

        System.out.println(sum);
        System.out.println(sum.length());

    }

    public static String addStrings(String num1, String num2) {
    /*
    * white board:
    *   - invalid number
    *       - assuming both numbers have only digits 0-9
    *       - no doubles
    *       - no leading 0
    *
    * Solution:
    *   - use 2 stacks to store digits stored as string
    *   - pop 1 digit at a time for both stacks if it is not empty
    *   - add them together, have a integer raise that updates
     */
        return addStringsStack(num1, num2);


    }

    private static String addStringsStack (String num1, String num2) {
        if (num1.length() == 0 && num2.length() == 0) { return "0";}
        String result = "";
        Stack<String> longNum = new Stack<>();
        Stack<String> shortNum = new Stack<>();
        longNum.push("0");
        shortNum.push("0");
        String longerNum = num1.length() >= num2.length() ? num1: num2;
        String shorterNum = num1.length() < num2.length() ? num1: num2;
        for (int i = 0; i < longerNum.length(); i++) {
            longNum.push(longerNum.substring(i, i + 1));
        }
        for (int i = 0; i < shorterNum.length(); i++) {
            shortNum.push(shorterNum.substring(i, i + 1));
        }

        int carry = 0;
        while(!longNum.isEmpty()) {
            String digitStr1 = longNum.pop();
            String digitStr2 = "0";
            if (!shortNum.isEmpty()) {
                digitStr2 = shortNum.pop();
            }
            int digit1 = Integer.parseInt(digitStr1);
            int digit2 = Integer.parseInt(digitStr2);
            int sum = carry + digit1 + digit2;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            if (!longNum.isEmpty()) {
                result = sum % 10 + result;
            }
        }

        return result;
    }



}
