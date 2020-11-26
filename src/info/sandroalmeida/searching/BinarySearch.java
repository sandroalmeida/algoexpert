package info.sandroalmeida.searching;

public class BinarySearch {

    public static int binarySearch(int[] array, int target){

        int start = 0, end = array.length - 1;

        while(start <= end){
            int midPoint = (start + end)/2;
            int currentNum = array[midPoint];
            if(currentNum > target){
                end = midPoint - 1;
            } else if(currentNum < target){
                start = midPoint + 1;
            } else
                return midPoint;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 23, 25, 111};
        System.out.println(binarySearch(array, 111));
    }
}
