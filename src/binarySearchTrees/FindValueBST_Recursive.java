package binarySearchTrees;

public class FindValueBST_Recursive {

    static int closest;

    public static int findClosestValueInBst(BST tree, int target) {
        closest = Integer.MAX_VALUE;
        findValue(tree, target);
        return closest;
    }
    private static void findValue(BST tree, int target){
        int result = Math.abs(tree.value - target);
        if(result < Math.abs(closest - target))
            closest = tree.value;
        if(tree.left != null)
            findValue(tree.left, target);
        if(tree.right != null)
            findValue(tree.right, target);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST root = new FindValueBST_Recursive.BST(10);
        root.left = new FindValueBST_Recursive.BST(5);
        root.left.left = new FindValueBST_Recursive.BST(2);
        root.left.left.left = new FindValueBST_Recursive.BST(1);
        root.left.right = new FindValueBST_Recursive.BST(5);
        root.right = new FindValueBST_Recursive.BST(15);
        root.right.left = new FindValueBST_Recursive.BST(13);
        root.right.left.right = new FindValueBST_Recursive.BST(14);
        root.right.right = new FindValueBST_Recursive.BST(22);

        System.out.println(findClosestValueInBst(root, 12));
    }
}
