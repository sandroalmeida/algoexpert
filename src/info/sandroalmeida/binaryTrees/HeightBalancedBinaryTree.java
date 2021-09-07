package info.sandroalmeida.binaryTrees;

public class HeightBalancedBinaryTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public boolean isBalanced;
        public int height;

        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean heightBalancedBinaryTree(BinaryTree tree) {
        TreeInfo treeInfo = getTreeInfo(tree);
        return treeInfo.isBalanced;
    }

    private static TreeInfo getTreeInfo(BinaryTree node){
        if(node == null)
            return new TreeInfo(true, 0);

        TreeInfo leftSubtreeInfo = getTreeInfo(node.left);
        TreeInfo rightSubtreeInfo = getTreeInfo(node.right);

        boolean isBalanced = leftSubtreeInfo.isBalanced &&
                rightSubtreeInfo.isBalanced &&
                Math.abs(leftSubtreeInfo.height- rightSubtreeInfo.height) <= 1;
        int height = Math.max(leftSubtreeInfo.height, rightSubtreeInfo.height) + 1;
        return new TreeInfo(isBalanced, height);
    }

    public static void main(String[] args) {
        BinaryTree root;
        root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);

        System.out.println(heightBalancedBinaryTree(root));
    }

}
