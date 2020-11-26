package info.sandroalmeida.searching;

import java.util.PriorityQueue;
import java.util.Queue;

public class ThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array){

        Queue<Integer> minHeap = new PriorityQueue<>((e1,e2) -> e1 - e2);
        for(int i: array){
            if(minHeap.size() < 3)
                minHeap.add(i);
            else{
                int current = minHeap.peek();
                if(i > current){
                    minHeap.poll();
                    minHeap.add(i);
                }
            }
        }
        int[] result = new int[3];
        result[0] = minHeap.poll();
        result[1] = minHeap.poll();
        result[2] = minHeap.poll();
        return result;
    }

    public static void main(String[] args) {
        int[] array = {141,1,17,-7,-17,-27,18,541,8,7,7};
        int[] result = findThreeLargestNumbers(array);
        for(int i: result)
            System.out.print(i + " ");
    }
}
