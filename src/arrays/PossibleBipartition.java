package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
//
//Each person may dislike some other people, and they should not go into the same group.
//
//Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
//
//Return true if and only if it is possible to split everyone into two groups in this way.
//Example 1:
//
//Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
//Output: true
//Explanation: group1 [1,4], group2 [2,3]
//Example 2:
//
//Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
//Output: false
//Example 3:
//
//Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//Output: false
//Note:
//
//        1 <= N <= 2000
//        0 <= dislikes.length <= 10000
//        1 <= dislikes[i][j] <= N
//        dislikes[i][0] < dislikes[i][1]
//        There does not exist i != j for which dislikes[i] == dislikes[j].
public class PossibleBipartition {
    static Set<Integer> wasProcessed = new HashSet<>();

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        int[] setOne = new int[N + 1];
        int[] setTwo = new int[N + 1];
        HashSet<Integer>[] rules = new HashSet[N + 1];

        for (int i = 0; i < dislikes.length; i++) {
            if (rules[dislikes[i][1]] == null) {
                rules[dislikes[i][1]] = new HashSet<>();
            }
            rules[dislikes[i][1]].add(dislikes[i][0]);
            if (rules[dislikes[i][0]] == null) {
                rules[dislikes[i][0]] = new HashSet<>();
            }
            rules[dislikes[i][0]].add(dislikes[i][1]);
            rules[dislikes[i][1]].add(dislikes[i][0]);
        }
        if (dislikes.length == 0) return true;
        boolean wasNotSetYet = true;

        for (int i = 1; i <= rules.length; i++) {
            if (rules[i] == null) continue;

            if (wasNotSetYet) {
                for (int role : rules[i]) {
                    setOne[i] = i;
                    if (wasNotSetYet) setTwo[role] = role;


                }
                wasNotSetYet = false;


            }

        }
        return true;
    }

    public static boolean processed(Integer toprocess, HashSet<Integer>[] rules) {
        if (wasProcessed.contains(toprocess)) return true;
        if (rules[toprocess] == null) return true;
            return true;

    }
//        for (int i = 0; i < dislikes.length; i++) {
//            if (rules[dislikes[i][1]] == null) {
//                rules[dislikes[i][1]] = new HashSet<>();
//            }
//            rules[dislikes[i][1]].add(dislikes[i][0]);
//            if (rules[dislikes[i][0]] == null) {
//                rules[dislikes[i][0]] = new HashSet<>();
//            }
//            rules[dislikes[i][0]].add(dislikes[i][1]);
//            rules[dislikes[i][1]].add(dislikes[i][0]);
//            if (setOne[dislikes[i][0]] != 0 && setOne[dislikes[i][1]] != 0) {
//                boolean canPutFirst = canBePut(rules, setTwo, dislikes[i][0]);
//                boolean canPutSecond = canBePut(rules, setTwo, dislikes[i][1]);
//                if (!canPutFirst && !canPutSecond) return false;
//                if (canPutFirst) {
//                    setTwo[dislikes[i][0]] = dislikes[i][0];
//                    setOne[dislikes[i][0]] = 0;
//                } else if (canPutSecond) {
//                    setTwo[dislikes[i][1]] = dislikes[i][1];
//                    setOne[dislikes[i][1]] = 0;
//                }
//            } else if (setOne[dislikes[i][0]] == 0 && setOne[dislikes[i][1]] == 0) {
//                return false;
//            }
//        }


//            return true;
//}


    public static boolean canBePut(HashSet<Integer>[] rules, int[] set, int element) {
        boolean result = true;
        if (rules[element] == null) return true;
        for (int el : rules[element]) {
            if (set[el] != 0) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // System.out.println(possibleBipartition(5, new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}));
        //  System.out.println(possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        System.out.println(possibleBipartition(10, new int[][]
                {{4, 7}, {4, 8}, {2, 8}, {8, 9}, {1, 6}, {5, 8}, {1, 2}, {6, 7}, {3, 10}, {8, 10}, {1, 5},
                        {7, 10}, {1, 10}, {3, 5}, {3, 6}, {1, 4}, {3, 9}, {2, 3}, {1, 9}, {7, 9}, {2, 7}, {6, 8}, {5, 7}, {3, 4}}));
    }
}
