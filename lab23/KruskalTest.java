import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by romanlapshuk on 8/7/17.
 */
public class KruskalTest {
    @Test
    public void minSpanTree() throws Exception {
        Graph g = new Graph();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addEdge(0,1, 2);
        g.addEdge(0,2, 3);
        g.addEdge(1,2, 2);
        g.addEdge(2,3, 2);
        g.addEdge(0,3, 5);

        TreeSet<Edge> correct = new TreeSet<>();
        correct.add(new Edge(0,1,2));
        correct.add(new Edge(1,2,2));
        correct.add(new Edge(2,3,2));

        assertEquals(correct.toString(), Kruskal.minSpanTree(g).getAllEdges().toString());

    }

    @Test
    public void minSpanTreeFastTest() throws Exception {
        Graph g = new Graph();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addEdge(0,1, 2);
        g.addEdge(0,2, 3);
        g.addEdge(1,2, 2);
        g.addEdge(2,3, 2);
        g.addEdge(0,3, 5);

        TreeSet<Edge> correct = new TreeSet<>();
        correct.add(new Edge(0,1,2));
        correct.add(new Edge(1,2,2));
        correct.add(new Edge(2,3,2));

        assertEquals(correct.toString(), Kruskal.minSpanTreeFast(g).getAllEdges().toString());
    }

    @Test
    public void isConnectedTest() throws Exception {
        Graph g = new Graph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(4,3);

        assertFalse(Kruskal.isConnected(g, 1, 5));
        g.addEdge(5,3);
        assertTrue(Kruskal.isConnected(g, 1, 5));
    }



}