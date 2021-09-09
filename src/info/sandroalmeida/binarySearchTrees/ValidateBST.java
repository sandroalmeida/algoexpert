package info.sandroalmeida.binarySearchTrees;

public class ValidateBST {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static boolean validateBst(BST tree) {
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;

        return validateBstRecursive(tree, min, max);
    }

    private static boolean validateBstRecursive(BST node, int min, int max){
        if(node.value < min || node.value >= max)
            return false;

        if(node.left != null && !validateBstRecursive(node.left, min, node.value)){
            return false;
        }
        if(node.right != null && !validateBstRecursive(node.right, node.value, max)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);
        System.out.println(validateBst(root));
    }
}
