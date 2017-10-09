import org.junit.Test;

import javax.swing.tree.TreeNode;

import static org.junit.Assert.*;

/**
 * Created by romanlapshuk on 7/17/17.
 */
public class BinarySearchTreeTest extends BinarySearchTree{
    @Test
    public void contains() throws Exception {

        BinarySearchTree t = new BinarySearchTree();
        t.add(5);
        t.add(4);
        t.add(15);
        System.out.println(t.root.item);
        System.out.println(t.root.left.item);
        System.out.println(t.root.right.item);
        System.out.println(t.contains(3));
    }

    @Test
    public void add() throws Exception {
    }

}