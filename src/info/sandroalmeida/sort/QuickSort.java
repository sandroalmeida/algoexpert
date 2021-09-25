package info.sandroalmeida.sort;

public class QuickSort {

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int[] array, int start, int end){
        if(start >= end)
            return;
        int pivot = start;
        int left = start + 1;
        int right = end;

        while(right >= left){
            if(array[left] > array[pivot] && array[right] < array[pivot])
                swap(left, right, array);
            if(array[left] <= array[pivot])
                left++;
            if(array[right] >= array[pivot])
                right--;
        }
        swap(pivot, right, array);
        boolean leftSubarrayIsSmaller = right - 1 - start < end - right + 1;
        if(leftSubarrayIsSmaller){
            quickSort(array, start, right - 1);
            quickSort(array, right + 1, end);
        } else{
            quickSort(array, right + 1, end);
            quickSort(array, start, right - 1);
        }
    }

    public static void swap(int i, int j, int[] array){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        int[] result = quickSort(input);
    }
}
