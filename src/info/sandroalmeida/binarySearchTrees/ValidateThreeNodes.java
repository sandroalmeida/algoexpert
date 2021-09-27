package info.sandroalmeida.binarySearchTrees;

public class ValidateThreeNodes {

    public static boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        if(isDescendant(nodeOne, nodeTwo) && isDescendant(nodeTwo, nodeThree))
            return true;
        if(isDescendant(nodeThree, nodeTwo) && isDescendant(nodeTwo, nodeOne))
            return true;
        return false;
    }

    public static boolean isDescendant(BST node, BST target){
        while(node != null && node != target){
            if(target.value < node.value)
                node = node.left;
            else
                node = node.right;
        }
        return node == target;
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
        BST root = new BST(5);
        root.left = new BST(2);
        root.right = new BST(7);
        root.left.left = new BST(1);
        root.left.right = new BST(4);
        root.right.left = new BST(6);
        root.right.right = new BST(8);
        root.left.left.left = new BST(0);
        root.left.right.left = new BST(3);

        BST nodeOne = root;
        BST nodeTwo = root.left;
        BST nodeThree = root.left.left;

        System.out.println(validateThreeNodes(nodeOne, nodeTwo, nodeThree));
    }
}
