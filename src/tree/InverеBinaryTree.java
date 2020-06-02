package tree;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

//Invert a binary tree.
//
//Example:
//
//Input:
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//Output:
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
public class InverеBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode invertTree(TreeNode root) {
         invert(root);
         return root;
    }

    static void invert(TreeNode root) {
        if (root == null) return ;
        TreeNode cross = root.left;
        root.left = root.right;
        root.right = cross;
        invert(root.left);
        invert(root.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;
        TreeNode leftL = new TreeNode(1);
        TreeNode rightL = new TreeNode(3);
        left.left = leftL;
        left.right = rightL;
        TreeNode leftR = new TreeNode(6);
        TreeNode rightR = new TreeNode(9);
        right.left = leftR;
        right.right = rightR;
        invertTree(root);

    }
}
