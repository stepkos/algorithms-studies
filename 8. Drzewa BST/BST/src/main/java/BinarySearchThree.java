import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinarySearchThree {
    static class Node {
        int key;
        Node left, right, parent;

        public Node(int item) {
            key = item;
            parent = left = right = null;
        }
    }

    Node root;

    BinarySearchThree() {
        root = null;
    }

    void insert(int key) {
        root = insertNode(root, null, key);
    }

    Node insertNode(Node root, Node parent, int key) {
        if (root == null) {
            root = new Node(key);
            root.parent = parent;
            return root;
        }

        if (key < root.key)
            root.left = insertNode(root.left, root, key);
        else if (key > root.key)
            root.right = insertNode(root.right, root, key);

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
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }


    int getNumNodes(Node root) {
        if (root == null) return 0;
        return getNumNodes(root.left) + getNumNodes(root.right) + 1;
    }

    int getNumLeaves(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        else
            return getNumLeaves(root.left) + getNumLeaves(root.right);
    }

    // Zad 2 --------------------------------------------

    public void printLevelOrder() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                System.out.print(node.key + " ");
                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
            System.out.println();
        }
    }

    public Node successor(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            // jesli ma prawe poddrzewo to zwracamy najmniejszy element z prawego poddrzewa
            Node current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        } else {
            // jesli wezel nie ma prawego poddrzewa to idziemy w gore drzewa az znajdziemy pierwszy wezel, ktory jest
            // lewym dzieckiem swojego rodzica i zwracamy rodzica tego wezla
            Node current = node;
            Node parent = current.parent;
            while (parent != null && current == parent.right) {
                current = parent;
                parent = current.parent;
            }
            return parent;
        }
    }

    public Node predecessor(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            // jesli ma lewe poddrzewo to zwracamy najwiekszy element z lewego poddrzewa
            Node current = node.left;
            while (current.right != null) {
                current = current.right;
            }
            return current;
        } else {
            // jesli wezel nie ma lewego poddrzewa to idziemy w gore drzewa az znajdziemy pierwszy wezel, ktory jest
            // prawym dzieckiem swojego rodzica i zwracamy rodzica tego wezla
            Node current = node;
            Node parent = current.parent;
            while (parent != null && current == parent.left) {
                current = parent;
                parent = current.parent;
            }
            return parent;
        }
    }

    void deleteNode(int key) {
        root = deleteNode(root, key);
    }

    Node deleteNode(Node root, int key) {
        if (root == null)
            return null;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            Node temp = root;
            root = successor(temp);
            root.left = temp.left;
            root.right = deleteNode(temp.right, root.key);
        }

        return root;
    }

    void printTree() {
        if (root == null) {
            System.out.println("Drzewo jest puste");
            return;
        }
        printTree(root, "", true);
    }

    void printTree(Node node, String prefix, boolean isLeft) {
        if (node == null)
            return;

        System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.key);

        // obliczenie prefiksu dla lewego i prawego poddrzewa
        String newPrefix = prefix + (isLeft ? "|   " : "    ");

        // rekurencyjne wywołanie metody dla lewego i prawego poddrzewa
        printTree(node.left, newPrefix, true);
        printTree(node.right, newPrefix, false);
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        BinarySearchThree bst = new BinarySearchThree();
        int choice = 0;

        do {
            System.out.println("\n1. Insert a node");
            System.out.println("2. Inorder traversal");
            System.out.println("3. Preorder traversal");
            System.out.println("4. Postorder traversal");
            System.out.println("5. Search for a node");
            System.out.println("6. Find minimum value");
            System.out.println("7. Find maximum value");
            System.out.println("8. Get height of tree");
            System.out.println("9. Get number of nodes in tree");
            System.out.println("10. Get number of leaves in tree");
            System.out.println("11. Print level order traversal");
            System.out.println("12. Get successor of a node");
            System.out.println("13. Get predecessor of a node");
            System.out.println("14. Delete a node");
            System.out.println("15. Print tree");
            System.out.println("16. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the key to insert: ");
                    int key = scanner.nextInt();
                    bst.insert(key);
                    System.out.println(key + " inserted successfully.");
                    break;

                case 2:
                    System.out.print("Inorder traversal: ");
                    bst.inorderTraversal(bst.root);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Preorder traversal: ");
                    bst.preorderTraversal(bst.root);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Postorder traversal: ");
                    bst.postorderTraversal(bst.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Enter the key to search: ");
                    key = scanner.nextInt();
                    BinarySearchThree.Node node = bst.search(bst.root, key);
                    if (node != null)
                        System.out.println("Node found: " + node.key);
                    else
                        System.out.println("Node not found.");
                    break;

                case 6:
                    int min = bst.findMin(bst.root);
                    System.out.println("Minimum value in tree: " + min);
                    break;

                case 7:
                    int max = bst.findMax(bst.root);
                    System.out.println("Maximum value in tree: " + max);
                    break;

                case 8:
                    int height = bst.getHeight(bst.root);
                    System.out.println("Height of tree: " + height);
                    break;

                case 9:
                    int numNodes = bst.getNumNodes(bst.root);
                    System.out.println("Number of nodes in tree: " + numNodes);
                    break;

                case 10:
                    int numLeaves = bst.getNumLeaves(bst.root);
                    System.out.println("Number of leaves in tree: " + numLeaves);
                    break;

                case 11:
                    System.out.println("Level order traversal:");
                    bst.printLevelOrder();
                    break;

                case 12:
                    System.out.print("Enter the key of the node to find successor for: ");
                    key = scanner.nextInt();
                    node = bst.search(bst.root, key);
                    if (node != null) {
                        BinarySearchThree.Node successor = bst.successor(node);
                        if (successor != null)
                            System.out.println("Successor of " + key + " is " + successor.key);
                        else
                            System.out.println("No successor found for " + key);
                    }
                    else
                        System.out.println("Node with key " + key + " not found");
                    break;

                case 13:
                    System.out.print("Enter the key of the node to find predecessor for: ");
                    key = scanner.nextInt();
                    node = bst.search(bst.root, key);
                    if (node != null) {
                        BinarySearchThree.Node predecessor = bst.predecessor(node);
                        if (predecessor != null)
                            System.out.println("Predecessor of " + key + " is " + predecessor.key);
                        else
                            System.out.println("Predecessor not found.");
                    }
                    else
                        System.out.println("Node not found.");
                    break;

                case 14:
                    System.out.print("Enter the key to delete: ");
                    key = scanner.nextInt();
                    bst.deleteNode(key);
                    System.out.println(key + " deleted successfully.");
                    break;

                case 15:
                    System.out.println("Tree:");
                    bst.printTree(bst.root, "", true);
                    break;

                case 16:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;

            }
        } while (choice != 16);

    }

    public static void demo() {
        BinarySearchThree bst = new BinarySearchThree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(11);
        bst.insert(6);
        bst.insert(7);
        bst.insert(3);
        bst.insert(8);

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

        bst.printLevelOrder();

        bst.deleteNode(5);
        bst.printLevelOrder();

        System.out.println(bst.getHeight(bst.root));
        System.out.println(bst.getNumNodes(bst.root));
        bst.printTree();
    }

    public static void main(String[] args) {
        menu();
    }

}
