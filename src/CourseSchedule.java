import java.util.*;

//There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
//
//
//Example 1:
//
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take.
//             To take course 1 you should have finished course 0. So it is possible.
//Example 2:
//
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take.
//             To take course 1 you should have finished course 0, and to take course 0 you should
//             also have finished course 1. So it is impossible.
//
//
//Constraints:
//
//The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//You may assume that there are no duplicate edges in the input prerequisites.
//1 <= numCourses <= 10^5
public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i ++)
            graph[i] = new ArrayList<>();
        for (int[] pre : prerequisites)
            graph[pre[1]].add(pre[0]);
        // 0: not visited
        // 1: visiting
        // 2: visited
        int[] status = new int[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            if (status[i] == 0) {
                if (!topo(graph, status, i))
                    return false;
            }
        }
        return true;
    }
    public static boolean topo(List<Integer>[] graph, int[] status, int cur) {
        if (status[cur] == 1)   return false;
        if (status[cur] == 2)   return true;
        status[cur] = 1;
        for (int next : graph[cur]) {
            if (!topo(graph, status, next))
                return false;
        }
        status[cur] = 2;
        return true;
    }



    public static void main(String[] args) {
//       System.out.println( canFinish(3,new int[][]{{1,0},{0,1}}));
//       System.out.println(canFinish(3, new int[][]{{1,0},   //   0  1       1  0  2
//                                                                 {0,2},    //   2  0        2  0
//                                                                 {2,1}}));           ///     1  2
        System.out.println(canFinish(4, new int[][]{
                {1,0},{2,1},{3,2},{1,3}}));

    }
}
