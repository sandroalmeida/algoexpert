package info.sandroalmeida.searching;

public class IndexEqualsValue {

    public static int indexEqualsValue(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int possible = -1;

        while(start <= end){
            int middle = (start + end) / 2;
            int currentValue = array[middle];

            if(currentValue > middle){
                end = middle - 1;
            } else if(currentValue < middle){
                start = middle + 1;
            } else {
                if(middle > 0 && array[middle - 1] == middle - 1){
                    end = middle - 1;
                } else{
                    return middle;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexEqualsValue(new int[] {-5, -3, 0, 3, 4, 5, 9}));
    }
}
