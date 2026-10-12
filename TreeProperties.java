public class TreeProperties {
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

    // COUNTING NODES
    int countNodes(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right); // recursively count nodes

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
    int countInternalNodes(Node root) {
        if (root == null) {
            return 0;
        }
        // if both children are null (hence, leaf), then return 0
        else if (root.left == null && root.right == null) {
            return 0;
        } else {
            return 1 + countInternalNodes(root.left) + countInternalNodes(root.right);
        }
    }

    public static void main(String[] args) {
        TreeProperties tree = new TreeProperties();

        // manually creating tree
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);

        // calling method functions
        System.out.println("Number of nodes: " + tree.countNodes(root));
        System.out.println("Height of tree: " + tree.height(root));
        System.out.println("Number of leaves: " + tree.countLeaves(root));
        System.out.println("Number of internal nodes: " + tree.countInternalNodes(root));
    }
}
