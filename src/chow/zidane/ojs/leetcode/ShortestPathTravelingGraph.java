package chow.zidane.ojs.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class ShortestPathTravelingGraph {

    static int find(final int[][] graph) {
        int goal = (1 << graph.length) - 1;
        Queue<MyState> queue = new LinkedList<>();
        boolean[][] visited = new boolean[graph.length][1 << graph.length];

        for (int i = 0; i < graph.length; i++) {
            queue.add(new MyState(i, 1 << i));
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize-- > 0) {
                MyState curr = queue.poll();
                if (curr.path == goal) return steps;
                if (visited[curr.vertex][curr.path]) continue;
                visited[curr.vertex][curr.path] = true;
                for (Integer i : graph[curr.vertex]) {
                    int nextPath = (curr.path | (1 << i));
                    queue.add(new MyState(i, nextPath));
                }
            }
            steps++;
        }
        return -1;
    }
}

class MyState {
    int vertex;
    int path;

    MyState(final int vertex, final int path) {
        this.vertex = vertex;
        this.path = path;
    }
}
