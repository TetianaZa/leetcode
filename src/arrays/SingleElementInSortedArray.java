package arrays;

//You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
//
//
//
//Example 1:
//
//Input: [1,1,2,3,3,4,4,8,8]
//Output: 2
//Example 2:
//
//Input: [3,3,7,7,10,11,11]
//Output: 10
//Note: Your solution should run in O(log n) time and O(1) space.
public class SingleElementInSortedArray {

    public static int singleNonDuplicate(int[] nums) {

        int left = 0, right = nums.length - 1;
        int result = 0;
        while (left <= right) {
            int middle = (left + right) / 2;
            result = nums[middle];
            if (left == right) return result;
            if (middle % 2 == 0) {
                if (nums[middle] == nums[middle + 1]) {
                    left = middle + 2;
                    continue;
                }
                right = middle;
            } else {
                if (nums[middle] == nums[middle - 1]) {
                    left = middle + 1;
                    continue;
                }
                right = middle - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
