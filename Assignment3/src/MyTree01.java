import java.util.*;

class Node {
    String data;
    Node left, right;

    Node(String item) {
        data = item;
        left = right = null;
    }
}

public class MyTree01 {
    Node root = null;
    public Node createBT(String[] arr) {


        if (arr == null || arr.length == 0) return null;

        Stack<Node> st = new Stack();

        for (int i = 0; i < arr.length; i++) {
            Node new_node = new Node(arr[i]);
            attachChildToParent(st,new_node);

            if (root == null) root = new_node;
            if (isOperator(arr[i])){
                st.push(new_node);
            }
        }
        return root;
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private void attachChildToParent(Stack<Node> st, Node child_node) {
        if (st.isEmpty()) return;
        Node parent_node = st.peek();
        if (parent_node.left == null) {
            parent_node.left = child_node;
        } else {
            parent_node.right = child_node;
            st.pop();
        }
    }

    private void preorder(Node root, List<String> nodes) {
        if(root == null) return;
        nodes.add(root.data);
        preorder(root.left,nodes);
        preorder(root.right,nodes);
    }

    void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data);
    }

    void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.data);
        printInOrder(node.right);
    }

    void printPostOrder()  {
        printPostOrder(root);
    }
    void printInOrder()    {
        printInOrder(root);
    }

    void printLevelOrder() {
        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data);
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please write your preorder");
        String[] str = sc.nextLine().split("");
        MyTree01 obj = new MyTree01();

        for (int i = 0; i < str.length; i++) {
            Node root = obj.createBT(str);
            List<String> preorder_result = new ArrayList();
            obj.preorder(root,preorder_result);
        }

        System.out.println("InOrder::");
        obj.printInOrder();
        System.out.println("\nPostOrder::");
        obj.printPostOrder();
        System.out.println("\nLevelOrder::");
        obj.printLevelOrder();
    }
}