import java.util.*;

/**
 * A BinaryTree is a tree with nodes that have up to two children.
 */
public class BinaryTree {

    /**
     * root is the root of this BinaryTree
     */
    private TreeNode root;

    /**
     * The BinaryTree constructor
     */
    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode t) {
        root = t;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void print() {
        if (root != null) {
            root.print(0);
        }
    }

    /**
     * Print the values in the tree in preorder: root value first, then values
     * in the left subtree (in preorder), then values in the right subtree
     * (in preorder).
     */
    public void printPreorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printPreorder();
            System.out.println();
        }
    }

    /**
     * Print the values in the tree in inorder: values in the left subtree
     * first (in inorder), then the root value, then values in the first
     * subtree (in inorder).
     */
    public void printInorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printInorder();
            System.out.println();
        }
    }

    /**
     * Fills this BinaryTree with values a, b, and c.
     * DO NOT MODIFY THIS METHOD.
     */
    public void fillSampleTree1() {
        root = new TreeNode("a", new TreeNode("b"), new TreeNode("c"));
    }

    /**
     * Fills this BinaryTree with values a, b, and c, d, e, f.
     * DO NOT MODIFY THIS METHOD.
     */
    public void fillSampleTree2() {
        root = new TreeNode("a", new TreeNode("b", new TreeNode("d",
                new TreeNode("e"), new TreeNode("f")), null), new TreeNode("c"));
    }

    /**
     * Fills this BinaryTree with the values a, b, c, d, e, f in the way that the spec pictures.
     */
    public void fillSampleTree3() {
        root = new TreeNode("a", new TreeNode("b"), new TreeNode("c", new TreeNode("d",
                new TreeNode("e"), new TreeNode("f")), null));
    }

    /**
     * Fills this BinaryTree with the same leaf TreeNode.
     * DO NOT MODIFY THIS METHOD.
     */
    public void fillSampleTree4() {
        TreeNode leafNode = new TreeNode("c");
        root = new TreeNode("a", new TreeNode("b", leafNode, leafNode), new TreeNode("d", leafNode, leafNode));
    }

    /**
     * Like the Amoeba class, returns the height of the deepest node.
     **/
    public int height() {
        if (root != null) {
            return root.height();
        } else {
            return 0;
        }

    }

    public boolean isCompletelyBalanced() {
        return false;
    }


    HashSet<TreeNode> alreadySeen;

    public boolean check() {
        alreadySeen = new HashSet<>();
        try {
            isOK(root);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    private void isOK(TreeNode t) throws IllegalStateException {
        if (alreadySeen.contains(t)) {
            throw new IllegalStateException();
        } else {
            alreadySeen.add(t);
            if (t.left != null) {
                isOK(t.left);
            }
            if (t.right != null) {
                isOK(t.right);
            }

        }
    }

    /**
     * Creates two BinaryTrees and prints them out in inorder
     */
    public static void main(String[] args) {
        BinaryTree t;
        t = new BinaryTree();
        print(t, "the empty tree");
        t.fillSampleTree1();
        print(t, "sample tree 1");
        t.fillSampleTree2();
        print(t, "sample tree 2");
        t.fillSampleTree3();
        print(t, "sample tree 3");
        t.print(); //checking lab13 print

    }

    /**
     * Prints out the contents of a BinaryTree with a description in both
     * preorder and inorder
     *
     * @param t           the BinaryTree to print out
     * @param description a String describing the BinaryTree t
     */
    private static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println();
    }

    /**
     * A TreeNode is a Node this BinaryTree
     * Note: this class is public in this lab for testing purposes.
     * However, in professional settings as well as the rest of
     * your labs and projects, we recommend that you keep your
     * classes private.
     */
    public static class TreeNode {

        /**
         * item is the item that is contained in this TreeNode
         * left is the left child of this TreeNode
         * right is the right child of this TreeNode
         */
        public Object item;
        public TreeNode left;
        public TreeNode right;

        /**
         * A TreeNode constructor that creates a node with obj as its item
         *
         * @param obj the item to be contained in this TreeNode
         */
        TreeNode(Object obj) {
            item = obj;
            left = null;
            right = null;
        }

        /**
         * A TreeNode constructor that creates a node with obj as its item and
         * left and right as its children
         *
         * @param obj   the item to be contained in this TreeNode
         * @param left  the left child of this TreeNode
         * @param right the right child of this TreeNode
         */
        TreeNode(Object obj, TreeNode left, TreeNode right) {
            item = obj;
            this.left = left;
            this.right = right;
        }

        public Object getItem() {
            return item;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        private static final String indent1 = "    ";

        private LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        // the height must be the height
        private void print(int indent) {
            queue.addLast(this);

            if (right != null) {
                right.print(indent + 4);
            }
            println(item, indent);
            if (left != null) {
                left.print(indent + 4);
                queue.removeFirst();

            }
        }


        private static void println(Object obj, int indent) {
            for (int k = 0; k < indent; k++) {
                System.out.print(indent1);
            }
            System.out.println(obj);
        }

        /**
         * Prints this TreeNode and the subtree rooted at it in preorder
         */
        private void printPreorder() {
            System.out.print(item + " ");
            if (left != null) {
                left.printPreorder();
            }
            if (right != null) {
                right.printPreorder();
            }
        }


        /**
         * Prints this TreeNode and the subtree rooted at it in inorder
         */
        private void printInorder() {
            if (left != null) {
                left.printInorder();
            }
            System.out.print(item + " ");
            if (right != null) {
                right.printInorder();
            }
        }

        /**
         * Like the Amoeba class, returns the height of the deepest node.
         **/
        public int height() {
            int bestSoFar;
            if (this.left == null && this.right == null) {
                bestSoFar = 0;
            } else if (this.left == null) {
                bestSoFar = this.right.height();
            } else if (this.right == null) {
                bestSoFar = this.left.height();
            } else {
                bestSoFar = Math.max(this.left.height(), this.right.height());
            }
            return 1 + bestSoFar;
        }

    }

    //FIBONACCI TREE
    public static BinaryTree fibTree(int n) {
        BinaryTree result = new BinaryTree();
        result.root = fibTreeHelper(n);
        return result;

    }

    private static TreeNode fibTreeHelper(int n) {
        if (n == 0 || n == 1) {
            return new TreeNode(n);
        } else {
            TreeNode left = fibTreeHelper(n - 1);
            TreeNode right = fibTreeHelper(n - 2);
            return new TreeNode((Integer) left.item + (Integer) right.item,
                    left, right);
        }
    }

    //EXPRESSION TREE
    public static BinaryTree exprTree(String s) {
        BinaryTree result = new BinaryTree();
        result.root = result.exprTreeHelper(s);
        return result;
    }

    // Return the tree corresponding to the given arithmetic expression.
    // The expression is legal, fully parenthesized, contains no blanks,
    // and involves only the operations + and *.
    private TreeNode exprTreeHelper(String expr) {
        if (expr.charAt(0) != '(') {
            return new TreeNode(expr.charAt(0));
        } else {
            // expr is a parenthesized expression.
            // Strip off the beginning and ending parentheses,
            // find the main operator (an occurrence of + or * not nested
            // in parentheses, and construct the two subtrees.
            int nesting = 0;
            int opPos = 0;
            for (int k = 1; k < expr.length() - 1; k++) {
                if (nesting == 0 && (expr.charAt(k) == '*' || expr.charAt(k) == ('+'))) {
                    opPos = k;
                    break;
                }
                if (expr.charAt(k) == '(') {
                    nesting++;
                } else if (expr.charAt(k) == ')') {
                    nesting--;
                }
            }
            String opnd1 = expr.substring(1, opPos);
            String opnd2 = expr.substring(opPos + 1, expr.length() - 1);
            String op = expr.substring(opPos, opPos + 1);
            System.out.println("expression = " + expr);
            System.out.println("operand 1  = " + opnd1);
            System.out.println("operator   = " + op);
            System.out.println("operand 2  = " + opnd2);
            System.out.println();
            return new TreeNode(op, exprTreeHelper(opnd1), exprTreeHelper(opnd2));
        }


    }

    public void optimize() {
        if (root != null) {
            eval(root);
        }

    }

    private String eval(TreeNode t) {
        String left = "";
        String right = "";
        String op = "";
        String result = "";

        if (!(t.left == null && t.right == null)) {
            op = "" + t.item;
            left = eval(t.left);
            right = eval(t.right);
        } else {
            result = "" + t.item;
        }

        if (validateInt((String) left) && validateInt((String) right)) {
            if (op.equals("+")) {
                result = "" + (Integer.parseInt(left) + Integer.parseInt(right));
            } else {
                result = "" + (Integer.parseInt(left) * Integer.parseInt(right));
            }
            t.item = result;
            t.left = null;
            t.right = null;
        }
        return result;
    }


    private boolean validateInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
