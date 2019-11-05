import java.io.*;

public class Maze {
    public static void main(String[] args) {
            Maze maze = new Maze("maze1.txt");

            maze.makeMaze();
            maze.solveMaze();
    }

    private String fileName = "";
    private int numRows;
    private int numCols;
    private int startingRow;
    private int startingCol;
    private int lineCount = 0;
    private int [][] mazeArray;
    private String[] mazeContent;
    private boolean solved;
    private Coordinate startingPoint = new Coordinate(0,0);
    private Coordinate current = new Coordinate(0,0);
    private Coordinate rc = new Coordinate(0,0);
    private MyStack stack = new MyStack(10);

    public Maze(String inputName) {
        fileName = inputName;
    }

    public void makeMaze() {
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String fileContent = file.readLine();
            mazeContent = fileContent.split(" ");

            numRows = Integer.parseInt(mazeContent[0]);
            numCols = Integer.parseInt(mazeContent[1]);
            mazeArray = new int[numRows][numCols];

            int hit = 0;

            while(file.ready()) {
                if (lineCount == numRows) {
                    if (hit == 0) {
                        fileContent = file.readLine();
                        mazeContent = fileContent.split(" ");
                        startingRow = Integer.parseInt(mazeContent[0]);
                        startingCol = Integer.parseInt(mazeContent[1]);
                        startingPoint = new Coordinate(startingRow, startingCol);
                        hit ++;
                    } else {
                        break;
                    }
                } else if (lineCount < numRows) {
                    fileContent = file.readLine();
                    mazeContent = fileContent.split(" ");

                    for (int i = 0; i < mazeContent.length; i++) {
                        mazeArray[lineCount][i] = Integer.parseInt(mazeContent[i]);
                    }
                    lineCount ++;
                } else {
                    break;
                }
            }
        } catch(Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void solveMaze() {
        solved = false;
         current = startingPoint;

            stack.push(current);

            while (!solved) {
                rc = north(current);
                if (!(same(rc, current))) {
                    mazeArray[current.getRow()][current.getCol()] = 2;
                    current = rc;
                    stack.push(current);
                    solved = finish(current);
                    getSteps();
                    continue;
                }
                rc = east(current);
                if (!(same(rc, current))) {
                    mazeArray[current.getRow()][current.getCol()] = 2;
                    current = rc;
                    stack.push(current);
                    solved = finish(current);
                    getSteps();
                    continue;
                }
                rc = south(current);
                if (!(same(rc, current))) {
                    mazeArray[current.getRow()][current.getCol()] = 2;
                    current = rc;
                    stack.push(current);
                    solved = finish(current);
                    getSteps();
                    continue;
                }
                rc = west(current);
                if (!(same(rc, current))) {
                    mazeArray[current.getRow()][current.getCol()] = 2;
                    current = rc;
                    stack.push(current);
                    solved = finish(current);
                    getSteps();
                    continue;
                }

                mazeArray[current.getRow()][current.getCol()] = 0;
                stack.pop();
                current = stack.peek();
                solved = finish(current);
                getSteps();

            }
    }

    private Coordinate north(Coordinate xy) {
        if (xy.getRow() - 1 < 0) {
            return xy;
        } else {
            Coordinate northSpot = new Coordinate(xy.getRow() - 1, xy.getCol());
            if (safe(northSpot)) {
                return northSpot;
            } else {
                return xy;
            }
        }
    }

    private Coordinate east(Coordinate xy) {
        if (xy.getCol() + 1 >= numCols) {
            return xy;
        } else {
            Coordinate eastSpot = new Coordinate(xy.getRow(), xy.getCol() + 1);
            if (safe(eastSpot)) {
                return eastSpot;
            } else {
                return xy;
            }
        }
    }

    private Coordinate south(Coordinate xy) {
        if (xy.getCol() + 1 >= numRows) {
            return xy;
        } else {
            Coordinate southSpot = new Coordinate(xy.getRow() + 1, xy.getCol());
            if (safe(southSpot)) {
                return southSpot;
            } else {
                return xy;
            }
        }
    }

    private Coordinate west(Coordinate xy) {
        if (xy.getCol() - 1 < 0) {
            return xy;
        } else {
            Coordinate westSpot = new Coordinate(xy.getRow(), xy.getCol() - 1);
            if (safe(westSpot)) {
                return westSpot;
            } else {
                return xy;
            }
        }
    }

    private boolean safe(Coordinate xy) {
        if (mazeArray[xy.getRow()][xy.getCol()] == 1) {
            return true;
        } else {
            return false;
        }

    }

    private boolean same(Coordinate xy1, Coordinate xy2) {
        if (xy1.getCol() == xy2.getCol() && xy1.getRow() == xy2.getRow()) {
            return true;
        }
        return false;
    }

    private boolean finish(Coordinate xy) {
        if (same(xy, startingPoint)) {
            return false;
        } else if (xy.getCol() == 0 || xy.getCol() == numCols - 1) {
            return true;
        } else if (xy.getRow() == 0 || xy.getRow() == numRows - 1) {
            return true;
        } else {
            return false;
        }
    }

    private void getSteps() {
        if (solved == true) {
            MyStack steps;
                steps = new MyStack(stack.size());
                MyStack temp;
                temp = stack;
                while(!temp.isEmpty()) {
                    steps.push(temp.pop());
                }
            steps.printStack();
        }
    }
}