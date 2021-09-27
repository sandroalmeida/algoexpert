package info.sandroalmeida.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RadixSort {

    public static ArrayList<Integer> radixSort(ArrayList<Integer> array) {

        if(array.isEmpty()) return array;
        int maxNumber = Collections.max(array);
        int digit = 0;
        while((maxNumber/ Math.pow(10, digit)) > 0){
            countingSort(array, digit);
            digit++;
        }

        return array;
    }

    public static void countingSort(ArrayList<Integer> array, int digit){
        int[] sortedArray = new int[array.size()];
        int[] countArray = new int[10];
        int digitColumn = (int) Math.pow(10, digit);
        for(int num: array){
            int countIndex = (num / digitColumn) % 10;
            countArray[countIndex]++;
        }
        for(int idx = 1; idx < 10; idx++){
            countArray[idx] += countArray[idx - 1];
        }
        for(int idx = array.size() - 1; idx > -1; idx--){
            int countIndex = (array.get(idx) / digitColumn) % 10;
            countArray[countIndex]--;
            int sortedIndex = countArray[countIndex];
            sortedArray[sortedIndex] = array.get(idx);
        }
        for(int idx = 0; idx < array.size(); idx++){
            array.set(idx, sortedArray[idx]);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList(Arrays.asList(8762, 654, 3008, 345, 87, 65, 234, 12, 2));
        ArrayList<Integer> result = radixSort(input);
    }
}
