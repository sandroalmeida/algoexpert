package info.sandroalmeida.binarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTs {

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

        if(arrayOne.size() != arrayTwo.size()) return false;
        if(arrayOne.isEmpty() && arrayTwo.isEmpty()) return true;
        if(arrayOne.get(0) != arrayTwo.get(0)) return false;

        List<Integer> leftOne = getSmaller(arrayOne);
        List<Integer> leftTwo = getSmaller(arrayTwo);
        List<Integer> rightOne = getBiggerOrEqual(arrayOne);
        List<Integer> rightTwo = getBiggerOrEqual(arrayTwo);

        return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
    }

    public static List<Integer> getSmaller(List<Integer> array){
        List<Integer> smaller = new ArrayList<>();
        for(int i = 1; i < array.size(); i++){
            if(array.get(i) < array.get(0))
                smaller.add(array.get(i));
        }
        return smaller;
    }

    public static List<Integer> getBiggerOrEqual(List<Integer> array){
        List<Integer> biggerOrEqual = new ArrayList<>();
        for(int i = 1; i < array.size(); i++){
            if(array.get(i) >= array.get(0))
                biggerOrEqual.add(array.get(i));
        }
        return biggerOrEqual;
    }

    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList<>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList<>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        System.out.println(sameBsts(arrayOne, arrayTwo));
    }
}
