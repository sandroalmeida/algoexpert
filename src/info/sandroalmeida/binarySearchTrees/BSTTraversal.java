package info.sandroalmeida.binarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class BSTTraversal {

    public static void inOrderTraverse(BST tree, List<Integer> array) {
        if(tree.left != null)
            inOrderTraverse(tree.left, array);
        array.add(tree.value);
        if(tree.right != null)
            inOrderTraverse(tree.right, array);
    }

    public static void preOrderTraverse(BST tree, List<Integer> array) {
        array.add(tree.value);
        if(tree.left != null) {
            preOrderTraverse(tree.left, array);
        }
        if(tree.right != null)
            preOrderTraverse(tree.right, array);
    }

    public static void postOrderTraverse(BST tree, List<Integer> array) {
        if(tree.left != null)
            postOrderTraverse(tree.left, array);
        if(tree.right != null) {
            postOrderTraverse(tree.right, array);
        }
        array.add(tree.value);
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
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.right = new BST(22);

        List<Integer> inOrder = new ArrayList<>();
        //{1, 2, 5, 5, 10, 15, 22});
        List<Integer> preOrder = new ArrayList<>();
        //{10, 5, 2, 1, 5, 15, 22});
        List<Integer> postOrder = new ArrayList<>();
        //{1, 2, 5, 5, 22, 15, 10});

        System.out.println("inOrder");
        inOrderTraverse(root, inOrder);
        for(int i: inOrder) System.out.println(i);

        System.out.println("preOrder");
        preOrderTraverse(root, preOrder);
        for(int i: preOrder) System.out.println(i);

        System.out.println("postOrder");
        postOrderTraverse(root, postOrder);
        for(int i: postOrder) System.out.println(i);
    }
}
