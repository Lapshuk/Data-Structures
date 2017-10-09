import java.util.ArrayList;
import java.util.HashSet;

/** A simple implementation of the UnionFind abstract data structure with path
 *  compression. This UnionFind structure only holds integers and there are two
 *  critical operations: union and find. When unioning two elements, the element
 *  contained in a tree of smaller size is placed as a subtree to the root
 *  vertex of the larger tree. Meanwhile finding an element implements path
 *  compression. When we find a particular vertex, that vertex and the 
 *  other vertices from that vertex to the root are automatically
 *  connected to the root of that tree.
 *
 *  Using the union find data structure allows for a fast implementation of
 *  Kruskal's algorithm as well as other set based operations.
 *
 *  @author
 *  @since
 */
public class UnionFind {

    /**
     *  Indices correspond to the item itself,
     *  the parent reference is inside the array,
     *  if no parent then size of array is stored
     */
    int[] sets;


    /** Returns a UnionFind data structure holding N vertices. Initially, all
     *  vertices are in disjoint sets. */
    public UnionFind(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        sets = new int[n];
        for (int i = 0; i < n ; i++) {
            sets[i] = -1;
        }
    }

    /** Returns the size of the set V1 belongs to. */
    public int sizeOf(int v1) {
        if (v1 >= sets.length || v1 < 0) {
            throw new IllegalArgumentException();
        }
        int parent = parent(v1);
        while (parent >= 0) {
            parent = parent(parent);
        }
        return -parent;
    }

    /** Returns the parent of v1. If v1 is the root of a tree, 
     *  returns the negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        if (v1 >= sets.length || v1 < 0) {
            throw new IllegalArgumentException();
        }
        return sets[v1];
    }

    /** Returns true if nodes V1 and V2 are connected. */
    public boolean isConnected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /** Returns the root of the set VERTEX belongs to. Path-compression, where the
     *  vertices along the search path from VERTEX to its root and VERTEX are linked
     *  directly to the root, is employed allowing for fast search-time. */
    public int find(int vertex) {
        if (vertex >= sets.length || vertex < 0) {
            throw new IllegalArgumentException();
        }

        if (sets[vertex] < 0) {
            return vertex;
        }

        HashSet<Integer> viewed = new HashSet<>();
        int child = vertex;

        while (parent(child) >= 0 && !viewed.contains(child)) {
            viewed.add(child);
            child = parent(child);
        }

        // performing path compression
        for (int i : viewed) {
            sets[i] = child;
        }

        return child;
    }

    /** Connects two elements V1 and V2 together in the UnionFind structure. V1
     *  and V2 can be any element and a union-by-size heuristic is used.
     *  If the sizes are equal, tie break by connecting the first to the second.
     *  Union-ing a vertex with itself or vertices already connected should not 
     *  change anything. */
    public void union(int v1, int v2) {
        if (v1 == v2 || isConnected(v1, v2)) {
            return;
        }

        int size, root;
        if (sizeOf(v2) > sizeOf(v1)) {
            size = sizeOf(v1);
            root = find(v2);
            sets[find(v1)] = root;
            sets[root] -= size;
        } else {
            size = sizeOf(v2);
            root = find(v1);
            sets[find(v2)] = root;
            sets[root] -= size;
        }

    }
}
