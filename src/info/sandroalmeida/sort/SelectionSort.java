package info.sandroalmeida.sort;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {

        int started = 0;
        while(started < array.length){
            int possibleSmaller = started;
            for(int z = started + 1; z < array.length; z++){
                if(array[z] < array[possibleSmaller]){
                    possibleSmaller = z;
                }
            }
            if(started != possibleSmaller)
                swap(array, started, possibleSmaller);
            started++;
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
        int[] output = selectionSort(input);
        for(int i : output){
            System.out.println(i);
        }
    }
}
