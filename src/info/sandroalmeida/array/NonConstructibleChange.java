package info.sandroalmeida.array;

import java.util.Arrays;

public class NonConstructibleChange {

    public static int nonConstructibleChange(int[] coins) {

        Arrays.sort(coins);
        int currentChange = 0;

        for(int coin: coins){
            if(coin > currentChange + 1)
                return currentChange + 1;
            currentChange += coin;
        }
        return currentChange + 1;
    }

    public static void main(String[] args) {
        int[] input = new int[] {5, 7, 1, 1, 2, 3, 22};
        System.out.println(nonConstructibleChange(input));
    }
}
