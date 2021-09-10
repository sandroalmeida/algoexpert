package info.sandroalmeida.binaryTrees;

import java.util.Stack;

public class CompareLeafTraversal {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
        Stack<BinaryTree> stack1 = new Stack<>();
        stack1.push(tree1);
        Stack<BinaryTree> stack2 = new Stack<>();
        stack2.push(tree2);

        while(!stack1.empty() && !stack2.empty()){
            BinaryTree result1 = traverseTree(stack1);
            BinaryTree result2 = traverseTree(stack2);

            if((result1 == null && result2 != null) || (result1 != null && result2 == null))
                return false;
            if(result1.value != result2.value)
                return false;
        }
        return true;
    }

    private static BinaryTree traverseTree(Stack<BinaryTree> stack){
        while(!stack.empty()){
            BinaryTree currentNode = stack.pop();
            if(currentNode.left != null) stack.push(currentNode.left);
            if(currentNode.right != null) stack.push(currentNode.right);
            if(currentNode.left == null && currentNode.right == null)
                return currentNode;
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree(1);
        tree1.left = new BinaryTree(2);
        tree1.right = new BinaryTree(3);
        tree1.left.left = new BinaryTree(4);
        tree1.left.right = new BinaryTree(5);
        tree1.right.right = new BinaryTree(6);
        tree1.left.right.left = new BinaryTree(7);
        tree1.left.right.right = new BinaryTree(8);

        BinaryTree tree2 = new BinaryTree(1);
        tree2.left = new BinaryTree(2);
        tree2.right = new BinaryTree(3);
        tree2.left.left = new BinaryTree(4);
        tree2.left.right = new BinaryTree(7);
        tree2.right.right = new BinaryTree(5);
        tree2.right.right.left = new BinaryTree(8);
        tree2.right.right.right = new BinaryTree(6);

        System.out.println(compareLeafTraversal(tree1, tree2));
    }

}
