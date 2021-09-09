package info.sandroalmeida.binarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightSmallerThan {

    public static List<Integer> rightSmallerThan(List<Integer> array) {

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < array.size(); i++){
            int z = i + 1;
            int count = 0;
            while(z < array.size()){
                if(array.get(z) < array.get(i))
                    count++;
                z++;
            }
            result.add(count);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = rightSmallerThan(Arrays.asList(8, 5, 11, -1, 3, 4, 2));
        for(int i: result)
            System.out.println(i);
    }
}
