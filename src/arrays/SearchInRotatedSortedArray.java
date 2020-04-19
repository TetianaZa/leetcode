package arrays;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//You may assume no duplicate exists in the array.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//Example 1:
//
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//Example 2:
//
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
public class SearchInRotatedSortedArray {


    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return search(nums, 0, nums.length - 1, target);
    }

    public static int search(int[] array, int leftBorder, int rightBoarder, int targer) {

        if (leftBorder > rightBoarder) return -1;

        int middle = (leftBorder + rightBoarder) / 2;

        if (array[middle] == targer) return middle;

        if (array[middle] < targer && (array[middle] >= array[leftBorder] || array[leftBorder] > targer))
            return search(array, middle + 1, rightBoarder, targer);

        if (array[middle] > array[rightBoarder] && targer <= array[rightBoarder] && targer < array[leftBorder])
            return search(array, middle + 1, rightBoarder, targer);

        return search(array, leftBorder, middle - 1, targer);
    }


    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 1, 3}, 3));
    }
}
