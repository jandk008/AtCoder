package chow.zidane.ojs.leetcode;

import java.util.List;

class GraphVertex {

    char id;
    List<Edge> edges;
    GraphVertex previous;
    boolean isVisited;
    int distance;

    GraphVertex(final char id, final List<Edge> edges, final GraphVertex previous) {
        this.id = id;
        this.edges = edges;
        this.previous = previous;
        this.distance = Integer.MAX_VALUE;
    }
}
