class Node <Value> {
    int key, height;
    Node left, right;
        private Value val;
        boolean color;
        int size;

        public Node(int key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }


    Node(int key) {
        this.key = key;
        this.height = 1;
    }
}