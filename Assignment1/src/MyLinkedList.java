import java.util.Arrays;

public class MyLinkedList implements LinkedList {
    int size;
    Object[] linkedList;

    public MyLinkedList() {
        size = 0;
        linkedList = new Object[size];
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            System.out.println("The list is empty.\n");
        } else {
            System.out.println("The list contains some element(s).\n");
        }
        return size == 0;
    }

    @Override
    public int size() {
        System.out.println("The current size is: " + size);
        return size;
    }

    @Override
    public Object get(int index) {
        for (int i = 0; i < size; i++) {
            if (i == index) {
                System.out.println("String at the given index is: " + linkedList[i]);
                return linkedList[i];
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object elem) {
        for (int i = 0; i < size; i++) {
            if (linkedList[i] == elem) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public Object remove(int index) {
        Object removedElement = linkedList[index];
        for (int i = index + 1; i < size; i ++) {
            linkedList[i - 1] = linkedList[i];
        }
        System.out.println(linkedList[index] + " is removed.");
        linkedList[--size] = null;
        return removedElement;
    }

    @Override
    public void add(int index, Object obj) {
        Object[] tmpList;
        if (index < 0 || index > size) {
            System.out.println("The last index is " + size);
        } else if (index == size && size != 0) {
            tmpList = Arrays.copyOf(linkedList, size * 2);
            linkedList = tmpList;
            size = linkedList.length;
            linkedList[index] = obj;
        } else if (index == size && size == 0) {
            tmpList = Arrays.copyOf(linkedList, 1);
            linkedList = tmpList;
            size = linkedList.length;
            linkedList[index] = obj;
        }
        else {
            tmpList = Arrays.copyOf(linkedList, size * 2);
            System.arraycopy(linkedList, index, tmpList, index + 1, size - index);
            linkedList[index] = obj;
        }
    }

    public String toString() {
        String result = Arrays.toString(linkedList);
        System.out.println(result);
        return result;
    }

    }





