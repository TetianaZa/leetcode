package arrays;

//We write the integers of A and B (in the order they are given) on two separate horizontal lines.
//
//Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
//
//A[i] == B[j];
//The line we draw does not intersect any other connecting (non-horizontal) line.
//Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
//
//Return the maximum number of connecting lines we can draw in this way.
//
//
//
//Example 1:
//
//
//Input: A = [1,4,2], B = [1,2,4]
//Output: 2
//Explanation: We can draw 2 uncrossed lines as in the diagram.
//We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
//Example 2:
//
//Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
//Output: 3
//Example 3:
//
//Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
//Output: 2
//
//
//Note:
//
//1 <= A.length <= 500
//1 <= B.length <= 500
//1 <= A[i], B[i] <= 2000
public class UncrossedLines {


    public static int maxUncrossedLines(int[] A, int[] B) {
//        int n = A.length;
//        int m = B.length;
//        if (n==0 || m==0) return 0;
//
//        int[][] dp = new int[n+1][m+1];
//        for (int i = n-1; i >=0; i --)
//        {
//            for (int j = m-1; j >= 0; j--)
//            {
//                dp[i][j] = Math.max(dp[i+1][j],
//                                           Math.max(dp[i][j+1],dp[i+1][j+1]+(A[i]==B[j]?1:0)));
//            }
//        }
//
//        return dp[0][0];
        int n = A.length;
        int m = B.length;
        Integer[][] dp = new Integer[n][m];

        return findMaxLines(dp, A, B, 0, 0);

    }


    public static int findMaxLines(Integer[][] dp, int[] A, int[] B, int i, int j) {
        if (j >= B.length || i >= A.length) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int max = Integer.MIN_VALUE;
        if (A[i] == B[j]) {
            max = findMaxLines(dp, A, B, i + 1, j + 1) + 1;
        }

        max = Math.max(max, findMaxLines(dp, A, B, i + 1, j));
        max = Math.max(max, findMaxLines(dp, A, B, i, j + 1));

        dp[i][j] = (max == Integer.MIN_VALUE) ? 0 : max;
        return dp[i][j];
    }


    public static void main(String[] args) {
        // System.out.println(maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
        System.out.println(maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));

        //[10,5,2,1,5,2]
        //   [2,5,1,2,5]
    }
}
