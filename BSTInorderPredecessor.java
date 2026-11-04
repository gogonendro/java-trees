import java.util.*;

public class BSTInorderPredecessor {
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

    // find predecessor using while loop
    int findPredecessor(Node root, int key) {
        Node predecessor = null; // set predecessor node to null

        // run until root is null
        while (root != null) {
            // if root's data is smaller than inserted key
            if (root.data < key) {
                predecessor = root; // set root as predecessor node
                root = root.right; // move to right subtree
            } else {
                // otherwise move to the left subtree
                root = root.left;
            }
        }
        if (predecessor == null) {
            return -1;
        }
        return predecessor.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTInorderPredecessor tree = new BSTInorderPredecessor();

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

        // display the predecessor
        System.out.print("Predecessor of " + key + ": " + tree.findPredecessor(root, key));

        sc.close();
    }
}
