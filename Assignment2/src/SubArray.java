import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;


public class SubArray {

    // reading in a text file
    private static String fileName = "array.txt";
    private static String[] numbers;
    private static String arrayLines;

    // constructor
    public SubArray(String inputName) {
        fileName = inputName;
    }

    // Method to add to int[]
    public static int[] add(int[] elem, int num) {
        elem = Arrays.copyOf(elem, elem.length + 1);
        elem[elem.length - 1] = num;
        return elem;
    }

    public static void main (String[] arg) {
        try {
            BufferedReader arrayContent = new BufferedReader(new FileReader(fileName));
            int[] array = new int[] {};
            while (arrayContent.ready()) {
                arrayLines = arrayContent.readLine();
                numbers = arrayLines.split("\n");

                for (int i = 0; i < numbers.length; i++) {
                    array = add(array, Integer.parseInt(numbers[i]));
                }
            }

            printAllSubArrays(array);


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void printAllSubArrays(int[] A)
    {
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap();

        for (int i = 0; i < A.length; i ++) {
            sum += A[i];
            if(sum == 0) {
                System.out.println("Subarray found from Index 0 to " + i);
            } else if(hm.get(sum) != null) {
                System.out.println("Subarray found from Index "
                        + (hm.get(sum) + 1)
                        + " to " + i);
                hm.put(sum, i);
            }
            else
                hm.put(sum, i);
        }
    }

}
