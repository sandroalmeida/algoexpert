package info.sandroalmeida.graph;

import java.util.Arrays;

public class MinimumPassesOfMatrix {

    static int totalConversion;
    static boolean conversionCheck;
    static boolean hasNegativeNonConvert;

    public static int minimumPassesOfMatrix(int[][] matrix) {
        totalConversion = 0;
        do{
            int[][] matrixCopy = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
            executeMatrixConversion(matrix, matrixCopy);
            matrix = matrixCopy;
        } while(conversionCheck);

        return hasNegativeNonConvert? -1 : totalConversion;
    }

    public static void executeMatrixConversion(int[][] matrix, int[][] matrixCopy){
        conversionCheck = false;
        hasNegativeNonConvert = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int current = matrix[i][j];
                if(current < 0){
                    if(checkCanConvert(matrix, i, j)){
                        matrixCopy[i][j] = current * -1;
                        conversionCheck = true;
                    } else{
                        hasNegativeNonConvert = true;
                    }
                }
            }
        }
        if(conversionCheck) totalConversion++;
    }

    public static boolean checkCanConvert(int[][] matrix, int i, int j){
        if(j - 1 >= 0 && matrix[i][j - 1] > 0)
            return true;
        if(j + 1 < matrix[0].length && matrix[i][j + 1] > 0)
            return true;
        if(i - 1 >= 0 && matrix[i - 1][j] > 0)
            return true;
        if(i + 1 < matrix.length && matrix[i + 1][j] > 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 0, 0, -2, -3}, {-4, -5, -6, -2, -1}, {0, 0, 0, 0, -1}, {1, 2, 3, 0, -2}};
        System.out.println(minimumPassesOfMatrix(matrix));
    }

}
