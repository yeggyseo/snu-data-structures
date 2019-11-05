/** Class LinearProbingHashTableTest **/
public class LinearProbingHashTableTest
{
    public static void main(String[] args)
    {
        LinearProbingHashTable ht = new LinearProbingHashTable(1000003);


//        ht.hashFunction();

        long startTime = System.currentTimeMillis();

        System.out.println(startTime);

        long elapsedTime = startTime - System.currentTimeMillis();

        System.out.println(elapsedTime);


    }
}
