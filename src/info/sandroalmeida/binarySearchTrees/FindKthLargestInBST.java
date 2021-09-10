package info.sandroalmeida.binarySearchTrees;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargestInBST {

    public static int findKthLargestValueInBst(BST tree, int k) {

        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        traverseBST(tree, maxHeap);
        while(k > 1){
            maxHeap.poll();
            k--;
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    public static void traverseBST(BST node, Queue<Integer> maxHeap){
        if(node == null) return;

        maxHeap.add(node.value);
        if(node.left != null) traverseBST(node.left, maxHeap);
        if(node.right != null) traverseBST(node.right, maxHeap);
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
