public class MyDij {
    private int V;

    MyDij(int v) {
        V = v;
    }

    void shortestPath (int[][] graph, int srcV) {
        int[] dist = new int[V];
        Boolean[] shortestPT = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            shortestPT[i] = false;
        }

        dist[srcV] = 0;

        for (int c = 0; c < V - 1; c++) {
            int u = findMD(dist, shortestPT);
            shortestPT[u] = true;

            for (int v = 0; v < V; v++){
                if (!shortestPT[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        toString(dist);
    }

    int findMD(int[] distance, Boolean[] shortestPT) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < V; v++) {
            if (shortestPT[v] == false && distance[v] <= min) {
                min = distance[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void toString(int[] dist) {
        System.out.println("The Shortest Path to all nodes are");
        for (int i = 0; i < V; i++)
            System.out.println(0 + " to " + i + " is " + dist[i]);
    }

    public static void main (String[] args) {
        int[][] graph = new int[][] {
                {0, 7, 0, 0, 2},
                {0, 0, 1, 0, 2},
                {0, 0, 0, 4, 0},
                {0, 0, 5, 0, 0},
                {0, 3, 8, 5, 0}};

        int sourceVertex = 4;

        MyDij t = new MyDij(sourceVertex);
        t.shortestPath(graph, 0);
    }
}

