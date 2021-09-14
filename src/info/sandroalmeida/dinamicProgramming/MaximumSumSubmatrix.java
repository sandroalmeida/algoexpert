package info.sandroalmeida.dinamicProgramming;

public class MaximumSumSubmatrix {

    public static int maximumSumSubmatrix(int[][] matrix, int size) {

        int rowStart = 0;
        int rowEnd = size - 1;
        int rows = matrix.length;
        int columns = matrix[0].length;

        int biggestSum = Integer.MIN_VALUE;

        while(rowEnd < rows){
            int colStart = 0;
            int colEnd = size - 1;
            while(colEnd < columns){
                int currentSum = submatrixSum(rowStart, rowEnd, colStart, colEnd, matrix);
                if(currentSum > biggestSum)
                    biggestSum = currentSum;
                colStart++;
                colEnd++;
            }
            rowStart++;
            rowEnd++;
        }

        return biggestSum;
    }

    public static int submatrixSum(int rowStart, int rowEnd, int colStart, int colEnd, int[][] matrix){
        int currentSum = 0;
        for(int i = rowStart; i <= rowEnd; i++){
            for(int j = colStart; j <= colEnd; j++){
                currentSum += matrix[i][j];
            }
        }
        return currentSum;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{5, 3, -1, 5}, {-7, 3, 7, 4}, {12, 8, 0, 0}, {1, -8, -8, 2}};
        int size = 2;
        System.out.println(maximumSumSubmatrix(matrix, size));
    }
}
