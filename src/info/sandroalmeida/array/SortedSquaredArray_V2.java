package info.sandroalmeida.array;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortedSquaredArray_V2 {

    public static int[] sortedSquaredArray(int[] array) {

        int[] newArray = new int[array.length];
        int right = 0, left = array.length - 1, lastInsert = array.length - 1;

        while(right <= left){
            int s1 = array[right] * array[right];
            int s2 = array[left] * array[left];
            if(s1 > s2){
                newArray[lastInsert] = s1;
                right++;
            } else{
                newArray[lastInsert] = s2;
                left--;
            }
            lastInsert--;
        }

        return newArray;
    }

    public static void main(String[] args) {

        int[] array = new int[] {-2, 1, 2, 3, 5, 6, 8, 9};
        int[] newArray = sortedSquaredArray(array);
        for(int i : newArray)
            System.out.println(i);

    }
}
