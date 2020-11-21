package info.sandroalmeida.array;

import java.util.*;

public class ThreeNumberSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        List<Integer[]> result = new ArrayList<>();
        int[] restNums = new int[array.length];
        for(int i = 0; i < array.length; i++){
            restNums[i] = targetSum - array[i];
        }

        for(int i = 0; i < restNums.length; i++){
            Set<Integer> restSet = new HashSet<>();

            for(int z = 0; z < array.length; z++){
                if(i == z) continue;
                if(restSet.contains(array[z])){
                    Integer[] triple = {targetSum - restNums[i], array[z], restNums[i] - array[z]};
                    Arrays.sort(triple);
                    if(!result.contains(triple)) result.add(triple);
                }
                restSet.add(restNums[i] - array[z]);
            }
        }

        return result.size() > 0 ? result : new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] array =  {12,3,1,2,-6,5,-8,6};
        List<Integer[]> result = threeNumberSum(array, 0);
        for(Integer[] item: result){
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(int i: item){
                sb.append(i);
                sb.append(",");
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }
}
