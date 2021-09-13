package info.sandroalmeida.binaryTrees;

public class BinaryTreeDiameter {

    public static int binaryTreeDiameter(BinaryTree tree) {
        return traverse(tree).diameter;
    }

    public static NodeInfo traverse(BinaryTree node){
        if(node == null) return new NodeInfo(0, 0);

        NodeInfo nodeLeftInfo = traverse(node.left);
        NodeInfo nodeRightInfo = traverse(node.right);

        int maxPath = nodeLeftInfo.height + nodeRightInfo.height;
        int maxDiameter = Math.max(nodeLeftInfo.diameter, nodeRightInfo.diameter);
        int currentDiameter = Math.max(maxPath, maxDiameter);
        int currentHeight = Math.max(nodeLeftInfo.height, nodeRightInfo.height) + 1;

        return new NodeInfo(currentDiameter, currentHeight);
    }

    static class NodeInfo {
        public int diameter;
        public int height;

        public NodeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
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

        System.out.println(binaryTreeDiameter(root));
    }
}
