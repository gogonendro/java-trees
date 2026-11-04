import java.util.*;

public class BSTInorderSuccessor {
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
        if (root == null) {
            Node newNode = new Node(data);
            return newNode;
        } else if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
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

    // find successor using while loop
    int findSuccessor(Node root, int key) {
        Node successor = null; // set successor node to null

        // run until root is null
        while (root != null) {
            // if root's data is greater than inserted key
            if (root.data > key) {
                successor = root; // set root as successor node
                root = root.left; // move to left subtree
            } else {
                // otherwise move to the right subtree
                root = root.right;
            }
        }
        if (successor == null) {
            return -1;
        }
        return successor.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTInorderSuccessor tree = new BSTInorderSuccessor();

        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();
        Node root = null;

        // take input
        System.out.println("Enter " + n + " integers: ");
        for (int i = 0; i < n; i++) {
            root = tree.insert(root, sc.nextInt());
        }

        // display the tree
        System.out.print("Tree (Inorder): ");
        tree.display(root);

        System.out.print("\nEnter the key: ");
        int key = sc.nextInt();

        // display the successor
        System.out.print("Successor of " + key + ": " + tree.findSuccessor(root, key));

        sc.close();
    }
}
