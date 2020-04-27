package arrays;
//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//Example:
//
//Input:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//Output: 4
public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
     int maxSquare = 0;
     if( matrix.length==0 ||  matrix[0].length==0) return 0;
     int lenght = matrix.length;
     int weight = matrix[0].length;

      int[][] arraysOfStates = new int[lenght+1][weight+1];
      for(int i=0; i<lenght;i++){
          for(int j=0; j<weight;j++){
              if(matrix[i][j]=='1'){
                  int valueToPast= Math.min(Math.min(arraysOfStates[i][j+1],arraysOfStates[i][j]),arraysOfStates[i+1][j]);
                  arraysOfStates[i+1][j+1] = valueToPast+1;
                  maxSquare = Math.max(maxSquare, arraysOfStates[i+1][j+1]);
              }
          }
      }

     return maxSquare*maxSquare;
    }


    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{ {'1','0','1','0'},
                                                       {'1','0','1','1'},
                                                        {'1','0','1','1'},
                                                        {'1','1','1','1'}}));
    }
}
