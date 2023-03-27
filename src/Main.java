import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

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


        tree.postorder(tree.root);

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
