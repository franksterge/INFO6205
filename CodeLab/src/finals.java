import DataStructure.CustomListNode;

import java.util.*;

public class finals {

    //    #1
    public String addStrings(String num1, String num2){
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

    //    #2
    public static CustomListNode<Integer> mergeTwoLists (CustomListNode<Integer> l1, CustomListNode<Integer> l2) {

        CustomListNode<Integer> curr1 = l1;
        CustomListNode<Integer> curr2 = l2;
        if (curr1 == null) {
            return curr2;
        }
        if (curr2 == null) {
            return curr1;
        }
        CustomListNode<Integer> prev = new CustomListNode<>(-1);

        CustomListNode<Integer> result = prev;
        while (curr1 != null && curr2 != null) {
            if (curr1.data <= curr2.data) {
                prev.next = curr1;
                curr1 = curr1.next;
            } else {
                prev.next = curr2;
                curr2 = curr2.next;

            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return result.next;
    }
    //    #3
    public String removeDuplicates(String s, int k) {
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

//    #5
//    TODO: COME BACK TO THIS
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

    }

    //    public boolean isSubtree(TreeNode s, TreeNode t) {
//        return traverse(s,t);
//    }
//    public boolean equals(TreeNode x,TreeNode y)
//    {
//        if(x==null && y==null)
//            return true;
//        if(x==null || y==null)
//            return false;
//        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
//    }
//    public boolean traverse(TreeNode s,TreeNode t)
//    {
//        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
//    }

//    #6
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> sumSet = new HashSet<>();
        return findTarget(root, k, sumSet);
    }

    private boolean findTarget(TreeNode root, int k, Set<Integer> sumSet) {

        if (root == null) {
            return false;
        }
        if (sumSet.contains(k - root.val)) {
            return true;
        }
        sumSet.add(root.val);
        return findTarget(root.left, k, sumSet) || findTarget(root.right, k, sumSet);
    }

//    #7
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

//    #8
    public int numIslands(char[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int result = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (grid[i][j] == '1') {
                    result += 1;
                }
                updateGrid(grid, i, j);
            }
        }
        return result;
    }

    private void updateGrid(char[][] grid, int hPosition, int vPosition) {
        if (hPosition < 0 || vPosition < 0 || hPosition == grid.length || vPosition == grid[0].length) {
            return;
        }

        grid[hPosition][vPosition] = '0';
        updateGrid(grid, hPosition - 1, vPosition);
        updateGrid(grid, hPosition + 1, vPosition);
        updateGrid(grid, hPosition, vPosition - 1);
        updateGrid(grid, hPosition, vPosition + 1);

    }

//    #9
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] relation: prerequisites) {

            if (prereq.containsKey(relation[1])) {
                prereq.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> possibleClasses = new ArrayList<>();
                possibleClasses.add(relation[0]);
                prereq.put(relation[1], possibleClasses);
            }
        }

        boolean[] checked = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
            if (this.isCyclic(currCourse, prereq, checked, path))
                return false;
        }
//
        return true;
    }
    private boolean isCyclic(
            Integer currCourse, Map<Integer, List<Integer>> courseDict,
            boolean[] checked, boolean[] path) {

        if (checked[currCourse])
            return false;
        if (path[currCourse])
            return true;

        if (!courseDict.containsKey(currCourse))
            return false;

        path[currCourse] = true;

        boolean ret = false;
        for (Integer child : courseDict.get(currCourse)) {
            ret = this.isCyclic(child, courseDict, checked, path);
            if (ret)
                break;
        }

        path[currCourse] = false;

        checked[currCourse] = true;
        return ret;
    }

//    #10
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(
                end,
                (a, b) -> a - b);

        Arrays.sort(
                start,
                (a, b) -> a - b);

        int startIndex = 0;
        int endIndex = 0;

        int usedRooms = 0;

        while (startIndex < intervals.length) {

            // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
            if (start[startIndex] >= end[endIndex]) {
                usedRooms -= 1;
                endIndex += 1;
            }
            usedRooms += 1;
            startIndex += 1;
        }
        return usedRooms;
    }


}

// #4
class WordBoard {

    private char[][] board;
    private int ROWS;
    private int COLS;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row)
            for (int col = 0; col < this.COLS; ++col)
                if (this.backtrack(row, col, word, 0))
                    return true;
        return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) {
        if (index >= word.length())
            return true;

        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
                || this.board[row][col] != word.charAt(index))
            return false;

        boolean ret = false;
        this.board[row][col] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
            if (ret)
                break;
        }

        this.board[row][col] = word.charAt(index);
        return ret;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
      }
  }