package info.sandroalmeida.searching;

public class QuickSelect {

    public static int quickSelect(int[] array, int k) {
        return quickSelect(array, k, 0, array.length - 1);
    }

    public static int quickSelect(int[] array, int k, int start, int end){
        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right){
            int leftNum = array[left];
            int rightNum = array[right];
            int pivotNum = array[pivot];
            if(leftNum >= pivotNum && rightNum < pivotNum)
                swap(array, left, right);
            if(leftNum <= pivotNum)
                left++;
            if(rightNum >= pivotNum)
                right--;
        }
        swap(array, right, pivot);

        if(right == k - 1)
            return array[right];
        else if(right < k)
            return quickSelect(array, k, right + 1, end);
        else
            return quickSelect(array, k, start, right - 1);
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 7, 6, 3};
        System.out.println(quickSelect(array, 3));
    }

}
