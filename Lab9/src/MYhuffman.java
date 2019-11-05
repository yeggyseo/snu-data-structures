import java.util.*;

class MinHeap {

    private ArrayList<Integer> list;

    public MinHeap() {
        this.list = new ArrayList();
    }

    public MinHeap(ArrayList<Integer> items) {
        this.list = items;
        buildHeap();
    }

    public void insert(int item) {
        list.add(item);
        int size = list.size() - 1;
        int p = parent(size);

        while (p != size && list.get(size) < list.get(p)) {
            swap(size, p);
            size = p;
            p = parent(size);
        }
    }

    public void buildHeap() {
        for (int i = list.size() / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public int extractMin() {

        if (list.size() == 0) {
            System.out.println("size = 0");
        } else if (list.size() == 1) {
            int min = list.remove(0);
            return min;
        }

        int min = list.get(0);
        int lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);
        minHeapify(0);
        return min;
    }

    public void decreaseKey(int i, int key) {

        if (list.get(i) < key) {
            System.out.println("ERROR");
        }

        list.set(i, key);
        int parent = parent(i);

        while (i > 0 && list.get(parent) > list.get(i)) {
            swap(i, parent);
            i = parent;
            parent = parent(parent);
        }
    }

    private void minHeapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int sll = -1;

        if (left <= list.size() - 1 && list.get(left) < list.get(i)) {
            sll = left;
        } else {
            sll = i;
        }
        if (right <= list.size() - 1 && list.get(right) < list.get(sll)) {
            sll = right;
        }
        if (sll != i) {
            swap(i, sll);
            minHeapify(sll);
        }
    }

    public int getMin() {

        return list.get(0);
    }

    public boolean isEmpty() {

        return list.size() == 0;
    }

    private int parent(int i) {
        if (i % 2 == 1) {
            return i / 2;
        }
        return (i - 1) / 2;
    }

    private void swap(int i, int parent) {
        int temp = list.get(parent);
        list.set(parent, list.get(i));
        list.set(i, temp);
    }

}

class Node {
    int data;
    char c;

    Node left;
    Node right;
}

class Comp implements Comparator<Node> {
    public int compare(Node x, Node y) {
        return x.data - y.data;
    }
}

class MYhuffman {
    private static char[] charArray;
    public static int[] freqArray;

    public static void printCode(Node root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void getHuffman() {
        try{
            System.out.println("---------------------------");
            System.out.println("Yegeon Seo\n2018-81365\n");
            System.out.println("Min Heap and Huffman Code prints, but I am not sure what to do for the next step..");
            System.out.println("---------------------------");

            Scanner sc = new Scanner(System.in);
            System.out.println("write the string input");
            String sca = sc.nextLine();
            charArray = sca.toCharArray();
            int sl = sca.length();

            Scanner sf = new Scanner(System.in);
            System.out.println("write frequencies SEPARATED BY A COMMA");
            String sia = sf.nextLine();
            String[] temp = sia.split(",");
            freqArray = new int[temp.length];

            for (int i = 0; i < temp.length; i++) {
                freqArray[i] = Integer.parseInt(temp[i]);
            }

            PriorityQueue<Node> q = new PriorityQueue(sl, new Comp());

            for (int i = 0; i < sl; i++) {
                Node node = new Node();

                node.c = charArray[i];
                node.data = freqArray[i];

                node.left = null;
                node.right = null;

                q.add(node);
            }

            Node root = null;

            while (q.size() > 1) {
                Node x = q.peek();
                q.poll();
                Node y = q.peek();
                q.poll();

                Node e = new Node();

                e.data = x.data + y.data;
                e.c = '-';
                e.left = x;
                e.right = y;

                root = e;
                q.add(e);
            }
            System.out.println("New Huffman Code");
            printCode(root, "");
        }


        catch(Exception e) {
            System.out.println("error = " + e);
        }
    }


    public static void main(String[] args) {
        getHuffman();
    }
}
