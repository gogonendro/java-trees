import java.util.*;

public class BinarySearchTree {
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

    Node insert(Node root, int data) {
        // if root is empty
        if (root == null) {
            Node newNode = new Node(data);
            return newNode; // insert a new node there
        }
        // if input data is less than root
        else if (data < root.data) {
            // add it to the left of the root (recursively)
            root.left = insert(root.left, data);
        }
        // if input is greater than root
        else if (data > root.data) {
            // add it to the right of the root (recursively)
            root.right = insert(root.right, data);
        }
        return root;
    }

    void display(Node root) {
        if (root == null) {
            return;
        } else {
            display(root.left);
            System.out.print(root.data + " ");
            display(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            root = tree.insert(root, sc.nextInt());
        }

        System.out.print("Tree (Inorder): ");
        tree.display(root);

        sc.close();
    }
}
