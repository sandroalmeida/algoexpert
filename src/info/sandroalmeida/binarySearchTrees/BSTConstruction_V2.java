package info.sandroalmeida.binarySearchTrees;

public class BSTConstruction_V2 {

    private int value;
    private BSTConstruction_V2 left;
    private BSTConstruction_V2 right;

    public BSTConstruction_V2(int value) {
        this.value = value;
    }

    public BSTConstruction_V2 insert(int value, BSTConstruction_V2 node) {
        if(value < node.value){
            if(node.left == null)
                node.left = new BSTConstruction_V2(value);
             else
                node.insert(value, node.left);
        } else{
            if(node.right == null)
                node.right = new BSTConstruction_V2(value);
            else
                node.insert(value, node.right);
        }
        return node;
    }

    public boolean contains(int value, BSTConstruction_V2 node) {
        if(value < node.value){
            if(node.left == null)
                return false;
            else
                return node.left.contains(value, node.left);
        } else if(value > node.value){
            if(node.right == null)
                return false;
            else
                return node.right.contains(value, node.right);
        } else{
            return true;
        }
    }

    public void remove(int value, BSTConstruction_V2 node) {
        if(value < node.value) {
            if (node.left != null)
                node.left.remove(value, node.left);
        } else if(value > node.value){
            if(node.right != null)
                node.right.remove(value, node.right);
        } else{
            if(node.left != null && node.right != null){
                node.value = node.right.getMinValue(node);
                node.right.remove(node.value, node);
            }
            // if node == null this is the root node
            else if(node == null){
                if(node.left != null){
                    node.value = node.left.value;
                    node.right = node.left.right;
                    node.left = node.left.left;
                } else if(node.right != null){
                    node.value = node.right.value;
                    node.left = node.right.left;
                    node.right = node.right.right;
                } else{
                    // single node; do nothing
                }
            }
        }
    }

    private int getMinValue(BSTConstruction_V2 node){
        if(node.left == null)
            return node.value;
        else
            return node.left.getMinValue(node.left);
    }

}
