import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by stephanieclaudinodaffara on 8/7/17.
 */
public class UnionFindTest {
    @Test
    public void sizeOf() throws Exception {
        UnionFind uf = new UnionFind(5);
        uf.sets[0] = -2;
        uf.sets[1] = 0;
        uf.sets[2] = -2;
        uf.sets[3] = 2;
        uf.sets[4] = -1;

        assertEquals(2, uf.sizeOf(3));
    }

    @Test
    public void parent() throws Exception {
        UnionFind uf = new UnionFind(5);
        uf.sets[0] = -2;
        uf.sets[1] = 0;
        uf.sets[2] = -2;
        uf.sets[3] = 2;
        uf.sets[4] = -1;

        assertEquals(2, uf.parent(3));
        assertEquals(-2, uf.parent(2));

    }

    @Test
    public void isConnected() throws Exception {

    }

    @Test
    public void find() throws Exception {
        UnionFind uf = new UnionFind(5);
        uf.sets[0] = -4;
        uf.sets[1] = 0;
        uf.sets[2] = 0;
        uf.sets[3] = 2;
        uf.sets[4] = -1;

        assertEquals(0, uf.find(1));
        assertEquals(0, uf.find(2));
        assertEquals(0, uf.find(3));
    }

    @Test
    public void union() throws Exception {
        UnionFind uf = new UnionFind(5);
        uf.sets[0] = -2;
        uf.sets[1] = 0;
        uf.sets[2] = -2;
        uf.sets[3] = 2;
        uf.sets[4] = -1;
        uf.union(0,2);
        assertEquals(4, uf.sizeOf(0));
    }

}