package arrays;
//An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
//
//Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
//
//To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
//
//At the end, return the modified image.
//
//Example 1:
//Input:
//image = [[1,1,1],[1,1,0],[1,0,1]]
//sr = 1, sc = 1, newColor = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//Explanation:
//From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
//by a path of the same color as the starting pixel are colored with the new color.
//Note the bottom corner is not colored 2, because it is not 4-directionally connected
//to the starting pixel.
//Note:
//
//The length of image and image[0] will be in the range [1, 50].
//The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
//The value of each color in image[i][j] and newColor will be an integer in [0, 65535]

public class FloodFill {
    static int[][] image;
    static int lenght;
    static int weight;

    public static int[][] floodFill(int[][] image1, int sr, int sc, int newColor) {
        image = image1;
        lenght = image[0].length;
        weight = image.length;
        if (image[sr][sc] == newColor) return image;
        repaint(sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public static boolean repaint(int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sr >= weight || sc < 0 || sc >= lenght) return false;
        if (image[sr][sc] != oldColor) return false;
        else image[sr][sc] = newColor;
        return repaint(sr, sc + 1, newColor, oldColor) || repaint(sr + 1, sc + 1, newColor, oldColor)
                || repaint(sr - 1, sc, newColor, oldColor) || repaint(sr, sc - 1, newColor, oldColor);

    }

    public static void main(String[] args) {
        System.out.println(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2));
    }
}
