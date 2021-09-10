package info.sandroalmeida.binarySearchTrees;

import java.util.Arrays;
import java.util.List;

public class MinHeightBST {

    public static BST minHeightBst(List<Integer> array) {
        return buildingMinHeightBST(array, null, 0, array.size() - 1);
    }

    public static BST buildingMinHeightBST(List<Integer> array, BST tree, int start, int end){
        if(start > end) return null;
        int middle = (end + start) / 2;
        if(tree == null)
            tree = new BST(array.get(middle));
        else
            tree.insert(array.get(middle));

        buildingMinHeightBST(array, tree, start, middle - 1);
        buildingMinHeightBST(array, tree, middle + 1, end);

        return tree;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        BST tree = minHeightBst(array);
    }
}
