package tree;

//Given a non-empty binary tree, find the maximum path sum.
//
//For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
//
//Example 1:
//
//Input: [1,2,3]
//
//       1
//      / \
//     2   3
//
//Output: 6
//Example 2:
//
//Input: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//Output: 42
public class BinaryTreeMaximumPathSum {
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

    static int maxSize = Integer.MIN_VALUE;


    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        findSum(root);
        return maxSize;
    }

    public static int findSum(TreeNode node) {
        if (node == null) return 0;
        int leftSize = Math.max(findSum(node.left), 0);
        int rightSize = Math.max(findSum(node.right), 0);
        int valueInNode = node.val;
        maxSize = Math.max(maxSize, valueInNode + leftSize + rightSize);
        return Math.max(valueInNode + leftSize, valueInNode + rightSize);

    }

    public static void main(String[] args) {
//        Input: [-10,9,20,null,null,15,7]
//
//        -10
//                / \
//        9  20
//                /  \
//        15   7
//        for ()
//        TreeNode tree15 = new TreeNode(15);
//        TreeNode tree7 = new TreeNode(7);
//        TreeNode tree20 = new TreeNode(20);
//        tree20.left =tree15;
//        tree20.right =tree7;
//        TreeNode tree9= new TreeNode(9);
//        TreeNode tree10 =new TreeNode(-10);
//        tree10.right=tree20;
//        tree10.left=tree9;

        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(3);
        TreeNode tree4 = new TreeNode(4);
        TreeNode tree5 = new TreeNode(5);
        tree4.left = tree5;
        tree3.left = tree4;
        tree2.left = tree3;
        tree1.left = tree2;


        System.out.println(maxPathSum(tree1));
    }
}
