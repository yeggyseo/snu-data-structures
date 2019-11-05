import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Sort {
    private static String fileName = "";

    public Sort(String input) {
        fileName = input;
    }

    public static void main(String[] args) {
        long startTime;
        long elapsedTime;

        try {
            Sort sort = new Sort("input.txt");
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String fileContent = file.readLine();
            String[] content = fileContent.split(" ");

            int[] arrBST = Arrays.stream(content).mapToInt(Integer::parseInt).toArray();
            int[] arrSS = Arrays.stream(content).mapToInt(Integer::parseInt).toArray();;
            int[] arrQS = Arrays.stream(content).mapToInt(Integer::parseInt).toArray();;
            int[] arrHS = Arrays.stream(content).mapToInt(Integer::parseInt).toArray();;
            int[] arrSPS = Arrays.stream(content).mapToInt(Integer::parseInt).toArray();;
            int[] arrMS = Arrays.stream(content).mapToInt(Integer::parseInt).toArray();;

            /** ----------------------------------- **/
                        // BST SORT //

            BSTSort bstSort = new BSTSort();

            startTime = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                bstSort.makeTree(arrBST);
            }
            elapsedTime = (System.currentTimeMillis() - startTime) / 100;

            System.out.println(elapsedTime + " ms BST Sort");

            if (bstSort.isBST()) {
                System.out.println("Array is sorted\n");
            } else {
                System.out.println("Array is not Sorted\n");
            }

            /** ----------------------------------- **/
                        // SELECTION SORT //

            SelectionSort selectionSort = new SelectionSort();

            startTime = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                selectionSort.sort(arrSS);
            }
            elapsedTime = (System.currentTimeMillis() - startTime) / 100;

            System.out.println(elapsedTime + " ms Selection Sort");
            isArraySorted(arrSS, arrSS.length);

            /** ----------------------------------- **/
                        // QUICK SORT //

            QuickSort quickSort = new QuickSort();

            startTime = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                quickSort.sort(arrQS, 0, arrQS.length - 1);
            }
            elapsedTime = (System.currentTimeMillis() - startTime) / 100;

            System.out.println(elapsedTime + " ms QuickSort");
            isArraySorted(arrQS, arrQS.length);

            /** ----------------------------------- **/
              // HEAP SORT WITHOUT INITIALIZATION //

            HeapSortWI heapSortWI = new HeapSortWI();

            startTime = System.currentTimeMillis();
            for (int i  = 0; i < 100; i++) {
                heapSortWI.heapsort(arrHS);
            }
            elapsedTime = (System.currentTimeMillis() - startTime) / 100;

            System.out.println(elapsedTime + " ms Heap Sort Without Initialization");
            isArraySorted(arrHS, arrHS.length);

            /** ----------------------------------- **/
                        // SPLAY SORT //

            SplayTreeSort splayTreeSort = new SplayTreeSort(arrSPS);

            startTime = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                splayTreeSort = new SplayTreeSort(arrSPS);
            }
            elapsedTime = (System.currentTimeMillis() - startTime) / 100;

            System.out.println(elapsedTime + " ms Splay Tree Sort");

            if (splayTreeSort.isSplay()) {
                System.out.println("Array is sorted\n");
            } else {
                System.out.println("Array is not Sorted\n");
            }

            /** ----------------------------------- **/
                        // MERGE SORT //

            MergeSort mergeSort = new MergeSort();

            startTime = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                mergeSort.sort(arrMS, 0, arrMS.length - 1);
            }
            elapsedTime = (System.currentTimeMillis() - startTime) / 100;

            System.out.println(elapsedTime + " ms Merge Sort");
            isArraySorted(arrMS, arrMS.length);

            /** ----------------------------------- **/

            System.out.println("Original input.txt = " + Arrays.toString(content));
            System.out.println("\nSorted output of input.txt = " + Arrays.toString(arrMS));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int isArraySorted(int[] arr, int n) {
        if (n == 0 || n == 1) {
            System.out.println("Array is sorted\n");
            return 1;
        }
        if (arr[n - 1] < arr[n - 2]) {
            System.out.println("Array is not Sorted\n");
            return 0;
        }
        return isArraySorted(arr, n - 1);
    }
}
