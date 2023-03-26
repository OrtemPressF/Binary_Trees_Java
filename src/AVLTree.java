
class AVLTree {
    Node root;

    // Get the height of a node
    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Get the balance factor of a node
    int balanceFactor(Node node) {
        if (node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = node.right != null ? height(node.right) : 0;
        return leftHeight - rightHeight;
    }

    // Rotate right at a node
    Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        // Update heights
        node.height = 1 + Math.max(height(node.left), height(node.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));

        return newRoot;
    }

    // Rotate left at a node
    Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        // Update heights
        node.height = 1 + Math.max(height(node.left), height(node.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));

        return newRoot;
    }




    // Insert a key into the tree
    Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // No duplicates allowed

        // Update height of current node
        node.height = 1 + Math.max(height(node.left), height(node.right));
        // Check balance factor
        int bf = balanceFactor(node);

        // Left left case
        if (bf > 1 && key < node.left.key)
            return rotateRight(node);

        // Right right case
        if (bf < -1 && key > node.right.key)
            return rotateLeft(node);

        // Left right case
        if (bf > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right left case
        if (bf < -1 && key < node.right.key) {
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
            // Case 1: Node has no children or only one child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // Case 2: Node has two children
            Node temp = findMin(node.right);
            node.key = temp.key;
            node.right = delete(node.right, temp.key);
        }

        // Update height and balance factor
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int bf = balanceFactor(node);

        // Left left case
        if (bf > 1 && balanceFactor(node.left) >= 0) {
            return rotateRight(node);
        }

        // Left right case
        if (bf > 1 && balanceFactor(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right right case
        if (bf < -1 && balanceFactor(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Right left case
        if (bf < -1 && balanceFactor(node.right) > 0) {
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