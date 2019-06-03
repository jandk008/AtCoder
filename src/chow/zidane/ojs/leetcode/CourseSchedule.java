package chow.zidane.ojs.leetcode;

import java.util.ArrayList;
import java.util.List;

class CourseSchedule {

    static boolean isCompletable(final int numCourses, final int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        constructGraph(prerequisites, graph);

        boolean[] visited = new boolean[numCourses];
        boolean[] processing = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, visited, processing, graph)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int node, boolean[] visited, boolean[] processing, List<List<Integer>> graph) {
        if (processing[node]) {
            return true; // processing means the node has appeared in the processing path.
        }
        if (visited[node]) {
            return false; // visited means the node has been processed
        }

        visited[node] = true;
        processing[node] = true;

        for (Integer i : graph.get(node)) {
            if (dfs(i, visited, processing, graph)) {
                return true;
            }
        }
        processing[node] = false; // when the stack finishes, the processing stack should be cleared
        return false;
    }

    private static void constructGraph(int[][] prerequisites, List<List<Integer>> graph) {
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
    }
}
