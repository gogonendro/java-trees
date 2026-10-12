import java.util.*;

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

    // PRINT INORDER --> LEFT-ROOT-RIGHT
    void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left); // reach as far left as possible
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

    // COUNTING NODES
    int countNode(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + countNode(root.left) + countNode(root.right); // recursively count nodes

        }
    }

    // CALCUCATING HEIGHT OF BINARY TREE
    int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int left = height(root.left); // height of left subtree stored recursively
            int right = height(root.right); // height of right subtree stored recursively
            return 1 + Math.max(left, right); // return the largest between the two + 1
        }
    }

    // SEARCH FOR A KEY IN TREE
    boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        // check if root equals to key
        else if (root.data == key) {
            return true;
        } else {
            // check left and right subtrees
            if (search(root.left, key) || search(root.right, key)) {
                return true;
            }
        }
        return false;
    }

    // COUNT LEAVES
    int countLeaves(Node root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return countLeaves(root.left) + countLeaves(root.right);
        }
    }

    // COUNT INTERNAL NODES
    int internalNodesCount(Node root) {
        if (root == null) {
            return 0;
        }
        // if both children are null (hence, leaf), then return 0
        else if (root.left == null && root.right == null) {
            return 0;
        } else {
            return 1 + internalNodesCount(root.left) + internalNodesCount(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTreeBasic tree = new BinaryTreeBasic(); // because static main method cannot call non-static Node
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);

        System.out.print("Inorder: ");
        tree.printInorder(root);

        System.out.print("\nPreorder: ");
        tree.printPreorder(root);

        System.out.print("\nPostorder: ");
        tree.printPostorder(root);

        System.out.println("\nNumber of nodes: " + tree.countNode(root));

        System.out.println("Height of tree: " + tree.height(root));

        System.out.print("Enter number to be searched: ");
        int key = sc.nextInt();
        if (tree.search(root, key)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }

        System.out.println("Number of leaves: " + tree.countLeaves(root));

        System.out.println("Number of internal nodes: " + tree.internalNodesCount(root));

        sc.close();
    }
}
