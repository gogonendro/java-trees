import java.util.*;

public class LevelOrderTraversal {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /*
     * Node insert(Node root, int data) {
     * if (root == null) {
     * Node newNode = new Node(data);
     * return newNode;
     * } else if (data < root.data) {
     * root.left = insert(root.left, data);
     * } else if (data > root.data) {
     * root.right = insert(root.right, data);
     * }
     * return root;
     * }
     * 
     * void display(Node root) {
     * if (root == null) {
     * return;
     * } else {
     * display(root.left);
     * System.out.print(root.data + " ");
     * display(root.right);
     * }
     * }
     */

    public static void main(String[] args) {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        // Scanner sc = new Scanner(System.in);
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);

        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
        System.out.println(root.left.left.data);
        System.out.println(root.left.right.data);

        /*
         * System.out.print("Enter the number of elements: ");
         * int n = sc.nextInt();
         * 
         * for (int i = 0; i < n; i++) {
         * root = tree.insert(root, sc.nextInt());
         * }
         * 
         * System.out.print("Tree: ");
         * tree.display(root);
         */
    }
}
