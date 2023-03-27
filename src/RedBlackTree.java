public class RedBlackTree<T extends Comparable<T>> {
    boolean RED = true;
    boolean BLACK = false;
    public Node root;

    public void insert(T value) {
        root = insertNode(root, value);
        root.color = BLACK;
    }

    private Node insertNode(Node node, T value) {
        if (node == null) {
            return new Node(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.left = insertNode(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insertNode(node.right, value);
        }
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    private Node rotateLeft(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = RED;
        return right;
    }

    private Node rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = node.color;
        node.color = RED;
        return left;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public boolean contains(T value) {
        Node current = root;
        while (current != null) {
            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public Node search(T value) {
        Node current = root;
        while (current != null) {
            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }


    public void delete(T value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(Node node, T value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.value) < 0) {
            node.left = deleteNode(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node minRightNode = findMinNode(node.right);
                node.value = minRightNode.value;
                node.right = deleteNode(node.right, minRightNode.value);
            }
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private Node findMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public void postOrderTraversal(RedBlackTree.Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }

    public class Node {
        T value;
        Node left, right;
        boolean color;

        Node(T value) {
            this.value = value;
            this.color = RED;
        }
    }
}
