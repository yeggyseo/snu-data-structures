/**
 * I could not finish Q1, thus could not implement Q2 and Q3 using the linked list in Q1.
 * For Q1, I successfully for the information for each vertex,
 * but I did not understand how I should connect each vertex by going through each one of them.
 * However, I still tried to implement Dijkstra and Prim's Algorithm on Q2 and Q3.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class Init {
    private static String fileName;
    private static Vertex[][] vertices = new Vertex[20][20];
    private LinkedList[] adjacencyList = new LinkedList[20];

    class Coordinate {
        private int row, col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public String toString() {
            return "(" + row + "," + col + ")";
        }
    }

    class Vertex {
        float height;
        Coordinate xy;
        boolean removed;

        public Vertex(float h, Coordinate xyCoordinate) {
            height = h;
            xy = xyCoordinate;
            removed = false;
        }
    }

    class Edge {
        Coordinate start;
        Coordinate destination;
        float weight;

        public Edge(Coordinate s, Coordinate d, float w) {
            start = s;
            destination = d;
            weight = w;
        }
    }

    public Init (String input) {
        fileName = input;
    }

    public float[][] readHeight() {
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String fileContent;
            String[] content;
            float[][] height = new float[20][20];

            int lineCount = 0;
            while (file.ready()) {
                if (lineCount < 20) {
                    fileContent = file.readLine();
                    content = fileContent.split("\t");

                    for (int i = 0; i < content.length; i++) {
                        height[lineCount][i] = Float.parseFloat(content[i]);
                    }

                    lineCount ++;
                } else {
                    break;
                }
            }
            return height;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void vertex(float[][] h) {
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                Coordinate ij = new Coordinate(i, j);
                vertices[i][j] = new Vertex(h[i][j], ij);

                if (vertices[i][j].height == -1) {
                    vertices[i][j].removed = true;
                }
            }
        }
//        addEdge();
    }

//    public void addEdge() {
//        for (int i = 0; i < 20; i ++) {
//            for (int j = 0; j < 20; j ++) {
//                if (vertices[i][j].height != -1 &&
//                        vertices[i + 1][j + 1].height != -1 &&
//                        Math.abs(i - (i + 1)) + Math.abs(j - j + 1) <= 2) {
//                    adjacencyList[vertices[i][j].xy] =
//                }
//
//            }
//        }
//    }



    public static void main(String[] args) {
        Init height = new Init("height.txt");
        float[][] h = height.readHeight();

        height.vertex(h);


//        for (int i = 0; i < 20; i++) {
//            for(int j = 0; j < 20; j ++) {
//                System.out.println(vertices[i][j]);
//            }
//        }



    }
}
