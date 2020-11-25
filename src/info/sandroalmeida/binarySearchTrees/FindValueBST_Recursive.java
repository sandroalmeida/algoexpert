package info.sandroalmeida.binarySearchTrees;

public class FindValueBST_Recursive {

    public static int findClosestValueInBst(BST tree, int target) {
        return findValueRecursive(tree, target, tree.value);
    }
    private static int findValueRecursive(BST tree, int target, int closest){
        if(Math.abs(target - closest) > Math.abs(target - tree.value))
            closest = tree.value;

        if(target < tree.value && tree.left != null)
            return findValueRecursive(tree.left, target, closest);
        else if(target > tree.value && tree.right != null)
            return  findValueRecursive(tree.right, target, closest);
        else
            return closest;
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
