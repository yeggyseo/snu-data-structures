import java.util.Arrays;

public class MyStack {
    private int size;
    private Object[] stack;
    private int top;

    public MyStack(int size) {
        this.size = size;
        stack = new Object[size];
        top = -1;
    }

    public Integer size() {
        return size;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size -1;
    }

    public void push(Coordinate xy) {

        Object[] tempStack;

        if (top + 1 == size) {
            tempStack = Arrays.copyOf(stack, size * 2);
            tempStack[++top] = xy;

            stack = tempStack;
            size = stack.length;
        } else {
            stack[++top] = xy;
        }
    }

    public Coordinate pop() {
        return (Coordinate) stack[top--];
    }

    public Coordinate peek() {
        return (Coordinate) stack[top];
    }
            
    public void printStack() {
        System.out.println("-- Maze Answer Key --");
        for (int i = top; i >= 0; i--)
            System.out.print(stack[i] + " ");
        System.out.println("\n-- END --");
    }

}
