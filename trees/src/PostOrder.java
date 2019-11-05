import java.util.Stack;


class Node {
    Object data;
    Node left, right;

    Node(Object item)
    {
        data = item;
        left = right;
    }

    public void print() {
        System.out.println(data);
    }
}

class PostOrder {
    Node root;

    private void postOrderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            if(stack.empty()) {
                return;
            }
            root = stack.pop();

            if(!stack.empty() && stack.peek() == root) {
                root = root.right;
            }

            else {
                System.out.print(root.data + " ");
                root = null;
            }
        }
    }

    public static void main(String args[])
    {
        PostOrder tree = new PostOrder();

        tree.root = new Node("+");
        tree.root.left = new Node("*");
        tree.root.right = new Node("*");
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node("-");
        tree.root.left.right.left = new Node("4");
        tree.root.left.right.right = new Node("2");
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("Post order traversal of binary tree is :");
        tree.postOrderIterative(tree.root);
    }
}


