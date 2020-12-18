package info.sandroalmeida.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        List<Integer> copy = new ArrayList<>(array);

        int start = 0, end = array.size() - 1;
        while(start < end){
            if(copy.get(start) == toMove){
                copy.remove(start);
                copy.add(end, toMove);
                end--;
            } else{
                start++;
            }
        }

        return copy;
    }

    public static void main(String[] args) {
        Integer[] array = {2, 1, 2, 2, 2, 3, 4, 2};
        List<Integer> list = Arrays.asList(array.clone());
        System.out.println(moveElementToEnd(list, 2));
    }

}
