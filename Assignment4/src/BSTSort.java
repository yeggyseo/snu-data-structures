public class BSTSort {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    public BSTSort() {
        root = null;
    }


    public void insert(int key) {
        root = insertNum(root, key);
    }

    public Node insertNum(Node node, int n) {
        if (node == null) {
            node = new Node(n);
            return node;
        }
        if (n < node.data){
            node.left = insertNum(node.left, n);
        }
        else if (n > node.data) {
            node.right = insertNum(node.right, n);
        }
        return node;
    }

    public void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    public void makeTree(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    public boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    public boolean isBSTUtil(Node node, int min, int max) {
        if (node == null) return true;
        if (node.data < min || node.data > max) return false;
        return (isBSTUtil(node.left, min, node.data - 1) &&
                isBSTUtil(node.right, node.data + 1, max));
    }

}
