package info.sandroalmeida.array;

import java.util.Arrays;

public class SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int p1 = 0, p2 = 0, diff = Integer.MAX_VALUE;
        int[] result = new int[2];

        while(p1 < arrayOne.length && p2 < arrayTwo.length){
            int n1 = arrayOne[p1];
            int n2 = arrayTwo[p2];
            int currentDiff = Math.abs(n1 - n2);
            if(currentDiff < diff){
                result = new int[]{arrayOne[p1], arrayTwo[p2]};
                diff = currentDiff;
            }
            if(diff == 0) break;
            if(n1 < n2) p1++;
            else p2++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arrayOne = {-1,5,10,20,28,3};
        int[] arrayTwo = {26,134,135,15,17};
        int[] result = smallestDifference(arrayOne, arrayTwo);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
