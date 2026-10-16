import java.util.*;

public class BSTDelete {
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

    // returns the smallest element
    Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    Node delete(Node root, int key) {
        // if tree empty
        if (root == null) {
            return null;
        }
        // traverse entire left and right subtree until match is found
        else if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        }

        // when match is found
        else {
            // if the node is a leaf (no children)
            if (root.left == null && root.right == null) {
                System.out.println(key + " deleted from tree");
                return null; // return null
            }
            // if node has exactly one child
            else if (root.left == null) {
                System.out.println(key + " deleted from tree");
                return root.right; // return the right node when left is null
            } else if (root.right == null) {
                System.out.println(key + " deleted from tree");
                return root.left; // return the left node when right is null
            }
            // if node has two children
            else {
                Node successor = findMin(root.right); // find the smallest node in the right subtree
                root.data = successor.data; // copy the smallest node's data in the root node
                root.right = delete(root.right, successor.data); // delete the smallest node of the right subtree
                System.out.println(key + " deleted from tree");
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTDelete tree = new BSTDelete();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        Node root = null;

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            root = tree.insert(root, sc.nextInt());
        }

        System.out.print("Tree (Inorder): ");
        tree.display(root);

        System.out.print("\nEnter element to be deleted: ");
        int key = sc.nextInt();
        root = tree.delete(root, key);

        System.out.print("Tree (Inorder): ");
        tree.display(root);

        sc.close();
    }
}
