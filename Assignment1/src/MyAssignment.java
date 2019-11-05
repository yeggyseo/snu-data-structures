
//Yegeon Seo
//2018-81365
//I could not finish the second part of the homework..



import java.util.Scanner;

public class MyAssignment extends MyLinkedList {
    public static void help() {
        System.out.println("Choice\tAction" +
                "\n------\t------" +
                "\n  A   \tAdd String" +
                "\n  C   \tCheck if Empty" +
                "\n  E   \tSearch for a String" +
                "\n  L   \tList Strings" +
                "\n  O   \tList Current Size" +
                "\n  Q   \tQuit" +
                "\n  R   \tRemove String" +
                "\n  T   \tReverse" +
                "\n  U   \tRemove Duplicate" +
                "\n  ?   \tDisplay Help");
    }
    //, t, u

    public static void main(String[] args) {
        help();

        MyLinkedList linkedList = new MyLinkedList();

        while(true) {

            Scanner answerScanner = new Scanner(System.in);
            System.out.println("What action would you like to perform?");
            String answer = answerScanner.next();
            if ("Q".equalsIgnoreCase(answer)) {
                System.out.println("Bye!");
                System.exit(0);
            }

            else if ("C".equalsIgnoreCase(answer)) {
                linkedList.isEmpty();
            }

            else if ("?".equalsIgnoreCase(answer)) {
                help();
            }

            else if ("O".equalsIgnoreCase(answer)) {
                linkedList.size();
            }

            else if ("A".equalsIgnoreCase(answer)) {
                Scanner inputObj = new Scanner(System.in);
                System.out.println("Please enter a string to add");
                Object obj = inputObj.nextLine();
                System.out.println("Please enter an index to add");
                while (!inputObj.hasNextInt()) inputObj.next();
                int index = inputObj.nextInt();

                linkedList.add(index, obj);
            }

            else if ("L".equalsIgnoreCase(answer)) {
                linkedList.toString();
            }

            else if ("E".equalsIgnoreCase(answer)) {
                Scanner inputIndex = new Scanner(System.in);
                System.out.println("Please enter an index to search");
                int input = inputIndex.nextInt();
                linkedList.get(input);
            }

            else if ("R".equalsIgnoreCase(answer)) {
                Scanner inputIndex = new Scanner(System.in);
                System.out.println("Please enter an index to remove");
                int input = inputIndex.nextInt();

                if (input > linkedList.size() || input < 0) {
                    System.out.println("Index does not exist");
                }
                linkedList.remove(input);
            }
        }
    }
}
