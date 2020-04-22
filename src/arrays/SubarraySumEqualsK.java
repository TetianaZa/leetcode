package arrays;
//Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
//
//Example 1:
//Input:nums = [1,1,1], k = 2
//Output: 2
//Note:
//The length of the array is in range [1, 20,000].
//The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int countOfArraysWithNeededSum = 0;
        HashMap<Integer, Integer> arraysSum = new HashMap<>();
        int sum = 0;
        arraysSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
             sum += nums[i];
             if (arraysSum.containsKey(sum - k)) countOfArraysWithNeededSum+= arraysSum.get(sum-k);
             arraysSum.put(sum, arraysSum.getOrDefault(sum,0) +1);

        }
        return countOfArraysWithNeededSum;
    }


    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0));
    }
}


