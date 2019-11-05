 class SplayTreeSort {
     class Node {
         int data;
         Node left, right, parent;

         Node(int item) {
             data = item;
             left = right = parent = null;
         }
     }

     public SplayTreeSort (int[] arr) {
         root = null;
         for (int i = 0; i < arr.length; i++) {
             insert(arr[i]);
         }
     }

    private Node root;

    public void insert (int n) {
        Node node = root;
        Node temp = null;

        while (node != null) {
            temp = node;
            if (n > temp.data) {
                node = node.right;
            }
            else {
                node = node.left;
            }
        }
        node = new Node(n);
        node.data = n;
        node.parent = temp;
        if (temp == null) {
            root = node;
        } else if (n > temp.data) {
            temp.right = node;
        } else {
            temp.left = node;
        }
        Splay(node);
    }

     private void Splay (Node node) {
         while (node.parent != null) {
             Node parent = node.parent;
             Node gp = parent.parent;
             if (gp == null) {
                 if (node == parent.left) {
                     makeLeftChildParent(node, parent);
                 } else {
                     makeRightChildParent(node, parent);
                 }
             } else {
                 if (node == parent.left) {
                     if (parent == gp.left) {
                         makeLeftChildParent(parent, gp);
                         makeLeftChildParent(node, parent);
                     } else {
                         makeLeftChildParent(node, node.parent);
                         makeRightChildParent(node, node.parent);
                     }
                 } else {
                     if (parent == gp.left) {
                         makeRightChildParent(node, node.parent);
                         makeLeftChildParent(node, node.parent);
                     } else {
                         makeRightChildParent(parent, gp);
                         makeRightChildParent(node, parent);
                     }
                 }
             }
         }
         root = node;
     }

    public void makeLeftChildParent(Node child, Node parent) {
        splayUtil(child, parent);
        if (child.right != null) {
            child.right.parent = parent;
        }

        child.parent = parent.parent;
        parent.parent = child;
        parent.left = child.right;
        child.right = parent;
    }

    public void makeRightChildParent(Node child, Node parent) {
        splayUtil(child, parent);
        if (child.left != null) {
            child.left.parent = parent;
        }

        child.parent = parent.parent;
        parent.parent = child;
        parent.right = child.left;
        child.left = parent;
    }

    public void splayUtil(Node child, Node parent) {
        if (parent.parent != null) {
            if (parent == parent.parent.left) {
                parent.parent.left = child;
            } else {
                parent.parent.right = child;
            }
        }
    }


     public boolean isSplay()  {
         return isSplayUtil(root, Integer.MIN_VALUE,
                 Integer.MAX_VALUE);
     }

     public boolean isSplayUtil(Node node, int min, int max) {
         if (node == null) return true;
         if (node.data < min || node.data > max) return false;
         return (isSplayUtil(node.left, min, node.data - 1) &&
                 isSplayUtil(node.right, node.data + 1, max));
     }
}

