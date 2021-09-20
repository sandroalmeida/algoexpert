package info.sandroalmeida.recursion;

// array = [1, 2, 3, 4]
// [[],
// [1], [2], [3], [4],
// [1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4],
// [1, 2, 3], [1, 2, 4], [1, 3, 4], [2, 3, 4],
// [1, 2, 3, 4]]

import java.util.*;

public class Powerset {

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int number: array){
            int size = result.size();
            for(int i = 0; i < size; i++){
                List<Integer> newList = new ArrayList<>(result.get(i));
                newList.add(number);
                result.add(newList);
            }
        }

        return result;
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
