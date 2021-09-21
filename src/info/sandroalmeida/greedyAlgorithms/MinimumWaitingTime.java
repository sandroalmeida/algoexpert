package info.sandroalmeida.greedyAlgorithms;

import java.util.Arrays;

public class MinimumWaitingTime {

    public static int minimumWaitingTime(int[] queries) {

        int waitingTime = 0;
        int currentSum = 0;
        Arrays.sort(queries);

        for(int i = 0; i < queries.length - 1; i++){
            currentSum += queries[i];
            waitingTime += currentSum;
        }

        return waitingTime;
    }

    public static void main(String[] args) {
        int[] queries = new int[]{3, 2, 1, 2, 6};
        System.out.println(minimumWaitingTime(queries));
    }

}
