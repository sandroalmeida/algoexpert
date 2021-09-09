package info.sandroalmeida.binarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightSmallerThan_V2 {

    public static List<Integer> rightSmallerThan(List<Integer> array) {

        List<Integer> result = new ArrayList<>(array);
        int lastIndex = array.size() - 1;
        SpecialBST bst = new SpecialBST(array.get(lastIndex));
        result.set(lastIndex, 0);
        for(int i = array.size() - 2; i >= 0; i--){
            bst.insert(array.get(i), i, result);
        }
        return result;
    }

    static class SpecialBST {
        public int value;
        public SpecialBST left;
        public SpecialBST right;
        int leftCount;

        SpecialBST(int value){
            this.value = value;
            this.leftCount = 0;
            this.left = null;
            this.right = null;
        }

        public void insert(int value, int index, List<Integer> rightSmallerElements){
            insertHelper(value, index, rightSmallerElements, 0);
        }

        public void insertHelper(int value, int index, List<Integer> rightSmallerElements, int currentSmallerCount){
            if(value < this.value){
                leftCount++;
                if(left == null) {
                    left = new SpecialBST(value);
                    rightSmallerElements.set(index, currentSmallerCount);
                } else{
                    left.insertHelper(value, index, rightSmallerElements, currentSmallerCount);
                }
            } else{
                currentSmallerCount += leftCount;
                if(value > this.value)
                    currentSmallerCount++;
                if(right == null){
                    right = new SpecialBST(value);
                    rightSmallerElements.set(index, currentSmallerCount);
                } else {
                    right.insertHelper(value, index, rightSmallerElements, currentSmallerCount);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> result = rightSmallerThan(Arrays.asList(8, 5, 11, -1, 3, 4, 2));
        for(int i: result)
            System.out.println(i);
    }
}
