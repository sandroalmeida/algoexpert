package info.sandroalmeida.array;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortedSquaredArray {

    public static int[] sortedSquaredArray(int[] array) {

        Queue<Integer> result = new PriorityQueue<Integer>((v1, v2) -> v1 - v2);
        int[] newArray = new int[array.length];

        for(int i = 0 ; i < array.length; i++){
            int square = array[i] * array[i];
            result.add(square);
        }

        for(int i = 0; i < newArray.length; i++)
            newArray[i] = result.poll();

        return newArray;
    }

    public static void main(String[] args) {

        int[] array = new int[] {-2, 1, 2, 3, 5, 6, 8, 9};
        int[] newArray = sortedSquaredArray(array);
        for(int i : newArray)
            System.out.println(i);

    }
}
