package info.sandroalmeida.famousAlgorithms;

public class KadanesAlgorithm {

    public static int kadanesAlgorithm(int[] array) {
        int max = array[0];
        int currentMax = array[0];

        for(int i = 1; i < array.length; i++){
            currentMax = Math.max(array[i], currentMax + array[i]);
            max = Math.max(currentMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        System.out.println(kadanesAlgorithm(input));
    }
}
