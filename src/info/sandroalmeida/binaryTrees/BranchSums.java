package info.sandroalmeida.binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> list = new ArrayList<>();
        calculateBranchSum(root, 0, list);
        return list;
    }

    public static void calculateBranchSum(BinaryTree node, int sum, List<Integer> list){
        if(node == null) return;

        int newSum = sum + node.value;
        if(node.left == null && node.right == null){
            list.add(newSum);
            return;
        }

        if(node.left != null) calculateBranchSum(node.left, newSum, list);
        if(node.right != null) calculateBranchSum(node.right, newSum, list);

    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right.left = new BinaryTree(10);

        System.out.println(branchSums(root));
    }

}
