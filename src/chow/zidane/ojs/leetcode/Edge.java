package chow.zidane.ojs.leetcode;

class Edge {

    GraphVertex u;
    GraphVertex v;
    int wight;

    Edge(final GraphVertex u, final GraphVertex v, int wight) {
        this.u = u;
        this.v = v;
        this.wight = wight;
    }

}
