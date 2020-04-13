package arrays;

//We have a collection of stones, each stone has a positive integer weight.
//
//Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
//
//If x == y, both stones are totally destroyed;
//If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
//At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
//
//
//
//Example 1:
//
//Input: [2,7,4,1,8,1]
//Output: 1
//Explanation:
//We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
//we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
//we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
//we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.

import java.util.Arrays;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        int zoroCount = 0;
        while (zoroCount < stones.length - 1) {
            Arrays.sort(stones);
            for (int i = stones.length - 1; i > zoroCount; i--) {
                if (stones[i] == stones[i - 1]) {
                    stones[i] = stones[i - 1] = 0;
                    i--;
                    zoroCount += 2;
                } else {
                    stones[i - 1] = stones[i] - stones[i - 1];
                    stones[i] = 0;
                    zoroCount++;
                    break;
                }
            }
        }
        Arrays.sort(stones);
        return stones[stones.length-1];
    }

    public static void main(String[] args) {
       System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
