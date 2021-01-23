package info.sandroalmeida.sort;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {

        boolean isSorted = false;
        int iterationCount = 0;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - iterationCount; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            iterationCount++;
        }
        return array;
    }

    public static void swap(int[] array, int p1, int p2){
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }

    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        int[] output = bubbleSort(input);
        for(int i : output){
            System.out.println(i);
        }
    }
}
