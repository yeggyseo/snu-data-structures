public class QuickSort {
    public int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int smallerElem = (low - 1);

        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                smallerElem++;

                int temp = arr[smallerElem];
                arr[smallerElem] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[smallerElem + 1];
        arr[smallerElem + 1] = arr[high];
        arr[high] = temp;

        return smallerElem + 1;
    }

    public void sort(int arr[], int low, int high) {
        if (low < high) {
            int partitionedIndex = partition(arr, low, high);

            sort(arr, low, partitionedIndex - 1);
            sort(arr, partitionedIndex + 1, high);
        }
    }
}
