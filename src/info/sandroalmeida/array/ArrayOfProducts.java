package info.sandroalmeida.array;

public class ArrayOfProducts {

    public static int[] arrayOfProducts(int[] array) {

        int[] productArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            int currentProduct = 1;
            for(int j = 0; j < array.length; j++){
                if(i == j) continue;
                currentProduct *= array[j];
            }
            productArray[i] = currentProduct;
        }

        return productArray;
    }

    public static void main(String[] args) {
        int[] result = arrayOfProducts(new int[] {5, 1, 4, 2});
        for(int i: result)
            System.out.println(i);
    }
}
