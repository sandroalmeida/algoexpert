package info.sandroalmeida.binaryTrees;

public class FindSuccessor {

    public static BinaryTree findSuccessor(BinaryTree node) {
        if(node.right != null) return getLeftMostChild(node.right);
        return getRightMostParent(node);
    }

    public static BinaryTree getLeftMostChild(BinaryTree node){
        BinaryTree currentNode = node;
        while(currentNode.left != null)
            currentNode = currentNode.left;
        return currentNode;
    }

    public static BinaryTree getRightMostParent(BinaryTree node){
        BinaryTree currentNode = node;
        while(currentNode.parent != null && currentNode.parent.right == currentNode)
            currentNode = currentNode.parent;
        return currentNode.parent;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.parent = root;
        root.right = new BinaryTree(3);
        root.right.parent = root;
        root.left.left = new BinaryTree(4);
        root.left.left.parent = root.left;
        root.left.right = new BinaryTree(5);
        root.left.right.parent = root.left;
        root.left.left.left = new BinaryTree(6);
        root.left.left.left.parent = root.left.left;
        BinaryTree node = root.left.right;
        BinaryTree result = findSuccessor(node);
        System.out.println(result.value);
    }
}
