
class AVLTree {
    Node root;

    int height(Node node) {                // Get the height of a node
        if (node == null)
            return 0;
        return node.height;
    }

    int balanceFactor(Node node) {                // Get the balance factor of a node
        if (node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = node.right != null ? height(node.right) : 0;
        return leftHeight - rightHeight;
    }

    Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        node.height = 1 + Math.max(height(node.left), height(node.right));                   // Update heights
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));

        return newRoot;
    }

    Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        node.height = 1 + Math.max(height(node.left), height(node.right));                    // Update heights
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));

        return newRoot;
    }

    Node insert(Node node, int key) {             // Insert a key into the tree
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // No duplicates allowed

        node.height = 1 + Math.max(height(node.left), height(node.right));                      // Update height of current node
        int bf = balanceFactor(node);

        if (bf > 1 && key < node.left.key)                     // Left left case
            return rotateRight(node);

        if (bf < -1 && key > node.right.key)                   // Right right case
            return rotateLeft(node);

        if (bf > 1 && key > node.left.key) {                            // Left right case
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (bf < -1 && key < node.right.key) {                             // Right left case
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }


    Node search(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        }
        if (key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }


    Node delete(Node node, int key) {
        if (node == null) {
            return node;
        }
        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {                    // Node has no children or only one child
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node temp = findMin(node.right);             // Node has two children
            node.key = temp.key;
            node.right = delete(node.right, temp.key);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int bf = balanceFactor(node);

        if (bf > 1 && balanceFactor(node.left) >= 0) {                    // Left left case
            return rotateRight(node);
        }

        if (bf > 1 && balanceFactor(node.left) < 0) {                     // Left right case
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (bf < -1 && balanceFactor(node.right) <= 0) {                // Right right case
            return rotateLeft(node);
        }

        if (bf < -1 && balanceFactor(node.right) > 0) {                 // Right left case
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    //    void inorder(Node node) {
//        if (node == null)
//            return;
//        inorder(node.left);
//        System.out.print(node.key + " ");
//        inorder(node.right);
//    }
//    void preorder(Node node) {
//        if (node == null)
//            return;
//        System.out.print(node.key + " ");
//        preorder(node.left);
//        preorder(node.right);
//    }
    void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.key + " ");
    }
}