package info.sandroalmeida.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static int productSum(List<Object> array) {
        return productSumRecursive(array, 1);
    }

    private static int productSumRecursive(List<Object> array, int level){
        int sum = 0;
        for(Object o: array){
            if(o instanceof Integer){
                sum += (int) o;
            }
            if(o instanceof List){
                sum += productSumRecursive((List) o, level+1);
            }
        }
        return sum * level;
    }

    public static void main(String[] args) {
        List<Object> test = new ArrayList<Object>(Arrays.asList(5, 2, new ArrayList<Object>(Arrays.asList(7, -1)), 3, new ArrayList<Object>( Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
        System.out.println(productSum(test));
    }
}
