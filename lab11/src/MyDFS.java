import java.util.Iterator;
import java.util.LinkedList;

public class MyDFS {
    private int V;
    private LinkedList<Integer> adj[];

    MyDFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int from, int to) {
        adj[from].add(to);
    }

    void DFSFunc(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> iterator = adj[v].listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();

            if (!visited[n]) {
                DFSFunc(n, visited);
            }
        }
    }

    void DFS() {
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                DFSFunc(i, visited);
            }
        }
    }

    public static void main(String args[]) {
        MyDFS graph = new MyDFS(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 0);
        graph.addEdge(1, 3);
        graph.addEdge(2, 0);
        graph.addEdge(3, 0);
        graph.addEdge(3, 1);

        System.out.println("The source node 0 is connected to:");
        graph.DFS();
    }
} 