package info.sandroalmeida.searching;

public class SearchForRange {

    public static int[] searchForRange(int[] array, int target) {
        int[] result = new int[]{-1, -1};
        rangeBinarySearch(array, target, result, 0, array.length - 1, true);
        rangeBinarySearch(array, target, result, 0, array.length - 1, false);
        return result;
    }

    public static void rangeBinarySearch(int[] array, int target, int[] result, int left, int right, boolean goLeft){
        if(left > right) return;

        int middle = (left + right)/2;
        if(array[middle] < target)
            rangeBinarySearch(array, target, result, middle + 1, right, goLeft);
        else if(array[middle] > target)
            rangeBinarySearch(array, target, result, left, middle - 1, goLeft);
        else{
            if(goLeft){
                if(middle == 0 || array[middle - 1] != target)
                    result[0] = middle;
                else
                    rangeBinarySearch(array, target, result, left, middle - 1, goLeft);
            } else{
                if(middle == array.length - 1 || array[middle + 1] != target)
                    result[1] = middle;
                else
                    rangeBinarySearch(array, target, result, middle + 1, right, goLeft);
            }
        }
    }

    public static void main(String[] args) {
        int[] result = searchForRange(new int[] {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73}, 45);
        for(int i: result)
            System.out.println(i);
    }
}
