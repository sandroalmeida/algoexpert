package info.sandroalmeida.binaryTrees;

public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {

        //swap
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        //traverse
        if(tree.left != null) invertBinaryTree(tree.left);
        if(tree.right != null) invertBinaryTree(tree.right);

    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }

}
