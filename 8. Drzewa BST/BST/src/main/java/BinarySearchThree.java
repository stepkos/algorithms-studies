class BinarySearchTree {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertNode(root, key);
    }

    Node insertNode(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertNode(root.left, key);
        else if (key > root.key)
            root.right = insertNode(root.right, key);

        return root;
    }

    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.key + " ");
            inorderTraversal(root.right);
        }
    }

    void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.key + " ");
        }
    }

    Node search(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key)
            return search(root.left, key);

        return search(root.right, key);
    }

    int findMin(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }

    int findMax(Node root) {
        int max = root.key;
        while (root.right != null) {
            max = root.right.key;
            root = root.right;
        }
        return max;
    }

    int getHeight(Node root) {
        if (root == null)
            return 0;
        else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            if (leftHeight > rightHeight)
                return (leftHeight + 1);
            else
                return (rightHeight + 1);
        }
    }

    int getNumNodes(Node root) {
        if (root == null)
            return 0;
        else
            return (getNumNodes(root.left) + 1 + getNumNodes(root.right));
    }

    int getNumLeaves(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        else
            return getNumLeaves(root.left) + getNumLeaves(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.print("Inorder traversal: ");
        bst.inorderTraversal(bst.root);
        System.out.println();

        System.out.print("Preorder traversal: ");
        bst.preorderTraversal(bst.root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        bst.postorderTraversal(bst.root);
        System.out.println();

        // znajdujemy węzeł o kluczu 60 i wyświetlamy jego wartość
        Node foundNode = bst.search(bst.root, 60);
        System.out.println("Found node: " + foundNode.key);

        // znajdujemy wartości minimalną i maksymalną
        int minValue = bst.findMin(bst.root);
        int maxValue = bst.findMax(bst.root);
        System.out.println("Minimum value: " + minValue);
        System.out.println("Maximum value: " + maxValue);

        // wyznaczamy i wyświetlamy parametry drzewa
        int height = bst.getHeight(bst.root);
        int numNodes = bst.getNumNodes(bst.root);
        int numLeaves = bst.getNumLeaves(bst.root);
        System.out.println("Height: " + height);
        System.out.println("Number of nodes: " + numNodes);
        System.out.println("Number of leaves: " + numLeaves);
    }
}
