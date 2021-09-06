package info.sandroalmeida.array;

import java.util.Arrays;

public class LargestRange {

    public static int[] largestRange(int[] array) {

        if(array.length == 0) return new int[]{};

        Arrays.sort(array);
        int[] largest = new int[]{array[0], array[0]};
        int currentSize = 1;

        for(int i = 1; i < array.length; i++){
            if(array[i] == array[i-1] + 1 || array[i] == array[i-1]){
                currentSize++;
                if(currentSize > largest[1] - largest[0])
                    largest = new int[]{array[i - currentSize + 1], array[i]};
            } else{
                currentSize = 1;
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        int[] result = largestRange(new int[]{19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14});
        System.out.println(result[0] + "," + result[1]);
    }
}
