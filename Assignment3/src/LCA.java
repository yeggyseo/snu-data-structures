import java.util.*;

/**
 * For number 2, my algorithm was to find the path from the root to the given node using stack.
 * Then, compare two stacks and find print the common numbers, which is also a common path.
 * However, I failed on finding the path from the root to the nodes.
 * I could not find a good way to locate the path..
 **/

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class LCA {

    static Node root;
    private static Stack<Node> left;
    private static Stack<Node> right;

    LCA() {
        root = null;
    }

    public static Node printCommonPath(Node node, Node n1, Node n2) {
        if (n1.equals(n2)) return n1;

        Stack<Node> pathToN1 = pathTo(node, n1);
        Stack<Node> pathToN2 = pathTo(node, n2);

        if (pathToN1 == null || pathToN2 == null) return null;

        Node prev = null;
        while (!pathToN1.isEmpty() && !pathToN2.isEmpty()) {
            Node s = pathToN1.pop();
            Node t = pathToN2.pop();
            if (s.equals(t)) prev = s;
            else break;
        }

        return prev;
    }

    public static Stack<Node> pathTo(Node node, Node n) {
        if (node == null) return null;

        if (node == n) {
            Stack<Node> s = new Stack();
            s.push(node);
            return s;
        }

        if (node.left != null) {
            left = pathTo(node.left, n);
        }
        if (node.right != null) {
            right = pathTo(node.right, n);
        }

        if (left != null) {
            left.push(node);
            return left;
        }

        if (right != null) {
            right.push(node);
            return right;
        }
        return null;
    }

    public static void main (String args[]) {
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.right.left = new Node(7);
        tree.root.left.right.left = new Node(8);
        tree.root.left.right.right = new Node(9);
        Node n1 = new Node(4);
        Node n2 = new Node(8);

        printCommonPath(root, n1, n2);
    }
}


