package info.sandroalmeida.array;

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {

        if(array.length <= 2)
            return true;

        boolean increasing = false, decreasing = false;
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] < array[i+1])
                increasing = true;
            else if(array[i] > array[i+1])
                decreasing = true;
            else
                continue;
        }

        return increasing == true && decreasing == true ? false : true;
    }

    public static void main(String[] args) {
        int[] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println(isMonotonic(array));
    }
}
