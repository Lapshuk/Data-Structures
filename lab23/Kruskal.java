
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

/** A class that runs Kruskal's algorithm on a Graph. Given a graph G, Kruskal's
 *  algorithm constructs a new graph T such that T is a spanning tree of G and
 *  the sum of its edge weights is less than the sum of the edge weights for
 *  every possible spanning tree T* of G. This is called the Minimum Spanning
 *  Tree (MST).
 *
 *  @author
 */
public class Kruskal {

    /** Returns the MST of INPUT using a naive isConnected implementation. */
    public static Graph minSpanTree(Graph input) {
        TreeSet<Edge> sortedEdges = input.getAllEdges();
        TreeSet<Integer> allVertices = input.getAllVertices();
        Graph copy = new Graph();

        for (Integer v : allVertices) {
            copy.addVertex(v);
        }

        for (Edge e : sortedEdges) {
            if (!isConnected(copy, e.getSource(), e.getDest())){
                copy.addEdge(e.getSource(), e.getDest(), e.getLabel());
            }
        }

        return copy;
    }

    /** Returns the MST of INPUT using the Union Find data structure. */
    public static Graph minSpanTreeFast(Graph input) {

        TreeSet<Edge> sortedEdges = input.getAllEdges();
        TreeSet<Integer> allVertices = input.getAllVertices();
        Graph copy = new Graph();
        UnionFind uf = new UnionFind(allVertices.size());

        for (Integer v : allVertices) {
            copy.addVertex(v);
        }

        for (Edge e : sortedEdges) {
            if (!uf.isConnected(e.getSource(), e.getDest())) {
                uf.union(e.getSource(), e.getDest());
                copy.addEdge(e.getSource(), e.getDest(), e.getLabel());
            }
        }

        return copy;
    }

    /** A naive implementation of BFS or DFS to check if two nodes are
     *  connected. */
    public static boolean isConnected(Graph g, int v1, int v2) {
        Stack<Integer> stack = new Stack();
        HashSet<Integer> visited = new HashSet();
        stack.add(v1);
        int currVertex = v1;
        while (!stack.isEmpty()) {
            currVertex = stack.pop();
            if (currVertex == v2) {
                return true;
            }
            for (Integer neighbor : g.getNeighbors(currVertex)) {
                if (!visited.contains(neighbor)) {
                    stack.add(neighbor);
                }
            }
            visited.add(currVertex);
        }
        return false;
    }
}
