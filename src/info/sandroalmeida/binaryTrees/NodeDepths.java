package info.sandroalmeida.binaryTrees;

public class NodeDepths {

    static int depthSum = 0;

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int nodeDepths(BinaryTree root) {
        return calculateNodeDepthSum(root, 0);
    }

    public static int calculateNodeDepthSum(BinaryTree node, int depth){
        if(node == null) return 0;

        int left = calculateNodeDepthSum(node.left, depth + 1);
        int right = calculateNodeDepthSum(node.right, depth + 1);
        return depth + left + right;

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

        System.out.println(nodeDepths(root));
    }
}
