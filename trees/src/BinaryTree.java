class BinaryTree {
    Node root;

    BinaryTree()
    {
        root = null;
    }

    void printPostOrder(Node node)
    {
        if (node == null) return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    void printInOrder(Node node)
    {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    void printPreOrder(Node node)
    {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    void printPostOrder()  {
        printPostOrder(root);
    }
    void printInOrder()    {
        printInOrder(root);
    }
    void printPreOrder()   {
        printPreOrder(root);
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node("+");
        tree.root.left = new Node("*");
        tree.root.right = new Node("*");
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node("-");
        tree.root.left.right.left = new Node("4");
        tree.root.left.right.right = new Node("2");
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInOrder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostOrder();
    }
}
