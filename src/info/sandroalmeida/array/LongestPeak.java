package info.sandroalmeida.array;

public class LongestPeak {

    public static int longestPeak(int[] array) {

        if(array.length < 3) return 0;

        int possible = 0;
        int maxLength = 0;
        boolean whenUpReset = false;

        for(int i = 0; i < array.length - 1; i++){
            // UP, DOWN, EMPTY
            String direction = array[i] > array[i+1] ? "DOWN" : array[i] < array[i+1] ? "UP" : "";
            if(direction.equals("UP") && !whenUpReset){
                possible++;
            } else if(direction.equals("UP") && whenUpReset){
                possible = 1;
                whenUpReset = false;
            } else if(direction.equals("DOWN") && possible > 0){
                possible++;
                whenUpReset = true;
                maxLength = Math.max(possible + 1, maxLength);
            } else{
                possible = 0;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(longestPeak(array));
    }

}
