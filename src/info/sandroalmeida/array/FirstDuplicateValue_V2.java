package info.sandroalmeida.array;

public class FirstDuplicateValue_V2 {

    public static int firstDuplicateValue(int[] array) {

        for(int i = 0; i < array.length; i++){
            int relatedIndex = Math.abs(array[i]) - 1;
            if(array[relatedIndex] < 0)
                return  Math.abs(array[i]);
            else
                array[relatedIndex] *= -1;
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(firstDuplicateValue(new int[] {2, 1, 5, 2, 3, 3, 4}));
    }
}
