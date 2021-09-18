package info.sandroalmeida.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutationsHelper(array, new ArrayList<>(), permutations);
        return permutations;
    }

    public static void getPermutationsHelper(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations){
        if(array.size() == 0 && currentPermutation.size() > 0) {
            permutations.add(currentPermutation);
        } else{
          for(int i = 0; i < array.size(); i++){
              List<Integer> newArray = new ArrayList<>(array);
              newArray.remove(i);
              List<Integer> newPermutation = new ArrayList<>(currentPermutation);
              newPermutation.add(array.get(i));
              getPermutationsHelper(newArray, newPermutation, permutations);
          }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = getPermutations(Arrays.asList(1, 2, 3));
        for(List<Integer> list: result)
            System.out.println("["+list.get(0)+", "+list.get(1)+", "+list.get(2)+"]");
    }
}
