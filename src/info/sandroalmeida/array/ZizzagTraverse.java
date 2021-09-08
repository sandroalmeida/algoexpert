package info.sandroalmeida.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZizzagTraverse {

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {

        List<Integer> result = new ArrayList<>();
        boolean isGoingDown = true;
        int R = 0, C = 0;
        int maxR = array.size() - 1;
        int maxC = array.get(0).size() - 1;

        while(R <= maxR && C <= maxC){

            // first store the element
            result.add(array.get(R).get(C));

            // pick right element, change to false and update C
            if(isGoingDown && R == maxR){
                C++;
                result.add(array.get(R).get(C));
                R--;
                C++;
                isGoingDown = false;
                continue;
            }
            // pick the below element, change to false and update R
            if(isGoingDown && C == 0){
                R++;
                result.add(array.get(R).get(C));
                R--;
                C++;
                isGoingDown = false;
                continue;
            }
            // only going down in the middle, just update R and C
            if(isGoingDown){
                R++;
                C--;
                continue;
            }
            // pick up below element, change to true and update R
            if(!isGoingDown && C == maxC){
                R++;
                result.add(array.get(R).get(C));
                C--;
                R++;
                isGoingDown = true;
                continue;
            }
            // pick up right element, change to true and update C
            if(!isGoingDown && R == 0){
                C++;
                result.add(array.get(R).get(C));
                C--;
                R++;
                isGoingDown = true;
                continue;
            }
            // only going up in the middle, just update R and C
            if(!isGoingDown){
                R--;
                C++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        List<List<Integer>> test = new ArrayList<List<Integer>>();
//        test.add(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 10)));
//        test.add(new ArrayList<Integer>(Arrays.asList(2, 5, 9, 11)));
//        test.add(new ArrayList<Integer>(Arrays.asList(6, 8, 12, 15)));
//        test.add(new ArrayList<Integer>(Arrays.asList(7, 13, 14, 16)));
//        List<Integer> result = zigzagTraverse(test);
//        for(int i: result)
//            System.out.print(i + " ");

        List<List<Integer>> test2 = new ArrayList<>();
        test2.add(new ArrayList<>(Arrays.asList(1, 3, 4, 10)));
        List<Integer> result2 = zigzagTraverse(test2);
        for(int i: result2)
            System.out.print(i + " ");
    }
}
