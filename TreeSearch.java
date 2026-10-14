import java.util.*;

public class TreeSearch {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSearch tree = new TreeSearch();

        // manually creating tree
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);

        System.out.print("Enter a key to be searched for: ");
        int key = sc.nextInt();

        if (tree.search(root, key)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
        sc.close();
    }
}
