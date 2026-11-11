public class BookBST {
    static class Node {
        int code;
        Node left, right;

        Node(int code) {
            this.code = code;
        }
    }

    static Node insert(Node root, int code) {
        if (root == null) {
            return new Node(code);
        }

        if (code < root.code) {
            root.left = insert(root.left, code);
        } else if (code > root.code) {
            root.right = insert(root.right, code);
        }

        return root;
    }

    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.code + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] bookCodes = {50, 30, 70, 20, 40, 60, 80};
        Node root = null;

        for (int code : bookCodes) {
            root = insert(root, code);
        }

        System.out.print("Book codes in inorder: ");
        inorder(root);
    }
}
