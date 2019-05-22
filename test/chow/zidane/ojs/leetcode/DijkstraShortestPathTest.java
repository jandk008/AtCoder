package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class DijkstraShortestPathTest {

    @Test
    void test() {
        GraphVertex s = new GraphVertex('s', new ArrayList<>(), null);
        GraphVertex t = new GraphVertex('t', new ArrayList<>(), null);
        GraphVertex a = new GraphVertex('a', new ArrayList<>(), null);
        GraphVertex b = new GraphVertex('b', new ArrayList<>(), null);
        GraphVertex c = new GraphVertex('c', new ArrayList<>(), null);
        s.edges.add(new Edge(s, t, 10));
        s.edges.add(new Edge(s, a, 1));
        a.edges.add(new Edge(a, s, 1));
        a.edges.add(new Edge(a, b, 4));
        b.edges.add(new Edge(b, a, 4));
        b.edges.add(new Edge(b, t, 3));
        b.edges.add(new Edge(b, c, 1));
        c.edges.add(new Edge(c, b, 1));
        c.edges.add(new Edge(c, t, 1));
        t.edges.add(new Edge(t, c, 1));
        t.edges.add(new Edge(t, b, 3));
        t.edges.add(new Edge(t, s, 10));

        assertEquals(7, DijkstraShortestPath.find(s, t));
    }
}
