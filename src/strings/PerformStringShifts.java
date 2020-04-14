package strings;

//Perform String Shifts
//You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
//
//direction can be 0 (for left shift) or 1 (for right shift).
//amount is the amount by which string s is to be shifted.
//A left shift by 1 means remove the first character of s and append it to the end.
//Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
//Return the final string after all operations.
//
//
//
//Example 1:
//
//Input: s = "abc", shift = [[0,1],[1,2]]
//Output: "cab"
//Explanation:
//[0,1] means shift to left by 1. "abc" -> "bca"
//[1,2] means shift to right by 2. "bca" -> "cab"
//Example 2:
//
//Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
//Output: "efgabcd"
//Explanation:
//[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
//[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
//[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
//[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
//
//
//Constraints:
//
//1 <= s.length <= 100
//s only contains lower case English letters.
//1 <= shift.length <= 100
//shift[i].length == 2
//0 <= shift[i][0] <= 1
//0 <= shift[i][1] <= 100
public class PerformStringShifts {

    public static String stringShift(String s, int[][] shift) {
        int direction = 0;
        int position = 0;
        String result = "";
        for (int i = 0; i < shift.length; i++) {
            int movements = (shift[i][0] == 0) ? -shift[i][1] : shift[i][1];
            position += movements;
            direction = (position > 0) ? 1 : 0;
        }


        if (direction == 0) {
            position = -position % s.length();
            result = s.substring(position) + s.substring(0, position);
        } else {
            position = position % s.length();
            result = s.substring(s.length() - position) + s.substring(0, s.length() - position);

        }
        return result;

    }

    public static void main(String[] args) {

        // String s = "abcdefg";
        //  int[][] shift = new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        String s = "wpdhhcj";
        int[][] shift = new int[][]{{0, 7}, {1, 7}, {1, 0}, {1, 3}, {0, 3}, {0, 6}, {1, 2}};
        System.out.println(stringShift(s, shift));
    }
}
