package info.sandroalmeida.array;

public class SubarraySort {

    public static int[] subarraySort(int[] array) {

        int maxNonSorted = Integer.MIN_VALUE;
        int minNonSorted = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++){
            if(!isSorted(i, array)){
                int current = array[i];
                if(current > maxNonSorted) maxNonSorted = current;
                if(current < minNonSorted) minNonSorted = current;
            }
        }

        int initialIndex = -1, finalIndex = -1;
        for(int i = 0; i < array.length; i++){
            int current = array[i];
            if(minNonSorted < current && initialIndex == -1)
                initialIndex = i;
            if(maxNonSorted < current && initialIndex != -1)
                finalIndex = i - 1;
            if(initialIndex != -1 && finalIndex != -1)
                break;
        }
        if(finalIndex == -1 && initialIndex == -1)
            return new int[]{ -1, -1 };
        else if(finalIndex == -1)
            return new int[]{initialIndex, array.length - 1};
        else
            return new int[]{initialIndex, finalIndex};
    }

    private static boolean isSorted(int index, int[] array){
        // last position
        if(index == array.length - 1){
            return array[index] >= array[index - 1];
        } else{
            if(index == 0)
                return array[index] <= array[index + 1];
            else
                return (array[index] >= array[index - 1]) && (array[index] <= array[index + 1]);
        }
    }

    public static void main(String[] args) {
        int[] result = subarraySort(new int[] {1, 2});
        for(int i: result)
            System.out.println(i);
    }

}
