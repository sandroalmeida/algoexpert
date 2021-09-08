package info.sandroalmeida.binarySearchTrees;

import java.util.Stack;

public class FindValueBST_Iterative {

   public static int findClosestValueInBst(BST tree, int target) {

        int closestValue = Integer.MAX_VALUE;
        BST closestNode = tree;
        Stack<BST> stack = new Stack<>();
        stack.push(tree);

        while(!stack.empty()){
            BST currentNode = stack.pop();
            int currentDiff = Math.abs(currentNode.value - target);
            if(currentDiff < closestValue){
                closestValue = currentDiff;
                closestNode = currentNode;
            }
            if(closestValue == 0) break;

            if(currentNode.right != null && target > currentNode.value)
                stack.push(currentNode.right);
            if(currentNode.left != null && target < currentNode.value)
                stack.push(currentNode.left);
        }
        return closestNode.value;
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
        BST root = new FindValueBST_Iterative.BST(10);
        root.left = new FindValueBST_Iterative.BST(5);
        root.left.left = new FindValueBST_Iterative.BST(2);
        root.left.left.left = new FindValueBST_Iterative.BST(1);
        root.left.right = new FindValueBST_Iterative.BST(5);
        root.right = new FindValueBST_Iterative.BST(15);
        root.right.left = new FindValueBST_Iterative.BST(13);
        root.right.left.right = new FindValueBST_Iterative.BST(14);
        root.right.right = new FindValueBST_Iterative.BST(22);

        System.out.println(findClosestValueInBst(root, 12));
    }
}
