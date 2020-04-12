package chow.zidane.ojs.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class DijkstraShortestPath {

    static int find(final GraphVertex s, final GraphVertex t) {
        PriorityQueue<GraphVertex> minHeap = new PriorityQueue<>(Comparator.comparingInt(g -> g.distance));
        s.distance = 0;
        s.previous = s;
        minHeap.add(s);
        while (!minHeap.isEmpty()) {
            GraphVertex curr = minHeap.poll();
            for (Edge edge: curr.edges) {
                GraphVertex v = edge.v;
                if (!v.isVisited) {
                    if (curr.distance + edge.wight < v.distance) {
                        v.previous = curr;
                        v.distance = curr.distance + edge.wight;
                    }
                    minHeap.add(v);
                }
            }
            curr.isVisited = true;
        }
        return t.distance;
    }
}
