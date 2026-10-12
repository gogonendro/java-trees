public class BinaryTreeBasic {
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

    void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left); // reach as far left as possible
        System.out.print(root.data + " "); // print the node when you can't go left anymore
        printInorder(root.right); // go right exactly one step (and repeat)
    }

    public static void main(String[] args) {
        BinaryTreeBasic tree = new BinaryTreeBasic(); // because static main method cannot call non-static Node
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);

        System.out.print("Inorder: ");
        tree.printInorder(root);

    }
}
