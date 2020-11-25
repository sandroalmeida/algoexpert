package info.sandroalmeida.binarySearchTrees;

import java.util.LinkedList;

public class FindValueBST_Iterative {

   public static int findClosestValueInBst(BST tree, int target) {

       BST currentNode = tree;
        LinkedList<BST> nodesQueue = new LinkedList<>();
        int diff = Integer.MAX_VALUE, closest = 0;

        while(currentNode != null){
            int currentDiff = Math.abs(target - currentNode.value);
            if(currentDiff < diff){
                if(currentDiff == 0) return currentNode.value;
                diff = currentDiff;
                closest = currentNode.value;
            }
            if(currentNode.left != null) nodesQueue.add(currentNode.left);
            if(currentNode.right != null) nodesQueue.add(currentNode.right);

            currentNode = nodesQueue.poll();
        }
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
