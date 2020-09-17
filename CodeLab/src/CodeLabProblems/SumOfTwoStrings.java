package CodeLabProblems;

public class SumOfTwoStrings {
    public static void main(String[] args) {
        String num1 = "-1";
        String num2 = "-300";
        int result = sumOfTwoStrings(num1, num2);
        System.out.println(result);
    }

    public static int sumOfTwoStrings(String num1, String num2) {
        /*
         * Given 2 non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
         * */
        if (num1.equals("") || num1.length() < 2 || num2.equals("") || num2.length() < 2) {
            return 0;
        }
        if (num1.charAt(0) == '-') {
            num1 = num1.substring(1);
        }
        if (num2.charAt(0) == '-') {
            num2 = num2.substring(1);
        }
        int num1Int = convertString(num1.substring(1), 0) * -1;
        int num2Int = convertString(num2.substring(1), 0) * -1;
        return num1Int + num2Int;
    }

    public static int convertString(String numString, int result) {
        if (numString.length() == 0) {
            return result;
        } else {
            return convertString(numString.substring(1), result * 10 + (numString.charAt(0) - '0'));
        }
    }
}
