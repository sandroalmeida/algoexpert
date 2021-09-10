package info.sandroalmeida.stacks;

import java.util.ArrayList;
import java.util.Collections;

public class SunsetViews {

    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {

        ArrayList<Integer> result = new ArrayList<>();
        if(direction.equals("EAST")){
            int maxHeight = 0;
            for(int i = buildings.length - 1; i >= 0; i--){
                if(buildings[i] > maxHeight){
                    result.add(i);
                    maxHeight = buildings[i];
                }
            }
            Collections.reverse(result);
        }
        if(direction.equals("WEST")){
            int maxHeight = 0;
            for(int i = 0; i < buildings.length; i++){
                if(buildings[i] > maxHeight){
                    result.add(i);
                    maxHeight = buildings[i];
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] buildings = new int[] {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "WEST";
        /*
        *         #
        *         # # #
        *       # # # # # #   #
        *       # # # # # #   # #
        *       # # # # # # # # #
        * SUN   0 1 2 3 4 5 6 7 8  SUN
        * WEST                     EAST
        * */
        ArrayList<Integer> result = sunsetViews(buildings, direction);
        for(int i: result)
            System.out.println(i);

    }

}
