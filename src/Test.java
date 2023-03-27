import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] sizes = {100, 10000, 1000000};

        for (int size : sizes) {
            System.out.println("Testing with array size: " + size);

            // Test AVL Tree
            AVLTree avlTree = new AVLTree();
            int[] arr = new int[size];

            long startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                int value = rand.nextInt(1000000);
                avlTree.insert(avlTree.root, value);
                arr[i] = value;
            }
            long endTime = System.nanoTime();
            long insertTime = endTime - startTime;

            startTime = System.nanoTime();
            for (int value : arr) {
                avlTree.search(avlTree.root, value);
            }
            endTime = System.nanoTime();
            long searchTime = endTime - startTime;

            startTime = System.nanoTime();
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
            arr = new int[size];

            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                int value = rand.nextInt(1000000);
                redBlackTree.insert(value);
                arr[i] = value;
            }
            endTime = System.nanoTime();
            insertTime = endTime - startTime;

            startTime = System.nanoTime();
            for (int value : arr) {
                redBlackTree.search(value);
            }
            endTime = System.nanoTime();
            searchTime = endTime - startTime;

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

            // Test Hash Table
//            HashTable hashTable = new HashTable();
//            arr = new int[size];
//
//            startTime = System.nanoTime();
//            for (int i = 0; i < size; i++) {
//                int key = rand.nextInt(1000000);
//                int value = rand.nextInt(1000000);
//                hashTable.put(String.valueOf(key), value);
//                arr[i] = key;
//            }
//            endTime = System.nanoTime();
//            insertTime = endTime - startTime;
//
//            startTime = System.nanoTime();
//            for (int value : arr) {
//                hashTable.get(String.valueOf(value));
//            }
//            endTime = System.nanoTime();
//            searchTime = endTime - startTime;
//
//            startTime = System.nanoTime();
//            for (int value : arr) {
//                hashTable.delete(hashTable, String.valueOf(value));
//            }
//            endTime = System.nanoTime();
//            deleteTime = endTime - startTime;
//
//            System.out.println("Hash Table:");
//            System.out.println("Insert Time: " + insertTime / 1000000.0 + " ms");
//            System.out.println("Search Time: " + searchTime / 1000000.0 + " ms");
//            System.out.println("Delete Time: " + deleteTime / 1000000.0 + " ms");
//        }
        }
    }
}


