import java.util.*;

public class BSTSearch {
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

    boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        // if root's data is equal to key
        else if (root.data == key) {
            return true;
        }
        // if key is smaller than root then check only left subtree
        else if (key < root.data) {
            return search(root.left, key);
        }
        // else check only the right subtree
        else {
            return search(root.right, key);
        }
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
        BSTSearch tree = new BSTSearch();
        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            root = tree.insert(root, sc.nextInt());
        }

        System.out.print("Tree (Inorder): ");
        tree.display(root);

        System.out.print("\nEnter integer to be searched for: ");
        int key = sc.nextInt();

        if (tree.search(root, key)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }

        sc.close();
    }
}
