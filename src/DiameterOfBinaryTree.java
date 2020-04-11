public class DiameterOfBinaryTree {
//    Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
//    Example:
//    Given a binary tree
//          1
//                  / \
//                  2   3
//                  / \
//                  4   5
//    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//
//    Note: The length of path between two nodes is represented by the number of edges between them.

   static class   TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

   static class Result{
        Integer maxLen;
        Integer maxDiametr;

        Result(Integer maxLen,Integer maxDiametr){
            this.maxLen=maxLen;
            this.maxDiametr =maxDiametr;
        }
        public String toString(){
            return "maxLen  " + maxLen + "     maxDiametr " +maxDiametr;
        }
    }
    public static int diameterOfBinaryTree(TreeNode root) {
      Result result = diametr(root);
      return  result.maxDiametr;
    }


    public static Result diametr(TreeNode root){
        if (root == null) return new Result(0,0);


        Result left = diametr(root.left);
        Result right = diametr(root.right);
        System.out.println(root.val);
        System.out.println(left);
        System.out.println(right);
        return new Result(Math.max(left.maxLen+1, right.maxLen+1),  Math.max(left.maxLen+right.maxLen, Math.max(left.maxDiametr,right.maxDiametr)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1) ;
        root.right =  new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        node2.right = new TreeNode(5);
        node2.left = new TreeNode(4);
        root.left=node2;
        System.out.println(diameterOfBinaryTree(root));
    }
}
