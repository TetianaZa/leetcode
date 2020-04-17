package arrays;

//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//Example 1:
//
//Input:
//11110
//11010
//11000
//00000
//
//Output: 1
//Example 2:
//
//Input:
//11000
//11000
//00100
//00011
//
//Output: 3
public class NumberOfIslands {

    static char[][] array = new char[][]{};

    public static int numIslands(char[][] grid) {
        int island = 0;
        array = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (isIland(i, j)) island++;
            }
        }

        return island;
    }

    public static boolean isIland(int i, int j) {
        boolean wasNotVisitedBefore = false;

        if (i < 0 || j < 0 || i >= array.length || array[i].length <= j) return false;

        if (array[i][j] == '0' || array[i][j] == '3') return false;

        if (array[i][j] == '1') {
            array[i][j] = '3';
            wasNotVisitedBefore = true;
        }

        boolean b1 = isIland(i + 1, j);
        boolean b2 = isIland(i, j + 1);
        boolean b3 = isIland(i - 1, j);
        boolean b4 = isIland(i, j - 1);
        return b1 || b2 || b3 || b4 || wasNotVisitedBefore;
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));
    }
}

