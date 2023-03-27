import java.util.Random;

public class Test {
    public static void main(String[] args) {
        // Test AVL Tree
        AVLTree avlTree = new AVLTree();
        int n = 10000;
        int[] arr = new int[n];
        Random rand = new Random();

        long startTime = System.nanoTime();                  // Insert n random integers into AVL Tree
        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(1000000);
            avlTree.insert(avlTree.root, value);
            arr[i] = value;
        }
        long endTime = System.nanoTime();
        long insertTime = endTime - startTime;

        startTime = System.nanoTime();                // Search for all integers in the array
//        for (int value : arr) {
//            avlTree.contains(value);
//        }
        endTime = System.nanoTime();
        long searchTime = endTime - startTime;

        startTime = System.nanoTime();                           // Delete all integers in the array
        for (int value : arr) {
            avlTree.delete(avlTree.root, value);
        }
        endTime = System.nanoTime();
        long deleteTime = endTime - startTime;

        System.out.println("AVL Tree:");
        System.out.println("Insert Time: " + insertTime / 1000000.0 + " ms");
        System.out.println("Search Time: " + searchTime / 1000000.0 + " ms");
        System.out.println("Delete Time: " + deleteTime / 1000000.0 + " ms");

        // Test Red-Black Tree
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();

        // Insert n random integers into Red-Black Tree
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(1000000);
            redBlackTree.insert(value);
            arr[i] = value;
        }
        endTime = System.nanoTime();
        insertTime = endTime - startTime;

        // Search for all integers in the array
        startTime = System.nanoTime();
        for (int value : arr) {
            redBlackTree.contains(value);
        }
        endTime = System.nanoTime();
        searchTime = endTime - startTime;

        // Delete all integers in the array
        startTime = System.nanoTime();
        for (int value : arr) {
            redBlackTree.delete(value);
        }
        endTime = System.nanoTime();
        deleteTime = endTime - startTime;

        System.out.println("\nRed-Black Tree:");
        System.out.println("Insert Time: " + insertTime / 1000000.0 + " ms");
        System.out.println("Search Time: " + searchTime / 1000000.0 + " ms");
        System.out.println("Delete Time: " + deleteTime / 1000000.0 + " ms");


        HashTable hashTable = new HashTable();

        // Insert n random integers into Hash Table
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int key = rand.nextInt(1000000);
            int value = rand.nextInt(1000000);
//            hashTable.put(key, value);
        }
        endTime = System.nanoTime();
        insertTime = endTime - startTime;

        // Search for all integers in the array
        startTime = System.nanoTime();
//        for (int value : arr) {
//            hashTable.get(value);
//        }
        endTime = System.nanoTime();
        searchTime = endTime - startTime;


        // Delete all keys in the Hash table
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int key = rand.nextInt(1000000);
//            hashTable.delete(key);
        }
        endTime = System.nanoTime();
        long deleteTimeHashTable = endTime - startTime; // Rename the variable to "deleteTimeHashTable"

        System.out.println("Hash Table:");
        System.out.println("Insert Time: " + insertTime / 1000000.0 + " ms");
        System.out.println("Search Time: " + searchTime / 1000000.0 + " ms");
        System.out.println("Delete Time: " + deleteTimeHashTable / 1000000.0 + " ms");
    }


}
