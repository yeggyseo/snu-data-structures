public class Dijkstra {
    private int V;
    private float[][] height;
    private int srcV;

    Dijkstra(int v, float[][] numHeight, int srcVtx) {
        V = v;
        height = numHeight;
        srcV = srcVtx;

        shortestPath(height, srcV);
    }

    public void shortestPath (float[][] graph, int srcV) {
        float[] dist = new float[V];
        Boolean[] shortestPT = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Float.MAX_VALUE;
            shortestPT[i] = false;
        }

        dist[srcV] = 0;

        for (int c = 0; c < V - 1; c++) {
            int u = findMD(dist, shortestPT);
            shortestPT[u] = true;

            for (int v = 0; v < V; v++){
                if (!shortestPT[v] && graph[u][v] != 0 && dist[u] != Float.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        toString(dist);
    }

    public int findMD(float[] distance, Boolean[] shortestPT) {
        float min = Float.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < V; v++) {
            if (shortestPT[v] == false && distance[v] <= min) {
                min = distance[v];
                min_index = v;
            }
        }
        return min_index;
    }

    public void toString(float[] dist) {
        System.out.println("The Shortest Path to all nodes are");
        for (int i = 0; i < V; i++)
            System.out.println(0 + " to " + i + " is " + dist[i]);
    }
}
