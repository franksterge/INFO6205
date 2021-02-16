import DataStructure.CustomListNode;

import java.util.*;

public class BinaryTreeAssignment {
//    #1
    public boolean isSubPath(CustomListNode<Integer> head, TreeNode root) {
        return isSubPath(head, root, head);
    }

    private boolean isSubPath(CustomListNode<Integer> head, TreeNode root, CustomListNode<Integer> current) {
        if (current == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (current.data == root.val) {
            return isSubPath(head, root.left, current.next) || isSubPath(head, root.right, current.next);
        } else {
            current = head;
            return isSubPath(head, root.left, current) || isSubPath(head, root.right, current);
        }
    }

//  #2

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] result = walk(root);
        return result[1];
    }

    private int[] walk(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = walk(root.left);
        int[] right = walk(root.right);

        int subtreeSum = left[0] + right[0] + root.val;
        int tiltSum = left[1] + right[1] + Math.abs(left[0] - right[0]);

        return new int[]{subtreeSum, tiltSum};
    }

//    #3
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

//    #4
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode helper(int[] preorder,int preStart,int preEnd,int[]inorder,int inStart,int inEnd ){

        if(!(0<=preStart &&preStart<=preEnd && preEnd<preorder.length && 0<=inStart &&inStart<=inEnd && inEnd <inorder.length))
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIdx=0;
        for(int idx=0;idx<inorder.length;idx++){
            if(inorder[idx]==root.val){
                inIdx=idx;
                break;
            }
        }
        root.left=helper(preorder,preStart+1,preStart+(inIdx-1-inStart+1),inorder,inStart,inIdx-1);
        root.right=helper(preorder,preStart+(inIdx-1-inStart+1)+1,preEnd,inorder,inIdx+1,inEnd);
        return root;
    }

    //  #5
    public  int treeDiameter(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return 0;
        }
        ArrayList<Integer>[] adjList = new ArrayList[edges.length + 1];
        for (int[] edge : edges) {
            if (adjList[edge[0]] == null) {
                adjList[edge[0]] = new ArrayList<>();
            }
            adjList[edge[0]].add(edge[1]);

            if (adjList[edge[1]] == null) {
                adjList[edge[1]] = new ArrayList<>();
            }
            adjList[edge[1]].add(edge[0]);

        }

        int[] res = bfs(adjList, edges[0][0]);
        res = bfs(adjList, res[1]);
        return res[0];
    }

    private  int[] bfs(ArrayList<Integer>[] adjList, int key) {
        Set<Integer> seen = new HashSet<>();
        int level = -1;
        int farthestNode = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(key);
        while (queue.size() > 0) {
            level++;
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                int val = queue.poll();
                if (seen.add(val) == false) {
                    continue;
                }
                farthestNode = val;
                for (int child : adjList[val]) {
                    if (seen.contains(child) == false) {
                        queue.add(child);
                    }
                }

            }
        }
        return new int[]{level, farthestNode};
    }
}
