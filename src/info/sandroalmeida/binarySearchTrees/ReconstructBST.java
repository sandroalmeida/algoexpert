package info.sandroalmeida.binarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value){
            this.value = value;
        }
    }

    static class RootIdx{
        public int root;
        public RootIdx(int root) {
            this.root = root;
        }
    }

    public static BST reconstructBst(List<Integer> preOrderTraversalValues) {
        RootIdx rootIdx = new RootIdx(0);
        return reconstructFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, rootIdx);
    }

    public static BST reconstructFromRange(int minValue, int maxValue, List<Integer> listValues, RootIdx rootIdx){
        if(rootIdx.root == listValues.size()) return null;

        int currentValue = listValues.get(rootIdx.root);
        if(currentValue < minValue || currentValue >= maxValue) return null;

        rootIdx.root += 1;
        BST leftRoot = reconstructFromRange(minValue, currentValue, listValues, rootIdx);
        BST rightRoot = reconstructFromRange(currentValue, maxValue, listValues, rootIdx);

        BST root = new BST(currentValue);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }

    public static void main(String[] args) {
        List<Integer> preOrderTraversalValues = new ArrayList<>(Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18));
        BST tree = reconstructBst(preOrderTraversalValues);
    }
}
