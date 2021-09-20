package info.sandroalmeida.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Powerset_Recursive {

    public static List<List<Integer>> powerset(List<Integer> array) {
        return powersetRecursive(array, array.size() - 1);
    }

    public static List<List<Integer>> powersetRecursive(List<Integer> array, int index){
        if(index < 0){
            List<List<Integer>> emptySet = new ArrayList<>();
            emptySet.add(new ArrayList<>());
            return emptySet;
        }
        int element = array.get(index);
        List<List<Integer>> subsets = powersetRecursive(array, index - 1);
        int size = subsets.size();
        for(int i = 0; i < size; i++){
            List<Integer> newSub = new ArrayList<>(subsets.get(i));
            newSub.add(element);
            subsets.add(newSub);
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = powerset(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        System.out.print('[');
        for(List<Integer> item: result){
            System.out.print('[');
            for(int i: item){
                System.out.print(i);
                System.out.print(' ');
            }
            System.out.print(']');
        }
        System.out.print(']');
    }
}
