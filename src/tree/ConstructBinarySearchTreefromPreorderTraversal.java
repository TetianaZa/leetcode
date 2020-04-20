package tree;
//Return the root node of a binary search tree that matches the given preorder traversal.
//
//(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
//
//
//
//Example 1:
//
//Input: [8,5,1,7,10,12]
//Output: [8,5,10,1,7,null,12]
//
//
//
//Note:
//
//1 <= preorder.length <= 100
//The values of preorder are distinct.

import java.util.LinkedList;

public class ConstructBinarySearchTreefromPreorderTraversal {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode  root =  new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            putNumberToTree(root, preorder[i]);
        }
        return root;
    }

    public static TreeNode putNumberToTree(TreeNode node, int number) {
        if (node == null) return new TreeNode(number);

        if (number > node.val) node.right = putNumberToTree(node.right, number);
        if (number < node.val) node.left = putNumberToTree(node.left, number);

        return node;
    }


    public static void main(String[] args) {
        System.out.println(bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
    }
}
