package info.sandroalmeida.array;

import java.util.*;

public class FourNumberSum {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {

        Map<Integer, List<Integer[]>> allPairSums = new HashMap<>();
        List<Integer[]> quadruplets = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                int currentSum = array[i] + array[j];
                int difference = targetSum - currentSum;
                if(allPairSums.containsKey(difference)){
                    for(Integer[] pair: allPairSums.get(difference)){
                        Integer[] newQuadruplet = {pair[0], pair[1], array[i], array[j]};
                        quadruplets.add(newQuadruplet);
                    }
                }
            }
            for(int k = 0; k < i; k++){
                int currentSum = array[i] + array[k];
                Integer[] pair = {array[k], array[i]};
                if(!allPairSums.containsKey(currentSum)){
                    List<Integer[]> pairGroup = new ArrayList<>();
                    pairGroup.add(pair);
                    allPairSums.put(currentSum, pairGroup);
                } else{
                    allPairSums.get(currentSum).add(pair);
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        List<Integer[]> result = fourNumberSum(new int[] {7, 6, 4, -1, 1, 2}, 16);
        String quadruple = "(%s, %s, %s, %s)";
        for(Integer[] value: result){
            System.out.printf((quadruple) + "%n", value[0], value[1], value[2], value[3]);
        }
    }
}
