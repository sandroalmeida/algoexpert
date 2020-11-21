package info.sandroalmeida.array;

import java.util.*;

public class ThreeNumberSum_V2 {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);

        int p1 = 0;
        while(p1 < array.length - 2){
            int n1 = array[p1];
            int subTarget = targetSum - n1;
            int p2 = p1 + 1, p3 = array.length - 1;
            while(p2 < p3){
                int n2 = array[p2];
                int n3 = array[p3];
                int subSum = n2 + n3;
                if(subSum == subTarget){
                    Integer[] triple = {n1, n2, n3};
                    Arrays.sort(triple);
                    result.add(triple);
                    p2++;
                    p3--;
                } else if(subSum < subTarget){
                    p2++;
                } else{
                    p3--;
                }
            }
            p1++;
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
