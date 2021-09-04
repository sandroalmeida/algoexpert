package info.sandroalmeida.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Sort the intervals by starting value
        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = sortedIntervals[0];
        result.add(currentInterval);

        for(int[] nextInterval: sortedIntervals) {
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];

            if(currentIntervalEnd >= nextIntervalStart){
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else{
                currentInterval = nextInterval;
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals =
                new int[][] {
                        {1, 2},
                        {3, 5},
                        {4, 7},
                        {6, 8},
                        {9, 10}
                };
        int[][] result = mergeOverlappingIntervals(intervals);
        for(int[] interval: result){
            System.out.println("(" + interval[0] + "," + interval[1] + ")");
        }
    }
}
