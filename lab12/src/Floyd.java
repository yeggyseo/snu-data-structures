import java.util.Scanner;

public class Floyd {
    final static int INF = 999;
    int V;

    public Floyd(int v) {
        V = v;
    }

    void floyd(int[][] graph) {
        int[][] dist = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (i == j && dist[i][j] == 0) {
                    dist[i][j] = 0;
                } else if (i != j && dist[i][j] == 0) {
                    dist[i][j] = INF;
                }
            }
        }

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if ((dist[i][k] + dist[k][j]) < dist[i][j]) {
                        dist[i][j] = (dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        printSolution(dist);
    }

    void printSolution(int dist[][]) {
        System.out.println("The expected output for given graph is: ");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print(INF + " ");
                }
                else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        Scanner v = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        String vv = v.nextLine();
        int vertices = Integer.parseInt(vv);

        int graph[][] = {
            {0, 4, 0, 0, 1, 0},
            {0, 0, 1, 0, 2, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 5, 0, 3},
            {0, 0, 0, 0, 0, 0}
        };

        Floyd a = new Floyd(vertices);

        a.floyd(graph);
    }
}
