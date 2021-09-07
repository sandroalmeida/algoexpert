package info.sandroalmeida.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinRewards {

    public static int minRewards(int[] scores) {

        int[] prizes = new int[scores.length];
        Arrays.fill(prizes, 1);

        for(int i = 0; i < prizes.length; i++)
            givePrize(i, scores, prizes);

        return IntStream.of(prizes).sum();
    }

    private static void givePrize(int C, int[] scores, int[] prizes){
        int L = C - 1, R = C + 1;
        if(L >= 0){
            if(scores[L] > scores[C]){
                if(prizes[L] < prizes[C] + 1) prizes[L] = prizes[C] + 1;
                givePrize(L, scores, prizes);
            }
        }
        if(R < scores.length){
            if(scores[R] > scores[C]){
                if(prizes[R] < prizes[C] + 1) prizes[R] = prizes[C] + 1;
                givePrize(R, scores, prizes);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(minRewards(new int[] {8, 4, 2, 1, 3, 6, 7, 9, 5}));
    }
}
