package info.sandroalmeida.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortKSortedArray {
    public static int[] sortKSortedArray(int[] array, int k) {

        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for(int i = 0; i < Math.min(k + 1, array.length); i++)
            minHeap.add(array[i]);

        int nextIdxInsertion = 0;
        for(int idx = k + 1; idx < array.length; idx++){
            int minElement = minHeap.poll();
            array[nextIdxInsertion] = minElement;
            nextIdxInsertion++;

            int currentElement = array[idx];
            minHeap.add(currentElement);
        }

        while(!minHeap.isEmpty()){
            int minElement = minHeap.poll();
            array[nextIdxInsertion] = minElement;
            nextIdxInsertion++;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] input = new int[] {3, 2, 5, 1, 4, 7, 6, 5};
        int[] output = sortKSortedArray(input, 3);
    }

}
