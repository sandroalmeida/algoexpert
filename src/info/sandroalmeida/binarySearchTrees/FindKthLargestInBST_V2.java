package info.sandroalmeida.binarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargestInBST_V2 {

    public static int findKthLargestValueInBst(BST tree, int k) {

        List<Integer> largestList = new ArrayList<>();
        reverseOrderTraverseBST(tree, largestList, k);
        return largestList.get(k - 1);
    }

    public static void reverseOrderTraverseBST(BST node, List<Integer> largestList, int k){
        if(node == null || largestList.size() == k) return;

        if(node.right != null) reverseOrderTraverseBST(node.right, largestList, k);
        largestList.add(node.value);
        if(node.left != null) reverseOrderTraverseBST(node.left, largestList, k);
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST root = new BST(15);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.left.right = new BST(3);
        root.left.right = new BST(5);
        root.right = new BST(20);
        root.right.left = new BST(17);
        root.right.right = new BST(22);
        int k = 3;
        System.out.println(findKthLargestValueInBst(root, k));
    }
}
