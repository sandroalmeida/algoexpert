package info.sandroalmeida.greedyAlgorithms;

import java.util.Arrays;

public class TandemBicycle {

    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        if(fastest){
            reverseArray(blueShirtSpeeds);
        }

        int sum = 0;
        for(int i = 0; i < blueShirtSpeeds.length; i++){
            sum += Math.max(blueShirtSpeeds[i], redShirtSpeeds[i]);
        }

        return sum;
    }

    public static void reverseArray(int[] array){
        int start = 0;
        int end = array.length - 1;
        while(start < end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
        System.out.println(tandemBicycle(redShirtSpeeds, blueShirtSpeeds, true));
    }
}
