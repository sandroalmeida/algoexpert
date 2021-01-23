package info.sandroalmeida.sort;

public class InsertionSort {

    public static int[] insertionSort(int[] array) {

        for(int i = 1; i < array.length; i++){
            int z = i;
            while(z > 0 && array[z] < array[z-1]){
                swap(array, z, z - 1);
                z--;
            }
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
        int[] output = insertionSort(input);
        for(int i : output){
            System.out.println(i);
        }
    }
}
