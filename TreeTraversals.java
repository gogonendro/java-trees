public class TreeTraversals {
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

    // PRINT INORDER --> LEFT-ROOT-RIGHT
    void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left); // traverse the left subtree
        System.out.print(root.data + " "); // print the node when you can't go left anymore
        printInorder(root.right); // go right exactly one step (and repeat)
    }

    // PRINT PREORDER --> ROOT-LEFT-RIGHT
    void printPreorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " "); // print the root first
        printPreorder(root.left); // traverse the entire left subtree
        printPreorder(root.right); // go right exactly one step (repeat)
    }

    // PRINT POSTORDER --> LEFT-RIGHT-ROOT
    void printPostorder(Node root) {
        if (root == null) {
            return;
        }
        printPostorder(root.left); // traverse the entire left subtree
        printPostorder(root.right); // traverse the entire right subtree
        System.out.print(root.data + " "); // print the root
    }

    public static void main(String[] args) {
        TreeTraversals tree = new TreeTraversals();

        // manually creating tree
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);

        // calling traversing methods
        System.out.print("Inorder: ");
        tree.printInorder(root);
        System.out.print("\nPreorder: ");
        tree.printPreorder(root);
        System.out.print("\nPostorder: ");
        tree.printPostorder(root);
    }
}
