import java.util.*;

public class BSTMinMax {
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

    int findMin(Node root) {
        if (root == null) {
            return 0;
        }
        // traverse the entire left subtree till null
        else if (root.left != null) {
            return findMin(root.left); // return minimum element
        }
        return root.data;
    }

    int findMax(Node root) {
        if (root == null) {
            return 0;
        }
        // traverse entire right subtree until null
        else if (root.right != null) {
            return findMax(root.right); // return max element
        }
        return root.data;
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
        BSTMinMax tree = new BSTMinMax();
        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            root = tree.insert(root, sc.nextInt());
        }

        System.out.print("Tree (Inorder): ");
        tree.display(root);

        if (root == null) {
            System.out.println("\nEmpty");
        } else {
            System.out.println("\nMinimum element: " + tree.findMin(root));
        }

        if (root == null) {
            System.out.println("Empty");
        } else {
            System.out.println("Maximum element: " + tree.findMax(root));
        }
        sc.close();
    }
}
