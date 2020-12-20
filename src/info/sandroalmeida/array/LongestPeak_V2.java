package info.sandroalmeida.array;

public class LongestPeak_V2 {

    public static int longestPeak(int[] array) {

        int maxLength = 0;
        for(int i = 1; i < array.length - 1; i++){

            boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];
            if(!isPeak)
                continue;

            int leftLength = 1;
            int leftIdx = i;
            while(leftIdx - 1 >= 0 && array[leftIdx - 1] < array[leftIdx]){
                leftLength++;
                leftIdx--;
            }

            int rightLength = 1;
            int rightIdx = i;
            while(rightIdx + 1 <= array.length - 1 && array[rightIdx + 1] < array[rightIdx]){
                rightLength++;
                rightIdx++;
            }

            maxLength = Math.max(leftLength + rightLength - 1, maxLength);

        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(longestPeak(array));
    }

}
