package info.sandroalmeida.array;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {

        Map<Integer, Integer> mapSum = new HashMap<>();

        for(int i = 0; i < array.length; i++){
            int rest = targetSum - array[i];
            if(mapSum.containsKey(rest)){
                return new int[] {array[i], rest};
            }
            mapSum.put(array[i], rest);
        }

        return new int[0];
    }

    public static void main(String[] args) {

        int[] nums = {3, 5, -4, 8, 11, 1, -1, 6};
        int[] result = TwoNumberSum.twoNumberSum(nums, 10);
        System.out.println("[" + result[0] + ", " + result[1] + "]");

    }
}
