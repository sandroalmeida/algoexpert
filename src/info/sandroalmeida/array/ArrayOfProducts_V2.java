package info.sandroalmeida.array;

public class ArrayOfProducts_V2 {

    public static int[] arrayOfProducts(int[] array) {

        int[] productArray = new int[array.length];
        int totalProd = 1;
        for(int i: array)
            totalProd *= i;
        for(int i = 0; i <= array.length -1; i++){
            if(array[i] != 0){
                int currentProd = totalProd / array[i];
                productArray[i] = currentProd;
            } else{
                productArray[i] = 0;
            }
        }

        return productArray;

    }

    public static void main(String[] args) {
        int[] result = arrayOfProducts(new int[] {0,1,2,3,4,5,6,7,8,9});
        for(int i: result)
            System.out.println(i);
    }
}
