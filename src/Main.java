import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure
         * 15, 25, 28, 30, 35, 40, 45, 50, 55, 60, 70*/
//        tree.root = tree.insert(tree.root, 30);
//        tree.root = tree.insert(tree.root, 28);
//        tree.root = tree.insert(tree.root, 35);
//        tree.root = tree.insert(tree.root, 15);
//        tree.root = tree.insert(tree.root, 25);
//        tree.root = tree.insert(tree.root, 40);
//        tree.root = tree.insert(tree.root, 45);
//        tree.root = tree.insert(tree.root, 50);
//        tree.root = tree.insert(tree.root, 55);
//        tree.root = tree.insert(tree.root, 60);
//        tree.root = tree.insert(tree.root, 70);
//        4 2 5 1 3
//        tree.root = tree.insert(tree.root, 4);
//        tree.root = tree.insert(tree.root, 1);
//        tree.root = tree.insert(tree.root, 2);
//        tree.root = tree.insert(tree.root, 3);
//        tree.root = tree.insert(tree.root, 5);

//        4 6 9 12 15 20 10
//        tree.root = tree.insert(tree.root, 4);
//        tree.root = tree.insert(tree.root, 6);
//        tree.root = tree.insert(tree.root, 9);
//        tree.root = tree.insert(tree.root, 12);
//        tree.root = tree.insert(tree.root, 15);
//        tree.root = tree.insert(tree.root, 20);
//        tree.root = tree.insert(tree.root, 10);


        //15, 25, 28, 30, 35, 40, 45, 50, 55, 60, 70
//        tree.root = tree.insert(tree.root, 10);
//        tree.root = tree.insert(tree.root, 20);
//        tree.root = tree.insert(tree.root, 30);
//        tree.root = tree.insert(tree.root, 40);
//        tree.root = tree.insert(tree.root, 50);
//        tree.root = tree.insert(tree.root, 25);


//4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 18);
        tree.root = tree.insert(tree.root, 22);
        tree.root = tree.insert(tree.root, 24);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 31);
        tree.root = tree.insert(tree.root, 35);
        tree.root = tree.insert(tree.root, 44);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 66);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 90);


//        tree.inorder(tree.root);
//        System.out.print("\n");
//        tree.preorder(tree.root);
//        System.out.print("\n");
        tree.postorder(tree.root);


        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read input from the keyboard
        System.out.print("What key you want to find?");
        int num = scanner.nextInt(); // Read an integer from the keyboard
        Node result = tree.search(tree.root, num);
        if (result != null) {
            System.out.println("Found: " + result.key);
        } else {
            System.out.println("Not found");
        }

        //10, 18, 7, 15, 16, 30, 25, 40, 60

        RedBlackTree<Integer> tree2 = new RedBlackTree<>();
        tree2.insert(10);
        tree2.insert(18);
        tree2.insert(7);
        tree2.insert(15);
        tree2.insert(16);
        tree2.insert(30);
        tree2.insert(25);
        tree2.insert(40);
        tree2.insert(60);

        tree2.postOrderTraversal(tree2.root);

    }

}
