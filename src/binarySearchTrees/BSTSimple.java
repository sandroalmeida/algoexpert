package binarySearchTrees;

public class BSTSimple {

    private int value;
    private BSTSimple left;
    private BSTSimple right;

    public BSTSimple(int value) {
        this.value = value;
    }

    public BSTSimple insert(int value, BSTSimple node) {
        if(value < node.value){
            if(node.left == null)
                node.left = new BSTSimple(value);
             else
                node.insert(value, node.left);
        } else{
            if(node.right == null)
                node.right = new BSTSimple(value);
            else
                node.insert(value, node.right);
        }
        return node;
    }

    public boolean contains(int value, BSTSimple node) {
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

    public void remove(int value, BSTSimple node) {
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

    private int getMinValue(BSTSimple node){
        if(node.left == null)
            return node.value;
        else
            return node.left.getMinValue(node.left);
    }

}
