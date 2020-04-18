package arrays;

//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//Note: You can only move either down or right at any point in time.
//
//Example:
//
//Input:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//Output: 7
//Explanation: Because the path 1→3→1→1→1 minimizes the sum.
public class MinimumPathSum {

    static int[][] array;

    static int[][] minLenght;


    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        minLenght = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) minLenght[0][0] = grid[0][0];
                else if (j == 0) minLenght[i][j] = minLenght[i - 1][j] + grid[i][j];
                else
                    minLenght[i][j] = grid[i][j] + Math.min((i == 0) ? Integer.MAX_VALUE : minLenght[i - 1][j], minLenght[i][j - 1]);
            }
        }
        return minLenght[n - 1][m - 1];
    }


//    public static int minPathSum(int[][] grid) {
//        array = grid;
//        return minSum(0,0);
//    }
//
//    public static int minSum(int i , int j){
//       if (i < 0 || j < 0 || i >= array.length || array[i].length <=j) return Integer.MAX_VALUE;
//        if(i== array.length-1  &&  array[i].length-1 == j) return array[i][j];
//        int valueInPoint =  array[i][j];
//
//        return   valueInPoint + Math.min(minSum(i+1,j),minSum(i,j+1));
//    };

    public static void main(String[] args) {

        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
//        System.out.println(minPathSum(new int[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}}));
//        ;
    }
}
