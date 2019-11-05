// Yegeon Seo, 2018-81365
// All hash functions work, except I am not sure what to do with the file
// It reads in the file, but I'm unsure what to do with it..

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

 
 
/** Class LinearProbingHashTable **/
public class LinearProbingHashTable
{

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/yeggy/IdeaProjects/Exam/out/production/Exam/hash.txt");
        Scanner sc = new Scanner(file);

        LinearProbingHashTable ht = new LinearProbingHashTable(10);

        ht.insert(sc.next(), "2");
        ht.insert("2", "3");
        ht.insert("3", "4");

        ht.remove("3");

        ht.printHashTable();

    }

    private int currentSize, maxSize;       
    private String[] keys;
    private String[] vals;
 
    /** Constructor **/
    public LinearProbingHashTable(int capacity) 
    {
        this.maxSize = capacity;
        keys = new String[capacity];
        vals = new String[capacity];
    }  

    /** Function to get size of hash table **/
    public int getSize() 
    {
         System.out.println(currentSize);
         return currentSize;
    }
 
    /** Function to check if hash table is empty **/
    public boolean isEmpty() 
    {
        return getSize() == 0;
    }
 
    /** Function to get hash code of a given key **/
    private int hashCode(String key)
    {
        int integer = Integer.parseInt(key);
        integer %= this.maxSize;
        return integer;

    }
 
    /** Function to insert key-value pair **/
    public void insert(String key, String val)
    {
        Integer n = hashCode(key);
        keys[n] = key;
        vals[n] = val;

        for (int i = 0; i < keys.length; i ++) {
            if (i == n) {
                vals[i] = val;
                currentSize++;
            }
        }
    }

    public void hashFunction(String key, String val) {
        Integer n = hashCode(key);
        keys[n] = key;
        vals[n] = val;

        for (int i = 0; i < keys.length; i ++) {
            if (i == n) {
                vals[i] = val;
                currentSize++;
            }
        }

        int mod = n % 10000003;

        while (vals[mod] != null) {
            mod ++;
            mod %= currentSize;
        }
        vals[mod] = val;

    }
 
    /** Function to get value for a given key **/
    public String get(String key)
    {
        Integer n = hashCode(key);
        keys[n] = key;

        for (int i = 0; i < keys.length; i++) {
            if (i == n) {
                System.out.println(vals[i]);
                return vals[i];
            }
        }
        return null;
    }
 
    /** Function to remove key and its value **/
    public void remove(String key)
    {
        Integer n = hashCode(key);
        keys[n] = key;

        for (int i = 0; i < keys.length; i ++) {
            if (i == n) {
                vals[i] = null;
                keys[i] = null;
                currentSize --;
            }
        }
    }
 
    /** Function to print HashTable **/
    public void printHashTable()
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
              System.out.println("(" + keys[i]+","+ vals[i]+")");
        System.out.println();
    }
}
