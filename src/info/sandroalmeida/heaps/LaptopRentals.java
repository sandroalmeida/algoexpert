package info.sandroalmeida.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LaptopRentals {

    static int maxInUse = 0;

    public static int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        if(times.isEmpty()) return 0;
        times.sort(Comparator.comparingInt(a -> a.get(0)));
        ArrayList<ArrayList<Integer>> currentLaptopsInUse = new ArrayList<>();
        currentLaptopsInUse.add(times.get(0));
        maxInUse = 1;

        for(int i = 1; i < times.size(); i++){
            ArrayList<Integer> currentTime = times.get(i);
            checkInUseList(currentLaptopsInUse, currentTime);
        }

        return maxInUse;
    }

    public static void checkInUseList(ArrayList<ArrayList<Integer>> currentLaptopsInUse, ArrayList<Integer> currentTime){
        for(int i = 0; i < currentLaptopsInUse.size(); i++ ){
            ArrayList<Integer> inUse = currentLaptopsInUse.get(i);
            if(inUse.get(1) <= currentTime.get(0)){
                currentLaptopsInUse.remove(i);
            }
        }
        currentLaptopsInUse.add(currentTime);
        maxInUse = Math.max(maxInUse, currentLaptopsInUse.size());
    }

    public static void main(String[] args) {
        int[][] times = new int[][] {{0, 2}};
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        for (int[] time : times) {
            input.add(new ArrayList(Arrays.asList(time[0], time[1])));
        }
        System.out.println(laptopRentals(input));
    }
}
